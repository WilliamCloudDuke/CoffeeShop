package edu.mum.coffee.domain;

//@Entity
//@Table(name = "SHOPPING_CAR")
public class ShoppingCar {

	// @Column(name = "QUANTITY")
	private int quantity;
	// @Column(name = "PRODUCT_ID")
	private long productId;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

}
