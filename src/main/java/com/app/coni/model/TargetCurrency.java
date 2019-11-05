package com.app.coni.model;

import java.math.BigDecimal;

public class TargetCurrency {

	private String sourceCurrency;
	private String targetCurrency;
	private BigDecimal amount;
	private BigDecimal convertedAmt;

	public String getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getConvertedAmt() {
		return convertedAmt;
	}

	public void setConvertedAmt(BigDecimal convertedAmt) {
		this.convertedAmt = convertedAmt;
	}

}
