package application;

public class ExportBuilder {
	private Sales salesExport = new Sales();

    public Sales addSellerId(String sellerId) {
         salesExport.setSellerId(sellerId);
        return salesExport;
    }

    public Sales addCustomerId(String customerId) {
       	salesExport.setCustomerId(customerId);
        return salesExport;
    }

    public Sales addProductId(String productId) {
        salesExport.setProductId(productId);
        return salesExport;
    }

    public Sales addProductName(String productName) {
        salesExport.setProductName(productName);
        return salesExport;
    }
    
    public Sales addPrice(Double price) {
        salesExport.setPrice(price);
        return salesExport;
    }
    
    public Sales addQuantity(int quantity) {
        salesExport.setQuantity(quantity);
        return salesExport;
    }
    
    public Sales addDateOfSale(String dateOfSale) {
       	salesExport.setDateOfSales(dateOfSale);
        return salesExport;
    }
    
    public Sales addSalesId(String salesId) {
       	salesExport.setSalesId(salesId);
        return salesExport;
    }
 
    public Sales build() throws RuntimeException {
        if(salesExport.getSalesId()==null) {
            throw new RuntimeException("Sales Id missing");
        }
        return salesExport;
    }
	
}
