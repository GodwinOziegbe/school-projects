package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class SellerReport {
private static SellerReport instance=new SellerReport();
Stage stage;
Scene scene;
GridPane gridPane;

public SellerReport() {
	
}
public static SellerReport getInstance() {
	return instance;
}
private TextField sellerIdTextField  = new TextField();
public void commonSettings() {
	stage = new Stage();
	scene= new Scene(gridPane, 400, 200);
	stage.setScene(scene);
	stage.setTitle("Create Report");
	stage.show();
}
public void sellerReport() {//försäljning över tid för en viss säljare
	Button sellerReportButton= new Button("seller Report");
	
	gridPane=new GridPane();
	
	gridPane.setPadding(new Insets(40, 0, 0, 50));
	gridPane.setHgap(5);
	gridPane.setVgap(5);

	gridPane.add(new Label("Enter Seller Id:"), 0, 1);
	gridPane.add(sellerIdTextField, 1, 1);
	gridPane.add(sellerReportButton, 1, 3);
	
		sellerReportButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				ArrayList<Sales> reportList= SalesDao.getInstance().getSalesBySameSellerToAllCustomers(sellerIdTextField.getText());
					sellerIdTextField.clear();
					stage.close();
					ReportPrinter.getInstance().viewReport(reportList);
			}
		});	
		commonSettings();
	}
	
	
}
