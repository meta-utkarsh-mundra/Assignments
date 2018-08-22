package session5assignment2;

public class ImageData {
	int prodId;
	String name;

	public ImageData(int productId, String name) {
		super();
		this.prodId = productId;
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public int getProdId() {
		return prodId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}