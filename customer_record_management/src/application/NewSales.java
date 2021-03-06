package application;

import java.util.Date;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewSales {
	Stage stage;
	Scene scene;
	GridPane gridPane;
	Text salesIdText;
	Button saveSalesButton, addSalesButton, makeNewSalesButton;
	private static NewSales instance = new NewSales();
	private TextField productIdTextField = new TextField();
	private TextField productNameTextField = new TextField();
	private TextField priceTextField = new TextField();
	private TextField customerIdTextField = new TextField();
	private TextField sellerIdTextField = new TextField();
	private TextField quantityTextField = new TextField();

	String salesId;
	Text dateText = new Text();

	public NewSales() {

	}

	public static NewSales getInstance() {
		return instance;
	}

	public void GuiSettings() {

		stage = new Stage();
		scene = new Scene(gridPane, 400, 350);
		stage.setScene(scene);
		stage.setTitle("Create Sales");
		stage.show();
	}

	public void createCustomerGUI() {

	}

	public void createSellerGUI() {

	}

	public void makeSales() {
		dateText.setText(new Date().toLocaleString());
		saveSalesButton = new Button("save and exit");
		addSalesButton = new Button("add");
		makeNewSalesButton = new Button("new Sales");
		gridPane = new GridPane();
		salesIdText = new Text();
		salesId = SalesDao.getInstance().createSalesId();
		salesIdText.setText(salesId);
		gridPane.setPadding(new Insets(40, 0, 0, 50));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.setAlignment(Pos.TOP_CENTER);

		gridPane.add(new Label("Sales Id:"), 0, 1);
		gridPane.add(salesIdText, 1, 1);
		gridPane.add(new Label("Product Id:"), 0, 2);
		gridPane.add(productIdTextField, 1, 2);
		gridPane.add(new Label("Product Name:"), 0, 3);
		gridPane.add(productNameTextField, 1, 3);
		gridPane.add(new Label("Price(Double F.):"), 0, 4);
		gridPane.add(priceTextField, 1, 4);
		gridPane.add(new Label("Quantity:"), 0, 5);
		gridPane.add(quantityTextField, 1, 5);
		gridPane.add(new Label("Date Of Sales:"), 0, 6);
		gridPane.add(dateText, 1, 6);
		gridPane.add(new Label("Customer Id:"), 0, 7);
		gridPane.add(customerIdTextField, 1, 7);
		gridPane.add(new Label("Seller Id:"), 0, 8);
		gridPane.add(sellerIdTextField, 1, 8);
		gridPane.add(addSalesButton, 0, 9);
		gridPane.add(makeNewSalesButton, 1, 9);
		gridPane.add(saveSalesButton, 4, 9);

		GuiSettings();
		buttonEvents();

	}

	private void buttonEvents() {
		Date date = new Date();
		String currentDate = date.toLocaleString();

		addSalesButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SalesDao.getInstance().createSales(salesId, productIdTextField.getText(),
						productNameTextField.getText(), Double.parseDouble(priceTextField.getText()),
						Integer.parseInt(quantityTextField.getText()), currentDate, customerIdTextField.getText(),
						sellerIdTextField.getText());
				salesIdText.setText("");
				productIdTextField.clear();
				productNameTextField.clear();
				priceTextField.clear();
				quantityTextField.clear();
				customerIdTextField.clear();
				sellerIdTextField.clear();
				dateText.setText("");

			}
		});
		saveSalesButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				SalesDao.getInstance().saveSales();
				stage.close();
				Menu menuGui = new Menu();
				menuGui.start(stage);
			}
		});
		makeNewSalesButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
				NewSales.getInstance().makeSales();

			}
		});
	}

}