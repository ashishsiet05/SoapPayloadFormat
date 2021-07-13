package in.goindigo.webservices.ehd;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.CxfPayload;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.headers.Header;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.staxutils.StaxUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CXFPayloadConvertor implements Processor {
    Logger log = LoggerFactory.getLogger(CXFPayloadConvertor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
         String CxfHeader=exchange.getContext().resolvePropertyPlaceholders("{{CXFHeader}}");;
        log.info("header passed in WSDL="+CxfHeader);
        List<Source> elements = new ArrayList<Source>();
        elements.add(new DOMSource(StaxUtils.read(new StringReader(body)).getDocumentElement()));
        final List<SoapHeader> headers = new ArrayList<SoapHeader>();
        headers.add(new SoapHeader(new QName("urn:IG:EHD:ViewIncidentList","AuthenticationInfo"), StaxUtils.read(new StringReader(CxfHeader)).getDocumentElement()));
        final CxfPayload<SoapHeader> cxfPayload = new CxfPayload<SoapHeader>(headers, elements, null);
        exchange.getIn().setBody(cxfPayload);
        exchange.getIn().setHeader(CxfConstants.OPERATION_NAME, "New_GetList_Operation_1");
        exchange.getIn().setHeader(Header.HEADER_LIST, headers);
    }
}
