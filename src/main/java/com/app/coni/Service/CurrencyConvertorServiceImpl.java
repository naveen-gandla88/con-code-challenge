package com.app.coni.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.coni.model.CurrencyLayerResData;
import com.app.coni.model.TargetCurrency;

@Service
public class CurrencyConvertorServiceImpl implements CurrencyConvertorService {

	private final static String URL = "http://apilayer.net/api/live";
	private final static String ACCESS_KEY = "access_key";
	private final static String ACCESS_KEY_CODE = "d9493c33f8cfd7b6b0278dea7100ae93";
	private final static String CURRENCIES = "currencies";
	private final static String SOURCE = "source";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public TargetCurrency getConvertedCurrency(String from, String to, BigDecimal amt) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL)
				// query parameters
				.queryParam(ACCESS_KEY, ACCESS_KEY_CODE).queryParam(CURRENCIES, to).queryParam(SOURCE, from);

		CurrencyLayerResData response = restTemplate.getForObject(builder.toUriString(), CurrencyLayerResData.class);

		TargetCurrency targetCur = new TargetCurrency();
		response.getQuotes().forEach((key, value) -> {
			if (value != null) {
				targetCur.setConvertedAmt(new BigDecimal(value).multiply(amt).setScale(2, RoundingMode.HALF_UP));
			}
			targetCur.setAmount(amt);
			targetCur.setSourceCurrency(from);
			targetCur.setTargetCurrency(to);
		});

		return targetCur;
	}

}
