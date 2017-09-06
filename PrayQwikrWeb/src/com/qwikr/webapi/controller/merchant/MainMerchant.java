package com.qwikr.webapi.controller.merchant;

/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qwikr.webapi.controller.merchant.api.MerchantApi;
import com.qwikr.webapi.dto.MerchantDTO;

import com.qwikr.webapi.dto.MerchantResponse;

@Controller
public class MainMerchant 
{
	 MerchantApi  merchantApi;
	
	public MainMerchant(MerchantApi merchantApi) 
	{
		this.merchantApi=merchantApi;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/")
	public String pay(@ModelAttribute (value="merch")MerchantDTO dto,HttpServletRequest request,HttpServletResponse response, 
			ModelMap map,HttpSession session)
	{
		HttpSession sessionID=request.getSession();
		
		
		MerchantRequest request2=new MerchantRequest();
		request2.setAmount(dto.getAmount());
		request2.setAdditionalInfo(dto.getAdditionalInfo());
		request2.setHash(dto.getHash());
		request2.setId(dto.getId());
		request2.setTransactionID(dto.getTransactionID());
		
		dto.getAmount();
		dto.getAdditionalInfo();
		dto.getId();
		dto.getHash();
		dto.getTransactionID();
		MerchantResponse response2=merchantApi.pay(dto);
		
		
		
		
		
		
		return "payament";
	}

}*/
