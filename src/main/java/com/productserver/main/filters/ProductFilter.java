package com.productserver.main.filters;

import java.math.BigDecimal;

public class ProductFilter {
	private String q;
	private BigDecimal min_price;
	private BigDecimal max_price;
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public BigDecimal getMin_price() {
		return min_price;
	}
	public void setMin_price(BigDecimal min_price) {
		this.min_price = min_price;
	}
	public BigDecimal getMax_price() {
		return max_price;
	}
	public void setMax_price(BigDecimal max_price) {
		this.max_price = max_price;
	}
	
	
}
