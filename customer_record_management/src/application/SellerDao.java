package application;

import java.util.ArrayList;

public class SellerDao {
	private ArrayList<Seller> sellerList = new ArrayList<>();
	private static SellerDao instance = new SellerDao();

	public SellerDao() {

	}

	public static SellerDao getInstance() {
		return instance;
	}

	public Seller getseller(String sellerId) {
		Seller currentSeller = null;
		for (Seller value : sellerList) {
			if (value.getId() == sellerId) {
				currentSeller = value;
				break;
			}
		}
		return currentSeller;

	}

	public void saveSeller(Seller seller) {
		sellerList.add(seller);

	}

	public void updateSeller(Seller currentSeller, Seller seller) {
		// Todo
		sellerList.add(seller);
	}

	public void deleteSeller(Seller seller) {
		sellerList.remove(seller);
	}

}
