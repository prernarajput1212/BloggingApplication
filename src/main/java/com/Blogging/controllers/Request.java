package com.Blogging.controllers;

import java.util.Arrays;

import org.hibernate.id.SequenceMismatchStrategy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;

import com.Blogging.Payloads.ResponseDto;
import com.Blogging.Payloads.SendSms;
import com.google.gson.Gson;
@RestController
@RequestMapping("/")
public class Request<T> {

		
	@GetMapping("/request")	
	 private ResponseEntity<ResponseDto> checkADAuthentication() {
		
		RestTemplate restTemplate = new RestTemplate();
		 SendSms sms=new SendSms();
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));  
	       
	      HttpEntity <SendSms> entity = new HttpEntity<SendSms>(sms,headers);
	      System.out.println("Sending request");
	   
	        System.out.println(new Gson().toJson(sms));
	        System.out.println("sms values: "+entity.getBody());
	   
	       String res= restTemplate.exchange("https://axiom.spicejet.com:8443/publisher/json6listener", HttpMethod.POST, entity, String.class).getBody();
		      System.out.println("request sent "+res);
	  // String res= restTemplate.exchange("https://172.30.47.217:8443/publisher/json6listener", HttpMethod.POST, entity, String.class).getBody();
	      return null;
		
		
//		HttpHeaders headers = new HttpHeaders();
//		
//		RestTemplate restTemplate = new RestTemplate();
//		DefaultUriBuilderFactory uriBuilder = new DefaultUriBuilderFactory();
//		uriBuilder.setEncodingMode(EncodingMode.NONE); // Or VALUES_ONLY
//	restTemplate.setUriTemplateHandler(uriBuilder);
//		headers.setContentType(org.springframework.http.MediaType.TEXT_PLAIN);
//		
//	  //   headers.setAccept(Arrays.asList(org.springframework.http.MediaType.TEXT_PLAIN));  
//
//		HttpEntity<String> request = new HttpEntity<String>(headers);
//		//String saltGetUrl=salturl+"?fromDate="+fromDate+"&toDate="+toDate;
//		String url="https://axiom.spicejet.com:8443/publisher/http6listener?dcode=SPICEJTEST&subuid=SPICEJTEST&pwd=HaswWul+RC+le/lITEra1Q==&ctype=1&from=SPICEJ&to=916395394857&msgtxt=this is test msg&intflag=1&msgtype=S&otpflag=0&langid=en";
//	//	try {
//			
//		//	log.info("saltGetUrl : "+saltGetUrl);
//		//	log.info("request : "+request);
//			
//		System.out.print("url : "+url);
//	ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request,String.class);
//	System.out.print("sent"+response);
//	
//	return null;
	//	RestTemplate restTemplate = new RestTemplate();
	//	 SendSms sms=new SendSms();
	//      HttpHeaders headers = new HttpHeaders();
	//      headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));  
	   //   headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
	      
	 //     HttpEntity <SendSms> entity = new HttpEntity<SendSms>(sms,headers);
	//      System.out.println("Sending request");
	     // s.setmsgtxt(sms.getMessageText());
	    //    System.out.println(new Gson().toJson(sms));
	   //     System.out.println("sms values: "+entity.getBody());
	    //    System.out.println("sms values: "+entity.getBody().getmsgtxt());
	    //   String res= restTemplate.exchange("https://axiom.spicejet.com:8443/publisher/json6listener", HttpMethod.POST, entity, String.class).getBody();
		 //     System.out.println("request sent "+res);
	   //   String res= restTemplate.exchange("https://axiom.spicejet.com:8443/publisher/json6listener", HttpMethod.POST, entity, String.class).getBody();
	    	 // String res= restTemplate.exchange("https://172.30.47.217:8443/publisher/json6listener", HttpMethod.POST, entity, String.class).getBody();
	   //   return null;
	   
//	      //  HttpHeaders headers = new HttpHeaders();
//	        RestTemplate restTemplate = new RestTemplate();
////	        headers.setAccept(Collections.singletonList(org.springframework.http.MediaType.APPLICATION_JSON));
////	        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
////	        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
////	         request.put("dcode", "SPICEJTEST");
////	         request.put("subuid", "SPICEJTEST");
////	         request.put("pwd","HaswWul+RC+le/lITEra1Q==" );
////	         request.put("to", "6395394857");
////	         request.put("msgtype", "S");
////	         request.put("msgtxt", "abcd");
////	         request.put("from", "SPICEJ");
////	         request.put("OTPFlag", "0");
////	         request.put("ctype", "1");
////	        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//	        HttpHeaders headers = createHeaders();
//	        JSONObject request = new JSONObject();
//	        request.put("dcode", "SPICEJTEST");
//	        request.put("subuid", "SPICEJTEST");
//	        	         request.put("pwd","HaswWul+RC+le/lITEra1Q==" );
//         request.put("to", "6395394857");
//	         request.put("msgtype", "S");
//	         request.put("msgtxt", "abcd");
//	         request.put("from", "SPICEJ");
//	         request.put("OTPFlag", "0");
//	         request.put("ctype", "1");
////	        request.put("appdate", date.toString());
////	        request.put("crewbase", base);
////	        request.put("key", key);
//	        HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);
//	        ResponseEntity<Object> exchange =
//	                restTemplate.exchange("http://axiom.spicejet.com/publisher/json6listener", HttpMethod.POST, entity, Object.class);
//	                
////	        ResponseEntity<Object> response = restTemplate.postForEntity("http://axiom.spicejet.com/publisher/json6listener",
////	        request, Object.class);
//
//	        
}
	 private HttpHeaders createHeaders() {
	        return new HttpHeaders() {
	            private static final long serialVersionUID = 1L;

	            {
	                setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
	            }
	        };
	    }
}
