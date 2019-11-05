package com.app.coni.model;

import java.util.Map;

public class CurrencyLayerResData {

	private Boolean success;
	private String terms;
	private String privacy;
	private String source;
	private Long timestamp;
	private Map<String, String> quotes;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Map<String, String> getQuotes() {
		return quotes;
	}

	public void setQuotes(Map<String, String> quotes) {
		this.quotes = quotes;
	}

}
