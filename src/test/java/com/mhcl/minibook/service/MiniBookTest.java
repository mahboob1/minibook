package com.mhcl.minibook.service;

 
import java.util.ArrayList;
import java.util.List;

import com.mhcl.minibook.model.OfferBid;
import com.mhcl.minibook.model.OfferBidList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for MiniBook
 */
public class MiniBookTest  extends TestCase
{
    public MiniBookTest( String testName )
    {
        super( testName );
    }
    
    protected void setUp() throws Exception {
    	super.setUp();
    	}
    
    protected void tearDown() throws Exception {
    	super.tearDown();
    	}
    

    public void testOfferBid()
    {
    	List<String> quotes = new ArrayList<>();
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
		MiniBook miniBook = new MiniBook();
		OfferBidList offerBidList = miniBook.sortOffersBids(quotes);
		System.out.println("OFFER :");
		for(OfferBid offerBid : offerBidList.getOffers()) {
			System.out.println(offerBid.getQuoteId() + "/" + offerBid.getPrice() 
			+ "/" + offerBid.getVolume());
		}
		System.out.println("BID :");
		for(OfferBid offerBid : offerBidList.getBids()) {
			System.out.println(offerBid.getQuoteId() + "/" + offerBid.getPrice() 
			+ "/" + offerBid.getVolume());
		}
    }
    
    public void testOfferBidWithAllOfferDeleted()
    {
    	List<String> quotes = new ArrayList<>();
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
		//delete all offer
		line = "0/O/D/0/0";
		quotes.add(line);
		MiniBook miniBook = new MiniBook();
		OfferBidList offerBidList = miniBook.sortOffersBids(quotes);
		System.out.println("OFFER :");
		for(OfferBid offerBid : offerBidList.getOffers()) {
			System.out.println(offerBid.getQuoteId() + "/" + offerBid.getPrice() 
			+ "/" + offerBid.getVolume());
		}
		System.out.println("BID :");
		for(OfferBid offerBid : offerBidList.getBids()) {
			System.out.println(offerBid.getQuoteId() + "/" + offerBid.getPrice() 
			+ "/" + offerBid.getVolume());
		}
    }
    
    public void testOfferBidEmpty()
    {
    	List<String> quotes = new ArrayList<>();
		MiniBook miniBook = new MiniBook();
		OfferBidList offerBidList = miniBook.sortOffersBids(quotes);
		System.out.println("OFFER :");
		for(OfferBid offerBid : offerBidList.getOffers()) {
			System.out.println(offerBid.getQuoteId() + "/" + offerBid.getPrice() 
			+ "/" + offerBid.getVolume());
		}
		System.out.println("BID :");
		for(OfferBid offerBid : offerBidList.getBids()) {
			System.out.println(offerBid.getQuoteId() + "/" + offerBid.getPrice() 
			+ "/" + offerBid.getVolume());
		}
    }
    
    public void testOfferBidBadData()
    {
    	List<String> quotes = new ArrayList<>();
		String line = "Q1/O/N/1.31/1000000";
		quotes.add(line);
		line = "Q2,B/N-1.21/1000000";
		quotes.add(line);
		line = "Q3,,B/N/1.22/1000000";
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
		MiniBook miniBook = new MiniBook();
		OfferBidList offerBidList = miniBook.sortOffersBids(quotes);
		System.out.println("OFFER :");
		for(OfferBid offerBid : offerBidList.getOffers()) {
			System.out.println(offerBid.getQuoteId() + "/" + offerBid.getPrice() 
			+ "/" + offerBid.getVolume());
		}
		System.out.println("BID :");
		for(OfferBid offerBid : offerBidList.getBids()) {
			System.out.println(offerBid.getQuoteId() + "/" + offerBid.getPrice() 
			+ "/" + offerBid.getVolume());
		}
    }
}
