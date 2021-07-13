package in.goindigo.webservices.ehd;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utilities {
	Logger log = LoggerFactory.getLogger(Utilities.class);
	public void setEmptyBody(Exchange exchange) {
		exchange.getIn().setBody("<Login></Login>");
	}

}
