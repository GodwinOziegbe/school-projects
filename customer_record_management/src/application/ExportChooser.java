package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExportChooser {
	private static ExportChooser instance = new ExportChooser();

	public ExportChooser() {

	}

	public static ExportChooser getInstance() {
		return instance;
	}

	Stage stage;
	Scene scene;
	GridPane gridPane;
	Text salesIdText;
	Button exportButton;
	ArrayList<Sales> reportPrintList;
	CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;
	Text report;
	boolean isSelected1, isSelected2, isSelected3, isSelected4, isSelected5, isSelected6, isSelected7;

	public void commonSettings() {

		stage = new Stage();
		scene = new Scene(gridPane, 650, 350);
		stage.setScene(scene);
		stage.setTitle("Export Report");
		stage.show();
	}

	public void chooser(ArrayList<Sales> reportPrintList) {

		exportButton = new Button("Export Report");
		gridPane = new GridPane();

		gridPane.setPadding(new Insets(40, 0, 0, 50));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		report = new Text();
		report.setText("Select Only these fields to include:(Sales Id, Date Of Sales, Product Name, Customer ID) ");

		checkBox1 = new CheckBox("Sales Id");
		checkBox2 = new CheckBox("Date Of Sales");
		checkBox3 = new CheckBox("Product Id");
		checkBox4 = new CheckBox("Product Name");
		checkBox5 = new CheckBox("Price");
		checkBox6 = new CheckBox("Seller Id");
		checkBox7 = new CheckBox("Customer Id");

		gridPane.add(report, 0, 1);
		gridPane.add(checkBox1, 0, 2);
		gridPane.add(checkBox2, 0, 3);
		gridPane.add(checkBox3, 0, 4);
		gridPane.add(checkBox4, 0, 5);
		gridPane.add(checkBox5, 0, 6);
		gridPane.add(checkBox6, 0, 7);
		gridPane.add(checkBox7, 0, 8);
		gridPane.add(exportButton, 2, 10);

		exportButtonEvents(reportPrintList);
		commonSettings();
	}

	public void exportButtonEvents(ArrayList<Sales> reportPrintList) {
		exportButton.setOnAction(new EventHandler<ActionEvent>() {
			ArrayList<Sales> exportPrintList = new ArrayList<Sales>();

			@Override
			public void handle(ActionEvent event) {
				ExportBuilder builder = new ExportBuilder();
				Sales salesExport = new Sales();

				for (Sales value : reportPrintList) {
					if (checkBox1.isSelected()) {
						salesExport = builder.addSalesId(value.getSalesId());
					}
					if (checkBox2.isSelected()) {
						salesExport = builder.addDateOfSale(value.getDateOfSales());
					}
					if (checkBox3.isSelected()) {
						salesExport = builder.addProductId(value.getProductId());
					}

					if (checkBox4.isSelected()) {
						salesExport = builder.addProductName(value.getProductName());
					}
					if (checkBox5.isSelected()) {
						salesExport = builder.addPrice(value.getPrice());
					}
					if (checkBox6.isSelected()) {
						salesExport = builder.addSellerId(value.getSellerId());
					}
					if (checkBox7.isSelected()) {
						salesExport = builder.addCustomerId(value.getCustomerId());
					}

					exportPrintList.add(salesExport);

				}

				ExportFileWriter.getInstance().writeExport(exportPrintList);
				stage.close();
				Menu.getInstance().start(stage);
			}
		});

	}

}
