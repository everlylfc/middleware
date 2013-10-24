package broker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seller.Item;

public class GeneralBroker {

	long id;
	private int lastSellerId;
	private int lastBuyerId;
	List<Item> itemsHolds = new ArrayList<Item>();
	
	int minID = 0, maxID = 4;

	GeneralBroker() {
		lastSellerId = 0;
		lastBuyerId = 0;
	}

	public long getId() {
		return id;
	}

	
	public int publishAvailableItem(long sellerId, long itemId, String name,
			String attributes, float minimumBid) { // TODO
				return 0;
				
				/**
				 * AUTOMATICALLY SUBSCRIBE THE SELLER TO ANY BIDS GENERATED BY BUYERS FOR THAT ITEM!
				 */
		/*
		// Only allow IDs 0 to 4
		if (sellerId < minID || sellerId > 4) {
			return 1;
		}
		
		// Check valid name and attributes
		if (name.isEmpty()) return 2;
		
		// Check valid bid
		if (minimumBid <= 0.0) return 3;
		
		Set<String> attr= new HashSet<String>(
				Arrays.asList(attributes.split(",")));
		
		if (itemsHolds.add(new Item(sellerId, itemId, name, attr, minimumBid))) {
			return 0;
		} else return 4;
		*/
	}

	
	public int publishBid(long buyerId, long itemId, float price) {
		return -1;
		
		/**
		 * MUST SUBSCRIBE BUYER TO SOLD NOTIFICATION
		 */
		/*
		// Check for valid buyer ID
		if (buyerId < minID || buyerId > maxID) return 1;
		
		// Check if item ID is in list
		int position = -1;
		for (int pos = 0; pos < itemsHolds.size(); pos++) {
			if (Long.valueOf(itemId).equals(Long.valueOf(itemsHolds.get(0).itemId))) {
				position = pos;
				break;
			}
		}
		if (position < 0) return 2;
		
		if (itemsHolds.get(0).bid(buyerId, price)) {
			return 0;
		} else return 3;
		*/
	}

	public int publishBidUpdate(long sellerId, long buyerId, long itemId, float price) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int publishFinalizeSale(long sellerId,  long buyerId, long itemId,
			float finalPrice) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int subscribeInterest(long buyerId, String name, String attributes,
			float minimumBid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int subscribeReceiveBid(long buyerId, long itemId, float price) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int subscribeInterestBidUpdate(long buyerId, long itemId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int subscribeItemSold(long buyerId, long itemId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int setChildBroker(long brokerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Broker getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String genSellerId() {
		return lastSellerId++ + "";
	}

	
	public String genBuyerId() {
		return lastBuyerId++ + "";
	}

}
