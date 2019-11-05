package com.app.coni.Service;

import java.math.BigDecimal;

import com.app.coni.model.TargetCurrency;

public interface CurrencyConvertorService {
	
	public TargetCurrency getConvertedCurrency(String from, String to, BigDecimal amt);

}
