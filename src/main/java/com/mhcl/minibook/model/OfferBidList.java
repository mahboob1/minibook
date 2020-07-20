package com.mhcl.minibook.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class OfferBidList {
	@Getter @Setter
	private List<OfferBid> offers = new ArrayList<>();
	@Getter @Setter
	private List<OfferBid> bids = new ArrayList<>();
}
