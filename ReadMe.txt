##########BMC_Wrapper############

BA=Puneet Ahuja
Developer=Bikash Kaushik

ProjectName=EHD_Integration

ROLE=ROLE_EHDIntegration

#######
Method =POST
Service Port=8335

#####
1. Url=https://esbservicesuat.goindigo.in/api/EHD/CreateService
Input Details=
{
  "Department_Resolver":"Admin",
  "Query":"Cab",
  "Sub_Query":"Cab Booking",
  "First_Name": "Prakash",
  "Impact": "3-Moderate/Limited",
  "Last_Name": "choudhary",
  "Reported_Source": "Web",
  "Service_Type": "Infrastructure Event",
  "Status": "New",
  "Action": "Create",
  "Summary": "Test from ESB API",
  "Urgency": "3-Medium",
  "Work_Info_Summary": "EHD",
  "Work_Info_Notes": "EHD",
  "Work_Info_Type": "General Access",
  "Work_Info_View_Access": "Internal",
  "WorkInfoAttachment1Name": "EHD SERVICE INTEGRATION.docx",
  "WorkInfoAttachment1Data": "UEsDBBQABgAIAAAAIQCj77sdZQEAAFIFAAATAAgCW0Nvbn",
  "WorkInfoAttachment1OrigSize": "268720",
  "Login_ID": "prakash.x.choudhary@indigo.in"
}

2. Url=https://esbservicesuat.goindigo.in/api/EHD/GetGroupName

Input Details :
{
  "LoginID": "prakash.x.choudhary@indigo.in"
}


{
  "Support_Group_Name": "6epeople"
}

3. Url=https://esbservicesuat.goindigo.in/api/EHD/GetUserDetail

Input Details :
{
  "LoginID": "prakash.x.choudhary@indigo.in"
}


4. Url=https://esbservicesuat.goindigo.in/api/EHD/GetQueryDetail
There are multiple inputs :
Input Details :
a) To get Incident details 
{
  "Incident_Number": "INC000000193544"
}

b) To get incident details based on Requestor : 
{
  "Customer_LoginID": "prakash.x.choudhary@indigo.in"
}

c) To get incident details based on Assigned_Group : 
{
  "Assigned_Group": "Cab-Cab Booking"
}

d) To get incident details based on Resolver : 
{
  "Assignee_LoginID": "chunky.x.yadav@indigo.in"
}
or
{
  "Assignee_LoginID": "prakash.x.choudhary@indigo.in",
  "EHD_Status":"Resolved"
}


5. Url = https://esbservicesuat.goindigo.in/api/EHD/ModifyIncident
 There are multiple condition to modify incident :
a) To modify incident :
{
  "Status": "In Progress",
  "Department":"HR",
  "Query":"New Joinee",
  "Sub_Query":"Email ID related",
  "Incident_Number":"INC000000193641",
  "Resolution":"",
   "Resolution_Category_1":"EHD",
   "Resolution_Category_2":"EHD",
   "Resolution_Category_3":"EHD",
   "Assignee":"Chunky Yadav",
   "Assignee_Login_ID":"chunky.x.yadav@indigo.in",
   "Status_Reason":"No further action required"
}

b) To reopen incident (If incident is in "Resolved" Status) :
{
  "Status": "In Progress",
  "Incident_Number":"INC000000193641",
  "EHD_Reason":"Ticket has been Reopened",
  "EHD_Status":"Reopen"
}

c) To modify attachment of incident :
{
  "Incident_Number": "INC000000199136",
  "Work_Info_Summary":"EHD",
  "Work_Info_Notes":"EHD",
  "WorkInfoAttachment1Name":"EHD SERVICE INTEGRATION.docx",
  "WorkInfoAttachment1Data":"UEsDBBQABgAIAAAAIQCj7",
  "WorkInfoAttachment1OrigSize":"268720"
}

d) For Cancellation of incident :
{
  "Status": "Cancelled",
  "Incident_Number": "INC000000207958",
  "Cancellation_Reason" : "Cancelled"
  }

e) TO modify Subject,Body, TO and CC
{
  "Incident_Number": "INC000000247890",
  "Subject": "Testing Subject INC000000247890",
  "Body": "Testing Body INC000000247890",
  "To": "prakash.x.choudhary@goindigo.in",
  "CC": "Puneet.x.ahuja@goindigo.in"
}

6. https://esbservicesuat.goindigo.in/api/EHD/GetGroupsIncident
Input Details :
a) For Single Group :
{
  "Assigned_Group": ["Cab-Cab Booking"]
}

b) For Multiple Group :
{
  "Assigned_Group": ["Cab-Cab Booking","New Joinee- Email ID related"]
}
or
{
  "Assigned_Group": ["6ePeople","iCare"],
  "EHD_Status":"Resolved"
}

7. https://esbservicesuat.goindigo.in/api/EHD/GetIncidentAttachment
Input Details :
{
  "Incident_Number": "INC000000195597"
}

8. https://esbservicesuat.goindigo.in/api/EHD/GetEmailLog
Input Details :
{
  "Incident_Number": "INC000000199189"
}

9. https://esbservicesuat.goindigo.in/api/EHD/GetOutgoingEmail
Input Details :
{
  "Incident_Number": "INC000000207786"
}

10. https://esbservicesuat.goindigo.in/api/EHD/GetEmailArchive
{
	"Incident_Number":"INC000000246474"
}

11. https://esbservicesuat.goindigo.in/api/EHD/GetAuditRecord
{
  "Incident_Number": "INC000000000001"
}

12. https://esbservicesuat.goindigo.in/api/EHD/GetDepartment
{
  "Department": "Human Resources"
}

13. https://esbservicesuat.goindigo.in/api/EHD/GetEmailAttachment
{
  "Incident_Number": "INC000001903042",
  "Created_Date":"2019-07-16T17:39:35+05:30"
}
Bundle Name=Indigo :: Bundle :: Camel OSGi Bundle for EHD_Integration
