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

public class NewSeller {
	Stage stage;
	Scene scene;
	GridPane gridPane;
	Text salesIdText;
	Button addSellerButton;
	private static NewSeller instance = new NewSeller();
	private TextField sellerIdTextField = new TextField();
	private TextField sellerNameTextField = new TextField();
	private TextField sellerAddressTextField = new TextField();

	public NewSeller() {

	}

	public static NewSeller getInstance() {
		return instance;
	}

	public void GuiSettings() {

		stage = new Stage();
		scene = new Scene(gridPane, 350, 300);
		stage.setScene(scene);
		stage.setTitle("Create Sellers");
		stage.show();
	}

	public void createSeller() {

		addSellerButton = new Button("Add");
		gridPane = new GridPane();

		gridPane.setPadding(new Insets(40, 0, 0, 50));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.setAlignment(Pos.TOP_CENTER);

		gridPane.add(new Label("Seller Id:"), 0, 1);
		gridPane.add(sellerIdTextField, 1, 1);
		gridPane.add(new Label("Seller Name:"), 0, 2);
		gridPane.add(sellerNameTextField, 1, 2);
		gridPane.add(new Label("Seller Adress:"), 0, 3);
		gridPane.add(sellerAddressTextField, 1, 3);

		gridPane.add(addSellerButton, 4, 5);

		buttonEvents();
		GuiSettings();
	}

	private void buttonEvents() {
		addSellerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Seller currentSeller = new Seller(sellerIdTextField.getText(), sellerNameTextField.getText(),
						sellerAddressTextField.getText());

				SellerDao.getInstance().saveSeller(currentSeller);

				stage.close();
				Menu menuGui = new Menu();
				menuGui.start(stage);
			}
		});

	}

}
