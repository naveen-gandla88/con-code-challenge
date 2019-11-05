package com.app.coni.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.app.coni.model.Country;
import com.app.coni.persistance.ValidateVatRepository;
import com.cloudmersive.client.VatApi;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.cloudmersive.client.model.VatLookupRequest;
import com.cloudmersive.client.model.VatLookupResponse;

@Service
public class ValidateVATNumServiceImpl implements ValidateVATNumService {

	private final static String API_KEY_VALUE = "775ef4fb-c865-4d09-8212-3c12b6f90b1b";
	private final static String API_KEY = "Apikey";
	private final static String STR1 = "(";
	private final static String STR2 = ")";

	@Autowired
	private ValidateVatRepository vatRepository;

	@Override
	@Cacheable("country")
	public Country validateVATNumber(String vatNum) {

		ApiClient defaultClient = Configuration.getDefaultApiClient();

		ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication(API_KEY);
		Apikey.setApiKey(API_KEY_VALUE);
		VatApi apiInstance = new VatApi();
		VatLookupRequest input = new VatLookupRequest().vatCode(vatNum);
		Country country = new Country();

		try {
			VatLookupResponse result = apiInstance.vatVatLookup(input);
			String res = getCountryFromCd(result.getCountryCode());
			if(res != null) {
				country.setCountry(res);	
			}

		} catch (ApiException e) {
			e.printStackTrace();
		}
		return country;
	}

	private String getCountryFromCd(String countryCd) {
		
		String cName = vatRepository.getCountryByCd(countryCd);
		if(cName != null) {
		cName = cName + STR1 + countryCd + STR2;
		}
		return cName;

	}

}
