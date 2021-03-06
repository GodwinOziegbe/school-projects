package application;

import java.util.ArrayList;
import java.util.Random;

public class SalesDao {
	ArrayList<Sales> salesList = new ArrayList<Sales>();
	private static SalesDao instance = new SalesDao();

	private SalesDao() {
		super();
	}

	public static SalesDao getInstance() {
		return instance;
	}

	public ArrayList<Sales> getAllSales() {// Gets saleslist
		ArrayList<Sales> SerializedSalesList = Serializer.loadSales();
		return SerializedSalesList;
	}

	public ArrayList<Sales> getAllSalesByProduct(String productId) {// försäljning över tid för en viss produkt
		int check = 0;
		ArrayList<Sales> SerializedSalesList = Serializer.loadSales();
		ArrayList<Sales> reportList = new ArrayList<Sales>();
		for (Sales value : SerializedSalesList) {
			if (value.getProductId().equals(productId)) {
				reportList.add(value);
				check++;
			}
		}

		if (check == 0) {
			System.out.println("no data found");
			return null;
		} // check for empty request
		else {
			return reportList;
		}

	}

	public ArrayList<Sales> getSalesByAllSellersToSameCustomer(String customerId) {// försäljning över tid för en viss
																					// kund
		int check = 0;
		ArrayList<Sales> SerializedSalesList = Serializer.loadSales();
		ArrayList<Sales> reportList = new ArrayList<Sales>();
		for (Sales value : SerializedSalesList) {
			if (value.getCustomerId().equals(customerId)) {
				reportList.add(value);
				check++;

			}
		}
		if (check == 0) {
			System.out.println("no data found");
			return null;
		} else {
			return reportList;
		}

	}

	public Sales getSalesBySameSellerAndCustomer(String customerId, String sellerId) {
		int check = 0;
		ArrayList<Sales> SerializedSalesList = Serializer.loadSales();
		Sales currentCustomer = null;
		for (Sales value : SerializedSalesList) {
			if (value.getSellerId().equals(sellerId) && value.getCustomerId().equals(customerId)) {
				currentCustomer = value;
				check++;
				break;

			}
		}
		if (check == 0) {
			System.out.println("no data found");
			return null;
		} else {
			return currentCustomer;
		}
	}

	public ArrayList<Sales> getSalesBySameSellerToAllCustomers(String sellerId) {// försäljning över tid för en viss
																					// säljare
		int check = 0;
		ArrayList<Sales> SerializedSalesList = Serializer.loadSales();
		ArrayList<Sales> reportList = new ArrayList<Sales>();
		for (Sales value : SerializedSalesList) {
			if (value.getSellerId().equals(sellerId)) {
				reportList.add(value);
				check++;
			}
		}
		if (check == 0) {
			System.out.println("no data found");
			return null;
		} else {
			return reportList;
		}

	}

	public String createSalesId() {
		String result = "";
		for (int i = 0; i < 10; i++) {
			result += new Random().nextInt(10);
		}

		return result;
	}

	public void createSales(String salesId, String productId, String productName, Double price, int quantity,
			String dateOfSales, String customerId, String sellerId) {
		SalesControl salesControl = new SalesControl();
		Sales sales = new Sales();
		sales.addPropertyChangeListener(salesControl);
		sales.setSalesId(salesId);
		sales.setProductId(productId);
		sales.setProductName(productName);
		sales.setPrice(price);
		sales.setQuantity(quantity);
		sales.setDateOfSales(dateOfSales);
		sales.setCustomerId(customerId);
		sales.setSellerId(sellerId);
		salesList.add(sales);

	}

	public void saveSales() {
		if (salesList.isEmpty()) {
			System.out.println("empty record");
			return;
		}
		Serializer.getInstance();
		Serializer.saveSales(salesList);
	}

	public void updateSales(Sales currentSales, Sales sales) {
		// To do
		ArrayList<Sales> SerializedSalesList = Serializer.loadSales();
		SerializedSalesList.add(sales);

	}

	public void deleteSales(Sales sales) {
		// To do
		ArrayList<Sales> SerializedSalesList = Serializer.loadSales();
		SerializedSalesList.remove(sales);
	}
}
