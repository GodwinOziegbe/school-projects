package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProductReport {
	private static ProductReport instance=new ProductReport();
	Stage stage, viewStage;
	Scene scene,viewScene;
	GridPane gridPane,viewgridPane;
	Button gotoMenuButton= new Button("Main menu");
	Button exportButton= new Button("Export");
	public ProductReport() {
		
	}
	public static ProductReport getInstance() {
		return instance;
	}
	
	private TextField productIdTextField  = new TextField();
	public void commonSettings() {
		stage = new Stage();
		scene= new Scene(gridPane, 1000, 600);
		stage.setScene(scene);
		stage.setTitle("Create Report");
		stage.show();
	}
	public void viewSettings() {
		viewStage = new Stage();
		viewScene= new Scene(gridPane, 800, 200);
		
		viewStage.setScene(viewScene);
		viewStage.setTitle("Report View");
		viewStage.show();
	}
	public void productReport() {
		
		Button productReportButton= new Button("product Report");
		
		gridPane=new GridPane();
		
		gridPane.setPadding(new Insets(40, 0, 0, 50));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		GridPane.setHalignment(productReportButton, HPos.RIGHT);
		gridPane.add(new Label("Enter product Id:"), 0, 1);
		gridPane.add(productIdTextField, 1, 1);
		gridPane.add(productReportButton, 1, 3);
		
		productReportButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				ArrayList<Sales>reportList=	SalesDao.getInstance().getAllSalesByProduct(productIdTextField.getText());;
					productIdTextField.clear();
					stage.close();
					ReportPrinter.getInstance().viewReport(reportList);
				}
		
		});	
		commonSettings();
	}
	
	
		
	}

