package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReportControl {
	private static ReportControl instance = new ReportControl();

	public ReportControl() {

	}

	public static ReportControl getInstance() {
		return instance;
	}

	Stage stage;
	Scene scene;
	GridPane gridPane;
	Text salesIdText;
	Button createReportButton;
	ComboBox<String> comboBox, customerBox;
	Text report;

	public void commonSettings() {

		stage = new Stage();
		scene = new Scene(gridPane, 400, 200);
		stage.setScene(scene);
		stage.setTitle("Create Report");
		stage.show();
	}

	public void Start() {
		createReportButton = new Button("create Report");
		gridPane = new GridPane();

		gridPane.setPadding(new Insets(40, 0, 0, 50));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		report = new Text();
		report.setText("Report Selection: ");

		comboBox = new ComboBox<String>();
		comboBox.getItems().add("Customer Report");
		comboBox.getItems().add("Seller Report");
		comboBox.getItems().add("Product Report");

		GridPane.setHalignment(comboBox, HPos.RIGHT);
		gridPane.add(report, 1, 1);
		gridPane.add(comboBox, 2, 1);
		gridPane.add(createReportButton, 2, 3);

		createReportButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (comboBox.getSelectionModel().isEmpty()) {
					report.setText("Make Your Selection");
					return;
				}
				if (comboBox.getSelectionModel().getSelectedItem().equals("Customer Report")) {
					CustomerReport.getInstance().customerReport();
					stage.close();

				}
				if (comboBox.getSelectionModel().getSelectedItem().equals("Seller Report")) {
					SellerReport.getInstance().sellerReport();
					stage.close();

				}
				if (comboBox.getSelectionModel().getSelectedItem().equals("Product Report")) {
					ProductReport.getInstance().productReport();
					stage.close();

				}

			}
		});

		commonSettings();
	}

}
