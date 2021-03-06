package application;

	import java.util.ArrayList;

import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
	
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.GridPane;
	import javafx.scene.text.Text;
	import javafx.stage.Stage;


	public class CustomerReport {
		Stage stage;	
		Scene scene;
		GridPane gridPane;
		Text salesIdText;
		Button customerReportButton,myCustomerReportButton,allCustomerReportButton,allSellersReportButton;
		ComboBox<String> comboBox,customerBox;
		Text report;
		private static CustomerReport instance=new CustomerReport();
		private TextField customerIdTextField = new TextField();
		private TextField sellerIdTextField = new TextField();	
		
		
		public CustomerReport() {
			
		}
		public static CustomerReport getInstance() {
		return instance;
		}
	
		public void commonSettings() {
			
			stage = new Stage();
			scene= new Scene(gridPane, 400, 200);
			stage.setScene(scene);
			stage.setTitle("Create Report");
			stage.show();
		}
			
			
			public void customerReport() {
				customerReportButton= new Button("customer Report");
				gridPane=new GridPane();
				
				gridPane.setPadding(new Insets(40, 0, 0, 50));
				gridPane.setHgap(5);
				gridPane.setVgap(5);
				report = new Text();
				report.setText("Report Selection: ");
				
				customerBox = new ComboBox<String>();
				customerBox.getItems().add("Specific customer and seller");
				customerBox.getItems().add("All sales to a customer");
				
				GridPane.setHalignment(customerBox, HPos.RIGHT);
				gridPane.add(report, 0, 1);
				gridPane.add(customerBox,1,1);
				gridPane.add(customerReportButton, 1, 3);
				
				customerReportButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						if (customerBox.getSelectionModel().isEmpty()) {
							report.setText("Make Your Selection");
							return;
						}
						if (customerBox.getSelectionModel().getSelectedItem().equals("Specific customer and seller")) {
							stage.close();
							specificCustomerAndSeller();							
						}
						
						if (customerBox.getSelectionModel().getSelectedItem().equals("All sales to a customer")) {
							stage.close();
							specificCustomerAllSellers();
						}
					}
				});	
				commonSettings();
			}
			public void specificCustomerAndSeller() {
				
				myCustomerReportButton= new Button("customer Report");
				gridPane=new GridPane();
				
				gridPane.setPadding(new Insets(40, 0, 0, 50));
				gridPane.setHgap(5);
				gridPane.setVgap(5);
		
				gridPane.add(new Label("Enter Seller Id:"), 0, 1);
				gridPane.add(sellerIdTextField, 1, 1);
				gridPane.add(new Label("Enter Customer Id:"), 0, 2);
				gridPane.add(customerIdTextField, 1, 2);
				
				gridPane.add(myCustomerReportButton, 1, 3);
				
				myCustomerReportButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						
						Sales specificCustomer=SalesDao.getInstance().getSalesBySameSellerAndCustomer(customerIdTextField.getText(),sellerIdTextField.getText());
						ArrayList<Sales>list= new ArrayList<Sales>();
						list.add(specificCustomer);
							customerIdTextField.clear();
							sellerIdTextField.clear();
							
						ReportPrinter.getInstance().viewReport(list);
							stage.close();
						}
				});	
				commonSettings();
			}
			public void specificCustomerAllSellers() {//försäljning över tid till en viss kund
				allSellersReportButton= new Button("customer Report");
				gridPane=new GridPane();
				
				gridPane.setPadding(new Insets(40, 0, 0, 50));
				gridPane.setHgap(5);
				gridPane.setVgap(5);
		
				gridPane.add(new Label("Enter Customer Id:"), 0, 1);
				gridPane.add(customerIdTextField, 1, 1);
				gridPane.add(allSellersReportButton, 1, 3);
				
				allSellersReportButton.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						
						ArrayList<Sales>currentReportList=	SalesDao.getInstance().getSalesByAllSellersToSameCustomer(customerIdTextField.getText());
							customerIdTextField.clear();
							
							stage.close();
							ReportPrinter.getInstance().viewReport(currentReportList);

					}
				});	
				commonSettings();
			}
			
			
			
	}
			

