package application;

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

public class NewCustomer {
	Stage stage;
	Scene scene;
	GridPane gridPane;
	Text salesIdText;
	Button addCustomerButton;

	private static NewCustomer instance = new NewCustomer();
	private TextField customerIdTextField = new TextField();
	private TextField customerNameTextField = new TextField();
	private TextField customerAdressTextField = new TextField();

	public NewCustomer() {

	}

	public static NewCustomer getInstance() {
		return instance;
	}

	public void GUI() {

		createCustomers();
		buttonEvents();
		stage = new Stage();
		scene = new Scene(gridPane, 370, 300);
		stage.setScene(scene);
		stage.setTitle("Create Customers");
		stage.show();
	}

	public void createCustomers() {

		addCustomerButton = new Button("Add");

		gridPane = new GridPane();

		gridPane.setPadding(new Insets(40, 0, 0, 50));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.setAlignment(Pos.TOP_CENTER);

		gridPane.add(new Label("Customer Id:"), 0, 1);
		gridPane.add(customerIdTextField, 1, 1);
		gridPane.add(new Label("Customer Name:"), 0, 2);
		gridPane.add(customerNameTextField, 1, 2);
		gridPane.add(new Label("Customer Adress:"), 0, 3);
		gridPane.add(customerAdressTextField, 1, 3);
		gridPane.add(addCustomerButton, 4, 5);

	}

	private void buttonEvents() {

		addCustomerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Customer currentCustomer = new Customer(customerIdTextField.getText(), customerNameTextField.getText(),
						customerAdressTextField.getText());

				CustomerDao.getInstance().saveCustomer(currentCustomer);

				stage.close();
				Menu menuGui = new Menu();
				menuGui.start(stage);
			}
		});

	}

}
