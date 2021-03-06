package application;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Sales {
	private String salesId;
	private String productId;
	private String productName;
	private Double price;
	private int quantity;
	private String dateOfSales;
	private String sellerId;
	private String customerId;
	private PropertyChangeSupport pcs;


	public Sales() {
		this.pcs = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		String old_customerId = this.customerId;
		this.customerId = customerId;
		this.pcs.firePropertyChange("Sales", old_customerId, this.customerId);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {

		this.price = price;

	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDateOfSales() {
		return dateOfSales;
	}

	public void setDateOfSales(String dateOfSales) {
		this.dateOfSales = dateOfSales;
	}

	public String getSalesId() {
		return this.salesId;
	}

	public void setSalesId(String salesId) {

		this.salesId = salesId;

	}

}
