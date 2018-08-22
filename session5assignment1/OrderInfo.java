package session5assignment1;

import java.sql.Date;

public class OrderInfo {
	private int objectId;
	private int shopperId;
	private String shopperName;
	private int totalCost;
	private Date placedDate;

	public OrderInfo(int objectId, int shopperId, String shopperName, int totalCost, Date placedDate) {
		super();
		this.objectId = objectId;
		this.shopperId = shopperId;
		this.shopperName = shopperName;
		this.totalCost = totalCost;
		this.placedDate = placedDate;
	}
	
	

	/**
	 * @return the objectId
	 */
	public int getObjectId() {
		return objectId;
	}

	/**
	 * @return the shopperId
	 */
	public int getShoperId() {
		return shopperId;
	}
	
	/**
	 * @return the objectId
	 */
	public String getShopperName() {
		return shopperName;
	}
	/**
	 * @return the totalCost
	 */
	public int getTotalCost() {
		return totalCost;
	}

	/**
	 * @return the placedDate
	 */
	public Date getPlacedDate() {
		return placedDate;
	}
}