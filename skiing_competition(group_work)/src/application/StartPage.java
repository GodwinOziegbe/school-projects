package landskidstavling;

import javafx.application.Application;
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

public class StartPage extends Application {
	@Override
	public void start(Stage primaryStage) {

		GridPane gridPane = new GridPane();
		primaryStage.setTitle("Competition");
		gridPane.setPadding(new Insets(40, 0, 0, 50));
		gridPane.setHgap(5);
		gridPane.setVgap(5);

		Text competition = new Text();
		competition.setText("Select Competition: ");

		ComboBox<String> comboBox = new ComboBox<String>();
		comboBox.getItems().add("Individual Race");
		comboBox.getItems().add("Chase Race");
		comboBox.getItems().add("Group Race");

		Button start = new Button();
		start.setText("Next");

		RaceChooser race = new RaceChooser();
		GridPane.setHalignment(start, HPos.RIGHT);
		gridPane.add(competition, 1, 1);
		gridPane.add(comboBox, 2, 1);
		gridPane.add(start, 2, 3);
		
		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent click) {
				if (comboBox.getSelectionModel().isEmpty()) {
					competition.setText("You need to select competition");
					return;
				}
				if (comboBox.getSelectionModel().getSelectedItem().equals("Group Race")) {
					race.gruppStart();
					primaryStage.close();

				}
				if (comboBox.getSelectionModel().getSelectedItem().equals("Chase Race")) {
					race.jaktStart();
					primaryStage.close();
				}
				if (comboBox.getSelectionModel().getSelectedItem().equals("Individual Race")) {
					race.IndividuellStart();
					primaryStage.close();
				}
			}
		});

		

		primaryStage.setScene(new Scene(gridPane, 400, 200));
		primaryStage.show();

	}
}
