function GetXmlHttpObject(){
	var xmlHttp=null;
try{
  xmlHttp=new XMLHttpRequest();
 }
catch (e) {
 try {
  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  }
 catch (e){
  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
 }
return xmlHttp;
}
	
function getXmlHttpObjectResponse(url,ReqMode,queryString,responseType,responseHandlerMethodName){
var xmlHttp=null;
	xmlHttp=GetXmlHttpObject();
	
	if(xmlHttp==null){
		alert("Unable to create xmlHttp");
	     }
	else{
	xmlHttp.onreadystatechange = function()
	{
		if(xmlHttp.readyState==4){ 
			if (xmlHttp.status == 200)
			{
				try
				{
					if(responseHandlerMethodName == null || responseHandlerMethodName.length == 0)
						responseHandlerMethodName = "handleXMLHttpData";
					
					if(responseType == null || responseType.toUpperCase() == "XML")
						eval(responseHandlerMethodName + "(xmlHttp.responseXML)");
					else if(responseType.toUpperCase() == "TEXT"){
						eval(responseHandlerMethodName + "(xmlHttp.responseText)");
					
						}
					
				}
				catch (e)
				{
					xmlHttp = null;
					//clearStatusMsg();
					throw e;
				}

				xmlHttp = null;


				//??vAjaxShowStatusMsgFlag = true;
			}
			else if (xmlHttp.status == 204)
			{
				//clearStatusMsg();
				//??
			}
		}
	}
	
		xmlHttp.open(ReqMode,url, true);

		if(ReqMode.toUpperCase() == "POST")
		{
			xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			xmlHttp.send(queryString);
		}
		else
		{
			xmlHttp.send(null);
		}
		
	}
	return true;
}

/*function handleXMLHttpData( RespXML )
{
	alert("Please overload the function  handleXMLHttpData( vRespXML ) of Ajax.js to handle the response XML");
}
function convertTextIntoXML(txt)
{
	var xmlDoc;
	
	if(window.DOMParser)
	{
		var parser = new DOMParser();
		xmlDoc = parser.parseFromString(txt, "text/xml");
	}
	else
	{
		xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.async = false;
		xmlDoc.loadXML(txt);
	}
	
	return xmlDoc;
}*/