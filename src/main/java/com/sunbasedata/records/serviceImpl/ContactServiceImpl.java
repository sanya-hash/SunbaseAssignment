package com.sunbasedata.records.serviceImpl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunbasedata.records.entity.Contact;
import com.sunbasedata.records.service.ContactService;


@Service
public class ContactServiceImpl implements ContactService {

	@Override
	public Contact[] getContacts(String token)  {
		//List<Contact> contacts = new ArrayList<Contact>() ;
		Contact[] contacts = null;
		URI url = null;
		String paramName = "cmd";
		String paramValue = "get_customer_list";
		try {
			url = new URI("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp"+"?"+paramName+"="+paramValue);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpUriRequest httpRequest = new HttpGet(url);
		httpRequest.setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+token);
		//CloseableHttpResponse response;
		String res="";
		try {
			CloseableHttpResponse response = httpClient.execute(httpRequest);
			//System.out.print("result"+response);
			res = EntityUtils.toString(response.getEntity());
//			System.out.print("data"+res);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		    contacts = objectMapper.readValue(res, Contact[].class);
//		    for(Contact contact:contacts) {
//		    	System.out.println("contact" + contact);
//		    }
			response.close();
			httpClient.close();
		} catch (IOException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		//return null;
//		HttpRequest request;
//		request.set
//		request  = HttpRequest.newBuilder().GET().uri(url).build();
//		HttpClient client = HttpClient.newBuilder().build();
//		HttpResponse<String> response=null;
//		try {
//			response = client.send(request,HttpResponse.BodyHandlers.ofString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String res = response.body().toString();
//		StringBuilder sb = new StringBuilder();
//		for(int i =1;i<res.length()-1;i++) {
//			sb.append(res.charAt(i));
//		}
//		String jsonString = sb.toString();
//		JSONObject jsonObject = new JSONObject(jsonString);	
//       // Get an array of JSON objects from the JSON object
//        JSONArray jsonArray = new JSONArray(res);		
//       // Loop through the JSON array and get each object
//	    for (int i = 0; i < jsonArray.length(); i++) {
//			        JSONObject obj = jsonArray.getJSONObject(i);
//			        Contact b = new Contact(obj.getString("uuid"),obj.getString("first_name"),obj.getString("last_name"),obj.getString("address"), obj.getString("city"),obj.getString("email"),obj.getString("state"),obj.getString("street"),obj.getString("phone"));
//			        contacts.add(b);
//			        System.out.println(b);
//	   }
		//System.out.println("firstdata"+contacts);
//	    for(Contact contact:contacts) {
//    	System.out.println("contact" + contact);
//    }
	    return contacts;
	}
	public void deleteContact(String uuid,String token) {
		URI url = null;
		String paramName1 = "cmd";
		String paramValue1 = "delete";
		String paramName2 = "uuid";
		String paramValue2 = uuid;
		try {
			url = new URI("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp"+"?"+paramName1+"="+paramValue1+"&"+paramName2+"="+paramValue2);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpUriRequest httpRequest = new HttpPost(url);
		httpRequest.setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+token);
		//CloseableHttpResponse response;
		String res="";
		try {
			CloseableHttpResponse response = httpClient.execute(httpRequest);
			//System.out.print("result"+response);
			res = EntityUtils.toString(response.getEntity());
			//System.out.print(res);
			response.close();
			httpClient.close();
		} catch (IOException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public String addContact(Contact c,String token) {
		URI url = null;
		String paramName1 = "cmd";
		String paramValue1 = "create";
		try {
			url = new URI("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp"+"?"+paramName1+"="+paramValue1);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpUriRequest httpRequest = new HttpPost(url);
		httpRequest.setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+token);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonBody = objectMapper.writeValueAsString(c);
			StringEntity entity = new StringEntity(jsonBody);
			((HttpPost) httpRequest).setEntity(entity);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CloseableHttpResponse response;
		String res="";
		try {
			CloseableHttpResponse response = httpClient.execute(httpRequest);
			//System.out.print("result"+response);
			res = EntityUtils.toString(response.getEntity());
			//System.out.print(res);
			response.close();
			httpClient.close();
		} catch (IOException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
	}
	@Override
	public String updateContact(Contact c, String token,String uuid) {
		
		URI url = null;
		String paramName1 = "cmd";
		String paramValue1 = "update";
		String paramName2 = "uuid";
		String paramValue2 = uuid;
		System.out.print("update token:"+token);
		try {
			url = new URI("https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp"+"?"+paramName1+"="+paramValue1+"&"+paramName2+"="+paramValue2);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpUriRequest httpRequest = new HttpPost(url);
		httpRequest.setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+token);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonBody = objectMapper.writeValueAsString(c);
			StringEntity entity = new StringEntity(jsonBody);
			((HttpPost) httpRequest).setEntity(entity);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CloseableHttpResponse response;
		String res="";
		try {
			CloseableHttpResponse response = httpClient.execute(httpRequest);
			//System.out.print("result"+response);
			res = EntityUtils.toString(response.getEntity());
			response.close();
			httpClient.close();
		} catch (IOException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
		
	}
	
}
