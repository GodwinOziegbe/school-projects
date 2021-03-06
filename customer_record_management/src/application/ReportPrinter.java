package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ReportPrinter {

	private static ReportPrinter instance = new ReportPrinter();

	public ReportPrinter() {

	}

	public static ReportPrinter getInstance() {
		return instance;
	}

	Stage stage;
	Scene scene;

	Button gotoMenuButton, exportButton;
	GridPane gridPane;
	ArrayList<Sales> reportList = new ArrayList<Sales>();
	int j = 0;

	public void commonSettings() {
		stage = new Stage();
		scene = new Scene(gridPane, 1000, 600);
		stage.setScene(scene);
		stage.setTitle("Create Report");
		stage.show();
	}

	public void viewReport(ArrayList<Sales> reportPrintList) {
		int j = 1;
		if (reportPrintList.isEmpty()) {
			System.out.println("no records found");
			return;
		}
		gotoMenuButton = new Button("main menu");
		exportButton = new Button("export report");
		gridPane = new GridPane();

		gridPane.setPadding(new Insets(40, 0, 0, 50));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		gridPane.add(new Label("Sales ID     "), 0, 1);
		gridPane.add(new Label("Product ID   "), 1, 1);
		gridPane.add(new Label("Product Name "), 2, 1);
		gridPane.add(new Label("price        "), 3, 1);
		gridPane.add(new Label("Quantity     "), 4, 1);
		gridPane.add(new Label("Customer ID  "), 5, 1);
		gridPane.add(new Label("Seller's ID  "), 6, 1);
		gridPane.add(new Label("Date Of Sales"), 7, 1);

		for (Sales value : reportPrintList) {
//
//			if (value.getSalesId() != null) {
//				j++;
//			}
			j++;
			gridPane.add(new Label(value.getSalesId()), 0, j);
			gridPane.add(new Label(value.getProductId()), 1, j);
			gridPane.add(new Label(value.getProductName()), 2, j);
			gridPane.add(new Label(value.getPrice().toString()), 3, j);
			gridPane.add(new Label(String.valueOf(value.getQuantity())), 4, j);
			gridPane.add(new Label(value.getCustomerId()), 5, j);
			gridPane.add(new Label(String.valueOf(value.getSellerId())), 6, j);
			gridPane.add(new Label(value.getDateOfSales()), 7, j);

		}

		gridPane.add(gotoMenuButton, 9, j + 3);
		gridPane.add(exportButton, 10, j + 3);
		buttonEvents(reportPrintList);
		commonSettings();
	}

	public void buttonEvents(ArrayList<Sales> reportPrintList) {
		gotoMenuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.close();
				Menu.getInstance().start(stage);

			}

		});

		exportButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				stage.close();
				ExportChooser.getInstance().chooser(reportPrintList);

			}

		});

	}

}
