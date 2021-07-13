package in.goindigo.webservices.ehd;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.camel.Converter;
import org.apache.camel.component.cxf.CxfPayload;
import org.apache.cxf.binding.soap.SoapHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


@Converter
public class AdditionalCxfPayloadConverters {
	 static Logger log = LoggerFactory.getLogger(AdditionalCxfPayloadConverters.class);
	 private static javax.xml.parsers.DocumentBuilderFactory b = javax.xml.parsers.DocumentBuilderFactory.newInstance();
  
    @Converter
    public static CxfPayload<SoapHeader> toCxfPayload(String xml) {
        // System.out.println("To CxfPayload " + xml);
        List<Element> elements = new ArrayList<Element>();
        try {
            Document doc = b.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
            elements.add(doc.getDocumentElement());
        } catch (Exception ex) {
            log.warn("Exception while converting String payload to CxfPayload; resulting payload will be empty.");
        }
        // The CxfPayload is changed to use Source object under layer, the elements API only work if we already setup the list before creating the CxfPayload
        CxfPayload<SoapHeader> ret = new CxfPayload<SoapHeader>(null, elements);
        return ret;
    }
   
}
