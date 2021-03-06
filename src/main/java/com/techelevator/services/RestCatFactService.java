package com.techelevator.services;

import org.springframework.stereotype.Component;
import com.techelevator.model.CatFact;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	private String API_URL = "https://cat-data.netlify.app/api/facts/random";
//	private String API_KEY = "3051";
	private RestTemplate restTemplate = new RestTemplate();

//	public RestCatFactService(String apiURL) {
//		API_URL = apiURL;
//	//	API_KEY = apiKey;
//	}

	@Override
	public CatFact getFact() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(API_URL , CatFact.class);
	}

}
