package com.sunbasedata.records.serviceImpl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunbasedata.records.entity.Jwt;
import com.sunbasedata.records.entity.User;
import com.sunbasedata.records.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public Jwt loginUser(User user) {
		URI url = null;
		Jwt b = new Jwt();
		try {
			url = new URI("https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        String json ="";
		try {
			json = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        HttpRequest request = HttpRequest.newBuilder()
            .uri(url)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();
        HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = response.body().toString();
		
		
		   String s = res.substring(19,59);
		   b.setAccess_token(s);

		return b;
	}

}
