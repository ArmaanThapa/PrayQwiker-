/*package com.qwikr.webapi.merchantImpl;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;

import com.qwikr.webapi.controller.merchant.api.MerchantApi;
import com.qwikr.webapi.dto.MerchantDTO;
import com.qwikr.webapi.dto.MerchantResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


@Controller
public class MerchentImpl implements MerchantApi
{
	@Override
	public MerchantResponse pay(MerchantDTO dto)
	{
		MerchantResponse response=new MerchantResponse();
		JSONObject obj=new JSONObject();
		try {
			obj.put("amount", dto.getAmount());
			obj.put("transactionID", dto.getTransactionID());
			obj.put("hash", dto.getHash());
			obj.put("id", dto.getId());
			obj.put("additionalInfo", dto.getAdditionalInfo());
			
			Client  client =Client.create();
			WebResource resource=client.resource("https://www.vpayqwik.com/ws/api/auth");
			ClientResponse clientResponse=resource.accept("application/json").type("application/json")
					.header("hash", value).post(ClientResponse.class,obj);
			
			String output=clientResponse.getEntity(String.class);
			System.out.println(output);
			if (clientResponse.getStatus()!=200) {
				throw new RuntimeException("Failed : HTTP error code : " + clientResponse.getStatus());
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return response; 
	}

}*/
