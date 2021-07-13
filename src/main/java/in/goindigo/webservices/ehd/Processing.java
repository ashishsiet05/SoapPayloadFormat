package in.goindigo.webservices.ehd; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.log4j.Logger;


public class Processing {

	private static final transient Logger LOGGER = Logger.getLogger(Processing.class);

	/*
         *This method is used to filter SupportGroup and LoginID from wsdl output
         *
         *@param Exchange exchange has exchange value
         *@author Bikash
         */
	public void getGroup(Exchange exchange){
	
		if(exchange.getIn().getBody() instanceof Map){
             	    Map<String, Object> body = (Map)exchange.getIn().getBody();
		    Map<String, Object> response = new HashMap();
		    List<Map<String, Object>> responsebody = new ArrayList();
                    for (Map.Entry<String, Object> entry : body.entrySet())
                    {
			if(entry.getKey().equals("Support_Group_Name")){
                                  response.put(entry.getKey(),entry.getValue());
                        } else  if(entry.getKey().equals("Remedy_Login_ID")){
                                  response.put(entry.getKey(),entry.getValue());
                        } else  if(entry.getKey().equals("Full_Name")){
                                  response.put(entry.getKey(),entry.getValue());
                        }
		    }
		    responsebody.add(response);
                    exchange.getOut().setBody(responsebody);
            }

	    if(exchange.getIn().getBody() instanceof List<?>){

                 List<Map<String, Object>> body = (List)exchange.getIn().getBody();

                 Map<String, Object> map = new HashMap();
                 List<Map<String, Object>> responsebody = new ArrayList();

                 for(int j = 0;j<body.size();j++){

                     Map<String, Object> response = new HashMap();
                     map = body.get(j);

                     for (Map.Entry<String, Object> entry : map.entrySet())
                     {
			if(entry.getKey().equals("Support_Group_Name")){
                               response.put(entry.getKey(),entry.getValue());
                        } else  if(entry.getKey().equals("Remedy_Login_ID")){
                                  response.put(entry.getKey(),entry.getValue());
                        } else  if(entry.getKey().equals("Full_Name")){
                                  response.put(entry.getKey(),entry.getValue());
                        }
 		     }
                     responsebody.add(response);
                 }
                 exchange.getOut().setBody(responsebody);
           }

        }

	/*
	 *This method is used to replace some value from wsdl output
 	 *
 	 *@param Exchange exchange has exchange value
	 *@author Bikash
	 */
        public void replaceData(Exchange exchange){


            if(exchange.getIn().getBody() instanceof Map){
                 Map<String, Object> body = (Map)exchange.getIn().getBody();

                 for (Map.Entry<String, Object> entry : body.entrySet())
                 {
                        if(entry.getValue() instanceof Map && entry.getValue() != null){
                                body.put(entry.getKey(),"");
                        } else {
                                body.put(entry.getKey(),entry.getValue());
                        }
                 }
                 exchange.getOut().setBody(body);
            }

            if(exchange.getIn().getBody() instanceof List<?>){

                List<Map<String, Object>> body = (List)exchange.getIn().getBody();
                Map<String, Object> map = new HashMap();
		List<Map<String, Object>> responsebody = new ArrayList();

                 for(int j = 0;j<body.size();j++){

                     Map<String, Object> response = new HashMap();
                     map = body.get(j);

                     for (Map.Entry<String, Object> entry : map.entrySet())
                     {
                         
                        if(entry.getValue() instanceof Map && entry.getValue() != null){
                                response.put(entry.getKey(),"");
                        } else {
                                response.put(entry.getKey(),entry.getValue());
                        }
                     }
                     responsebody.add(response);
                 }
                 exchange.getOut().setBody(responsebody);
           }

       }
	
	/*
         *This method is used for customizing Multiple Assigned Group SOAP request
         *
         *@param Exchange exchange has exchange value
         *@author Bikash
         */
	public void getAssignedGroup(Exchange exchange){	

		Map<String,Object> mapBody = exchange.getIn().getBody(Map.class);
		List<String> list = (List)mapBody.get("Assigned_Group");
		String str = null;
		Map<String,Object> response = new HashMap<String, Object>();
		StringBuffer assign = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			
			if(list.size() == 1){
				str = "'Assigned Group'=\""+list.get(i)+"\"";
				assign.append(str);
			} else{
				str = "'Assigned Group'=\""+list.get(i)+"\" or ";
				assign.append(str);
			}			
		}
		if(assign.lastIndexOf("or") != -1) {
			assign.delete(assign.lastIndexOf("or"), assign.lastIndexOf("or")+2);
		}
		response.put("assigned_group",assign);
                if(mapBody.containsKey("Search_Field")){
                        response.put("search_field",mapBody.get("Search_Field").toString());
                }
		if(mapBody.containsKey("EHD_Status")){
			response.put("ehd_status",mapBody.get("EHD_Status").toString());
		}
		if(mapBody.containsKey("StartRecord")){
			response.put("startrecord",mapBody.get("StartRecord").toString());
		}
		if(mapBody.containsKey("MaxLimit")){
			response.put("maxlimit",mapBody.get("MaxLimit").toString());
		}
		exchange.getIn().setBody(response);
	}

	/*
         *This method is used to filter Attachment data from wsdl output
         *
         *@param Exchange exchange has exchange value
         *@author Bikash
         */
	public void getAttachment(Exchange exchange){
		LOGGER.info("Attachment Name :"+exchange.getIn().getHeader("AttachmentName",String.class));
		if(exchange.getIn().getBody() instanceof Map){
			Map<String, Object> map = exchange.getIn().getBody(Map.class);
                	List finalBody = new ArrayList<>();				

			if(map.containsKey("z2AF_Work_Log01_attachmentName") || map.containsKey("z2AF_Work_Log02_attachmentName")){
                                finalBody.add(map);
                        }
			exchange.getIn().setBody(finalBody);
		}

		if(exchange.getIn().getBody() instanceof List<?>){
			List<Map<String, Object>> list = exchange.getIn().getBody(List.class);
			List finalBody = new ArrayList<>();
			Map<String, Object> map = new HashMap<String, Object>();
			
			for(int i =0; i < list.size(); i++ ) {
				map = (Map<String, Object>) list.get(i);
				if(map.containsKey("z2AF_Work_Log01_attachmentName") || map.containsKey("z2AF_Work_Log02_attachmentName")){
					finalBody.add(map);
				}
			}
			exchange.getIn().setBody(finalBody);
		}
	}

	/*
         *This method is used to filter Email Log from wsdl output
         *
         *@param Exchange exchange has exchange value
         *@author Bikash
         */
	public void getWorkLog(Exchange exchange){

		if(exchange.getIn().getBody() instanceof Map){
                        List finalBody = new ArrayList<>();
			finalBody.add(exchange.getIn().getBody(Map.class));
                        exchange.getIn().setBody(finalBody);
                }
        }
}
