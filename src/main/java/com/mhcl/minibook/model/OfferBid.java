package com.mhcl.minibook.model;

import lombok.Getter;
import lombok.Setter;

public class OfferBid implements Comparable<OfferBid> {
	 
	@Getter @Setter
	private String quoteId;
	@Getter @Setter
	private String quoteType;
	@Getter @Setter
	private String quoteOp;
	@Getter @Setter
	private String price;
	@Getter @Setter
	private String volume;
	
	@Override
	public int compareTo(OfferBid other) {
		if(this.price != other.price) {
			if(this.quoteType.equalsIgnoreCase("B")) {
				return Float.parseFloat(this.price) - Float.parseFloat(other.price) > 0 ? -1: 1;
			} else {
				return Float.parseFloat(this.price) - Float.parseFloat(other.price) > 0 ? 1: -1;
			}
		} else {
			int ret = 0;
			if(Long.parseLong(this.volume) > Long.parseLong(other.volume)) {
				ret = -11;
			} else if(Long.parseLong(this.volume) < Long.parseLong(other.volume)) {
				ret = 1;
			}
			return ret;
		}
	}
	
	@Override
	public int hashCode() {
		return 31 + quoteId.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}
		if(other == null || this.getClass() != other.getClass()) {
			return false;
		}
		return this.quoteId.equalsIgnoreCase(((OfferBid)other).quoteId);
	}
	
	
}