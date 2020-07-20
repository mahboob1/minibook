package com.mhcl.minibook.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mhcl.minibook.model.OfferBid;
import com.mhcl.minibook.model.OfferBidList;
import com.mhcl.minibook.util.ReadFileUtil;

public class MiniBook {
	private static final Logger logger 
	  = LoggerFactory.getLogger(MiniBook.class);
	
	public OfferBidList sortOffersBids(List<String> quotes) {
		OfferBidList offerBidList =  new OfferBidList();
		if(quotes.size() == 0) {
			logger.info("No Offers or Bids Available to process.");
			return offerBidList;
		}
		for(String quote : quotes) {
			String[] quoteArray = quote.split("/");
			if(quoteArray.length != 5) {
				logger.info("Offer or Bid not in Format so Skipping.");
				continue;
			}
			OfferBid offerBid = new OfferBid();
			this.createOffferBid(offerBid, quoteArray);
			if(offerBid.getQuoteType().equalsIgnoreCase("O")) {
				sortOfferBid(offerBid, offerBidList.getOffers());
			} else {
				sortOfferBid(offerBid, offerBidList.getBids());
			}
		}
		Collections.sort(offerBidList.getOffers());
		Collections.sort(offerBidList.getBids());
		return offerBidList;
	}
	
	public void createOffferBid(OfferBid offerBid, String[] quoteArray) {
		offerBid.setQuoteId(quoteArray[0]);
		offerBid.setQuoteType(quoteArray[1]);
		offerBid.setQuoteOp(quoteArray[2]);
		offerBid.setPrice(quoteArray[3]);
		offerBid.setVolume(quoteArray[4]);
	}
	
	public void sortOfferBid(OfferBid offerBid, List<OfferBid> offersOrBids) {
		if(offerBid.getQuoteOp().equalsIgnoreCase("N")) { // new offer/bid
			offersOrBids.add(offerBid);
		} else if(offerBid.getQuoteOp().equalsIgnoreCase("U")) { // update offer/bid
			if(offersOrBids.contains(offerBid)) {
				offersOrBids.remove(offerBid);
				offersOrBids.add(offerBid);
			}
		} else if(offerBid.getQuoteOp().equalsIgnoreCase("D")) { // delete this offer/bid
			if(offersOrBids.contains(offerBid)) {
				offersOrBids.remove(offerBid);
			} else if(offerBid.getQuoteId().equalsIgnoreCase("0")) { // delete all offers/bids
				offersOrBids.clear();
			}
		}
	}
	
	public static void main(String[] args) {
		List<String> quotes = new ArrayList<>();
		try {
			String miniBookInput = "C:\\datafile\\mini-book.txt";
			quotes = ReadFileUtil.readFile(miniBookInput);
		} catch(Exception e) {
			quotes = new ArrayList<>();
			String line = "Q1/O/N/1.31/1000000";
			quotes.add(line);
			line = "Q2/B/N/1.21/1000000";
			quotes.add(line);
			line = "Q3/B/N/1.22/1000000";
			quotes.add(line);
			line = "Q4/B/N/1.20/1000000";
			quotes.add(line);
			line = "Q5/B/N/1.20/1000000";
			quotes.add(line);
			line = "Q6/O/N/1.32/1000000";
			quotes.add(line);
			line = "Q7/O/N/1.33/200000";
			quotes.add(line);
			line = "Q5/B/U/1.20/500000";
			quotes.add(line);
			line = "Q7/O/U/1.33/100000";
			quotes.add(line);
			line = "Q7/O/D/0/0";
			quotes.add(line);
		}
		MiniBook miniBook = new MiniBook();
		OfferBidList offerBidList = miniBook.sortOffersBids(quotes);
		logger.info("OFFER :");
		for(OfferBid offerBid : offerBidList.getOffers()) {
			logger.info(offerBid.getQuoteId() + "/" + offerBid.getPrice() 
			+ "/" + offerBid.getVolume());
		}
		logger.info("BID :");
		for(OfferBid offerBid : offerBidList.getBids()) {
			logger.info(offerBid.getQuoteId() + "/" + offerBid.getPrice() 
			+ "/" + offerBid.getVolume());
		}
	}

}
