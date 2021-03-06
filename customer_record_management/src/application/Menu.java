package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu extends Application {
private static Menu instance = new Menu();
public Menu() {
}
public static Menu getInstance() {
	return instance;
}

Button newCustomerButton;
Button newSellerButton;
Button makeSalesButton;
Button printReportButton;
Button activityListButton;
Button loadSalesButton;
VBox menuVbox;
HBox customerandSellerHbox;

	@Override
	public void start(Stage stage)  {
	
		menuVbox= new VBox(40);
		customerandSellerHbox = new HBox(32);
			Scene scene = new Scene(menuVbox,300,350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("CRM system"); //
			customerandSellerHbox.setAlignment(Pos.CENTER);
			menuVbox.setAlignment(Pos.CENTER);
			printReportButton = new Button("print reports");
			makeSalesButton = new Button("new sales");
			newCustomerButton= new Button("new customer");
			newSellerButton= new Button("new seller");
			activityListButton= new Button("activity list");
			loadSalesButton= new Button("current sales records");
			
			newCustomerButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					NewCustomer.getInstance().GUI();
					stage.close();
				}
			});
			
			newSellerButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					 NewSeller.getInstance().createSeller();
					stage.close();
				}
			});
			
				printReportButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					 ReportControl.getInstance().Start();
						stage.close();
					}
				});
				
				makeSalesButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						stage.close();
						 NewSales.getInstance().makeSales();
					}
				});
				
				activityListButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						stage.close();
						ActivityListControl.getInstance().getList();
					}
				});
				loadSalesButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						stage.close();
						Serializer.getInstance();
						ArrayList<Sales>getSalesRecord=Serializer.loadSales();
						ReportPrinter.getInstance().viewReport(getSalesRecord);
					}
				});
	customerandSellerHbox.getChildren().addAll(newCustomerButton,makeSalesButton,newSellerButton);	
	 menuVbox.getChildren().addAll(loadSalesButton,activityListButton,printReportButton, customerandSellerHbox);

	stage.show();

}
}
