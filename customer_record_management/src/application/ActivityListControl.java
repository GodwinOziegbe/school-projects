package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

public class ActivityListControl {
	private static ActivityListControl instance = new ActivityListControl();

	public ActivityListControl() {
	}

	public static ActivityListControl getInstance() {
		return instance;
	}

	Stage stage;
	Scene scene;
	GridPane gridPane, printPane;
	private TextField sellerIdTextField = new TextField();
	Button SellerEnterButton, gotoMenuButton;

	public void GuiSettings() {

		stage = new Stage();
		scene = new Scene(printPane, 600, 350);
		stage.setScene(scene);
		stage.setTitle("Seller info");
		stage.show();
	}

	public void getList() {

		SellerEnterButton = new Button("get List");
		printPane = new GridPane();

		printPane.setPadding(new Insets(40, 0, 0, 50));
		printPane.setHgap(5);
		printPane.setVgap(5);
		printPane.setAlignment(Pos.TOP_CENTER);

		printPane.add(new Label("Enter seller Id:"), 0, 1);
		printPane.add(sellerIdTextField, 1, 1);
		printPane.add(SellerEnterButton, 4, 5);

		SellerEnterButton.setOnAction(new EventHandler<ActionEvent>() {
			ArrayList<Sales> currentList = SalesDao.getInstance().getAllSales();
			ArrayList<Activity> currentActivityList = ActivityListSetup.getInstance().getList();
			ArrayList<Activity> activityPrintList = new ArrayList<Activity>();
			int check = 0;

			@Override
			public void handle(ActionEvent event) {

				for (Sales value : currentList) {

					if (value.getSellerId().equals(sellerIdTextField.getText())) {
						check++;

						for (Activity activityEvent : currentActivityList) {

							if (activityEvent.getActivityValue().equals(value.getCustomerId())) {
								activityPrintList.add(activityEvent);
							}
						}
					}

				}

				if (check == 0) {
					System.out.println("No Data Found");
					return;
				}
				stage.close();
				removeDublicates(activityPrintList);

			}

		});
		GuiSettings();

	}

	public void removeDublicates(ArrayList<Activity> theList) {
		ArrayList<Activity> newPrintList = new ArrayList<Activity>();
		for (Activity element : theList) {
			if (!newPrintList.contains(element)) {
				newPrintList.add(element);
			}

		}
		printList(newPrintList);
	}

	public void printList(ArrayList<Activity> printList) {
		int j = 2;

		gotoMenuButton = new Button("main menu");
		printPane = new GridPane();
		printPane.setPadding(new Insets(40, 0, 0, 50));
		printPane.setHgap(5);
		printPane.setVgap(5);
		printPane.setAlignment(Pos.TOP_CENTER);

		printPane.add(new Label("Activity List"), 0, 1);
		printPane.add(new Label("-----------------"), 0, 2);

		for (Activity value : printList) {

			if (value != null) {
				j++;
			}
			printPane.add(new Label("Sales Control registered change in " + value.getActivityName()
					+ " to customer Id: " + value.getActivityValue() + " at: " + value.getActivityDate()), 0, j);

		}

		printPane.add(gotoMenuButton, 2, j + 3);
		gotoMenuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.close();
				Menu.getInstance().start(stage);

			}

		});
		GuiSettings();
	}

}
