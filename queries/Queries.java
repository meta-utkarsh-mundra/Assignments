package queries;

public class Queries {

	private String selectOrderInfoQuery;
	private String insertImageQuery;
	private String updateProductDataQuery;
	private String selectCategoryInfoQuery;

	/**
	 * @return the selectOrderInfoQuery
	 */
	public String getSelectOrderInfoQuery() {
		return selectOrderInfoQuery;
	}

	/**
	 * @param selectOrderInfoQuery the selectOrderInfoQuery to set
	 */
	public void setSelectOrderInfoQuery(String selectOrderInfoQuery) {
		this.selectOrderInfoQuery = selectOrderInfoQuery;
	}

	/**
	 * @return the insertImageQuery
	 */
	public String getInsertImageQuery() {
		return insertImageQuery;
	}

	/**
	 * @param insertImageQuery the insertImageQuery to set
	 */
	public void setInsertImageQuery(String insertImageQuery) {
		this.insertImageQuery = insertImageQuery;
	}

	/**
	 * @return the deleteProductDataQuery
	 */
	public String getUpdateProductDataQuery() {
		return updateProductDataQuery;
	}

	/**
	 * @param deleteProductDataQuery the deleteProductDataQuery to set
	 */
	public void setUpdateProductDataQuery(String deleteProductDataQuery) {
		this.updateProductDataQuery = deleteProductDataQuery;
	}

	/**
	 * @return the selectCategoryInfoQuery
	 */
	public String getSelectCategoryInfoQuery() {
		return selectCategoryInfoQuery;
	}

	/**
	 * @param selectCategoryInfoQuery the selectCategoryInfoQuery to set
	 */
	public void setSelectCategoryInfoQuery(String selectCategoryInfoQuery) {
		this.selectCategoryInfoQuery = selectCategoryInfoQuery;
	}

	public Queries() {

		this.selectOrderInfoQuery =  "SELECT orders.order_id, ORDERS.shopper_id, shopper.shopper_name, orders.order_total, orders.order_date"
				+ " FROM ORDERS"
				+ " INNER JOIN shopper"
				+ " ON shopper.shopper_id = orders.order_id"
				+ " WHERE orders.status LIKE \'%Shipped%\'"
				+ " AND orders.shopper_id ="
				+ 2;


		this.insertImageQuery = "INSERT INTO image(product_id, image_name) VALUES(?,?)"; 

		this.updateProductDataQuery = "UPDATE product SET product.quantity = 0" 
				+" WHERE product.product_id NOT IN"
				+" (SELECT DISTINCT products_in_order.product_id"
				+" FROM products_in_order"
				+" INNER JOIN orders ON products_in_order.order_id = orders.order_id"
				+" WHERE orders.order_date BETWEEN (CURRENT_DATE - INTERVAL 1 YEAR) AND (CURRENT_DATE) )";
    
		this.selectCategoryInfoQuery =  "select c.parent, count(c.name) as 'number of childs'" 
				+" from category c"
			    +" group by c.parent order by c.name asc";
	    
	}
}