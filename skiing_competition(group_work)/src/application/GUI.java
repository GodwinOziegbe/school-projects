package landskidstavling;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI {
	
	Stage stage;
	VBox SkierDisplay, competitionDisplay;
	HBox Skier1Box, Skier2Box, Skier3Box, Skier4Box, Skier5Box;

	Timeline timeline;
	Text nameTitle, distTitle, speedTitle;
	Text skier1Name, skier2Name, skier3Name, skier4Name, skier5Name;
	Text distanceSkier1, distanceSkier2, distanceSkier3, distanceSkier4, distanceSkier5;
	Text speedSkier1, speedSkier2, speedSkier3, speedSkier4, speedSkier5;
	Text timerText;
	Button startButton, newCompetitionButton, resetButton;
	Button skier1StopButton, skier2StopButton, skier3StopButton, skier4StopButton, skier5StopButton;
	Button lapTimeSkier1Button, lapTimeSkier2Button, lapTimeSkier3Button, lapTimeSkier4Button, lapTimeSkier5Button;
	boolean startStop = true;
	
	Double distance = 0.0, dist1 = 0.0, dist2 = 0.0, dist3 = 0.0, dist4 = 0.0, dist5 = 0.0;

	Timers timers = new Timers();
	Main main = new Main();

	ArrayList<Skiers> skierList = new ArrayList<Skiers>();
	TableView<Skiers> tableView = new TableView<Skiers>();

	public void Gui() {

		Skiers one = new Skiers();
		one.setName("Karl Nilsson          ");
		one.setId(1101);
		Skiers two = new Skiers();
		two.setName("Nils Svensson       ");
		two.setId(1102);
		Skiers three = new Skiers();
		three.setName("Anders Pettersson");
		three.setId(1103);
		Skiers four = new Skiers();
		four.setName("Joakim Karlsson    ");
		four.setId(1104);
		Skiers five = new Skiers();
		five.setName("Fredrik Hakansson");
		five.setId(1105);

		setupText(one, two, three, four, five);
		setupButtons();
		setupTable();
		laptimeButtonsEvent(one, two, three, four, five);
		skiersStopButtonEvent(one, two, three, four, five);
		setupCompetitionButtonsEvent();

		timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				timers.changetime(timerText);
			}
		}));

		timeline.setCycleCount(Timeline.INDEFINITE);

		

		HBox titleBox = new HBox(15);
		titleBox.setAlignment(Pos.BASELINE_LEFT);
		titleBox.getChildren().addAll(nameTitle, distTitle, speedTitle);

		Skier1Box = new HBox(15);
		Skier1Box.setAlignment(Pos.CENTER);
		Skier1Box.getChildren().addAll(skier1Name, distanceSkier1, speedSkier1, lapTimeSkier1Button, skier1StopButton);

		Skier2Box = new HBox(15);
		Skier2Box.setAlignment(Pos.CENTER);
		Skier2Box.getChildren().addAll(skier2Name, distanceSkier2, speedSkier2, lapTimeSkier2Button, skier2StopButton);

		Skier3Box = new HBox(15);
		Skier3Box.setAlignment(Pos.CENTER);
		Skier3Box.getChildren().addAll(skier3Name, distanceSkier3, speedSkier3, lapTimeSkier3Button, skier3StopButton);

		Skier4Box = new HBox(15);
		Skier4Box.setAlignment(Pos.CENTER);
		Skier4Box.getChildren().addAll(skier4Name, distanceSkier4, speedSkier4, lapTimeSkier4Button, skier4StopButton);

		Skier5Box = new HBox(15);
		Skier5Box.setAlignment(Pos.CENTER);
		Skier5Box.getChildren().addAll(skier5Name, distanceSkier5, speedSkier5, lapTimeSkier5Button, skier5StopButton);

		SkierDisplay = new VBox(10);
		SkierDisplay.setAlignment(Pos.CENTER);
		SkierDisplay.getChildren().addAll(titleBox, Skier1Box, Skier2Box, Skier3Box, Skier4Box, Skier5Box);

		HBox competitionButtonBox = new HBox(30);
		competitionButtonBox.setAlignment(Pos.CENTER);
		competitionButtonBox.getChildren().addAll(startButton, resetButton, newCompetitionButton);

		competitionDisplay = new VBox(20);
		competitionDisplay.setAlignment(Pos.CENTER);
		competitionDisplay.getChildren().addAll(competitionButtonBox, timerText, tableView);

		VBox layout = new VBox(70);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(SkierDisplay, competitionDisplay);

		stage = new Stage();
		Scene scene = new Scene(layout, 500, 700);
		stage.setScene(scene);
		stage.setTitle("Skid Competition");
		stage.show();

	}

	private void setupTable() {
		TableColumn<Skiers, String> column1 = new TableColumn<Skiers, String>("ID");
		column1.setCellValueFactory(new PropertyValueFactory<Skiers, String>("id"));
		TableColumn<Skiers, String> column2 = new TableColumn<Skiers, String>("Name");
		column2.setCellValueFactory(new PropertyValueFactory<Skiers, String>("name"));
		TableColumn<Skiers, String> column3 = new TableColumn<Skiers, String>("Lap Time");
		column3.setCellValueFactory(new PropertyValueFactory<Skiers, String>("lapTime"));
		TableColumn<Skiers, String> column4 = new TableColumn<Skiers, String>("Finish Time");
		column4.setCellValueFactory(new PropertyValueFactory<Skiers, String>("lastCompetitionTime"));

		column1.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
		column2.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
		column3.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
		column4.prefWidthProperty().bind(tableView.widthProperty().multiply(0.25));
		tableView.getColumns().addAll(column1, column2, column3, column4);
	}

	private void setupText(Skiers one, Skiers two, Skiers three, Skiers four, Skiers five) {
		skier1Name = new Text();
		skier1Name.setText(one.getName());
		skier2Name = new Text();
		skier2Name.setText(two.getName());
		skier3Name = new Text();
		skier3Name.setText(three.getName());
		skier4Name = new Text();
		skier4Name.setText(four.getName());
		skier5Name = new Text();
		skier5Name.setText(five.getName());

		timerText = new Text("00:00:000");

		speedSkier1 = new Text("00.00");
		speedSkier2 = new Text("00.00");
		speedSkier3 = new Text("00.00");
		speedSkier4 = new Text("00.00");
		speedSkier5 = new Text("00.00");

		nameTitle = new Text("  		Name");
		distTitle = new Text("   Dist.(m)");
		speedTitle = new Text("Speed(m/s)");

		distanceSkier1 = new Text("00.00");
		distanceSkier2 = new Text("00.00");
		distanceSkier3 = new Text("00.00");
		distanceSkier4 = new Text("00.00");
		distanceSkier5 = new Text("00.00");
	}

	private void setupButtons() {
		startButton = new Button("Start");

		skier1StopButton = new Button("Stop");
		skier2StopButton = new Button("Stop");
		skier3StopButton = new Button("Stop");
		skier4StopButton = new Button("Stop");
		skier5StopButton = new Button("Stop");

		lapTimeSkier1Button = new Button("LapTime");
		lapTimeSkier2Button = new Button("LapTime");
		lapTimeSkier3Button = new Button("LapTime");
		lapTimeSkier4Button = new Button("LapTime");
		lapTimeSkier5Button = new Button("LapTime");

		resetButton = new Button("Reset");

		newCompetitionButton = new Button("New Competition");

	}

	private void skiersStopButtonEvent(Skiers one, Skiers two, Skiers three, Skiers four, Skiers five) {
		skier1StopButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!startStop) {
					tableView.getItems().add(one);
					one.setLastCompetitionTime(timers.time);
					skierList.add(one);
				}
			}
		});
		skier2StopButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!startStop) {
					tableView.getItems().add(two);
					two.setLastCompetitionTime(timers.time);
					skierList.add(two);
				}
			}
		});
		skier3StopButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!startStop) {
					tableView.getItems().add(three);
					three.setLastCompetitionTime(timers.time);
					skierList.add(three);
				}
			}
		});
		skier4StopButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!startStop) {
					tableView.getItems().add(four);
					four.setLastCompetitionTime(timers.time);
					skierList.add(four);
				}
			}
		});
		skier5StopButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!startStop) {
					five.setLastCompetitionTime(timers.time);
					tableView.getItems().add(five);
					skierList.add(five);
				}
			}
		});

	}

	private void setupCompetitionButtonsEvent() {
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (startStop) {
					timeline.play();
					startStop = false;
					startButton.setText("Stop");
					resetButton.setDisable(true);
				} else {
					timeline.pause();
					startStop = true;
					startButton.setText("Start");
					resetButton.setDisable(false);
				}
			}
		});

		resetButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				timerText.setText("00:00:000");
				timers.min = 0;
				timers.sec = 0;
				timers.milli = 0;

				tableView.getItems().clear();
			}
		});
		newCompetitionButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Serializer.saveSkiers(skierList);
				stage.close();
				main.start(stage);
			}
		});
	}
	
	private void laptimeButtonsEvent(Skiers one, Skiers two, Skiers three, Skiers four, Skiers five) {
		if (startStop) {
			lapTimeSkier1Button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					speedSkier1.setText(calculateAverageSpeed(timers.timeInSeconds, dist1).toString());
					dist1 += 500;
					distanceSkier1.setText(dist1.toString());
					one.setLapTime(timers.time);
					tableView.getItems().add(one);
				}

			});
			lapTimeSkier2Button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					speedSkier2.setText(calculateAverageSpeed(timers.timeInSeconds, dist2).toString());
					dist2 += 500;
					distanceSkier2.setText(dist2.toString());
					two.setLapTime(timers.time);
					tableView.getItems().add(two);
				}
			});
			lapTimeSkier3Button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

					speedSkier3.setText(calculateAverageSpeed(timers.timeInSeconds, dist3).toString());
					dist3 += 500;
					distanceSkier3.setText(dist3.toString());
					three.setLapTime(timers.time);
					tableView.getItems().add(three);
				}

			});
			lapTimeSkier4Button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					speedSkier4.setText(calculateAverageSpeed(timers.timeInSeconds, dist4).toString());
					dist4 += 500;
					distanceSkier4.setText(dist4.toString());
					four.setLapTime(timers.time);
					tableView.getItems().add(four);
				}

			});
			lapTimeSkier5Button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					speedSkier5.setText(calculateAverageSpeed(timers.timeInSeconds, dist5).toString());
					dist5 += 500;
					distanceSkier5.setText(dist5.toString());
					five.setLapTime(timers.time);
					tableView.getItems().add(five);
				}
			});
		}

	}

	private Double calculateAverageSpeed(int timeInSeconds, Double distance) {
		Double averageSpeed;
		if (timeInSeconds <= 0) {
			averageSpeed = 0.0;
		} else {
			distance += 500;
			averageSpeed = (double) Math.round(distance / timeInSeconds);

		}
		return averageSpeed;
	}
}


