package uppgift3;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
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

public class Stoppuret  extends Application{
	Scene scene;
	VBox vBox;
	HBox hBox;
	Text text;
	Button sasButton, resetButton, clearButton;
	Timeline timeline;
	boolean starting = true;
	String current, mytime,text1, text2, text3;
	int min = 0, sec = 0, milli = 0;
	
	public static void main(String[] args) {
		launch(args);
	}

	void changetime(Text text) {
		
		if(milli == 1000) {
			sec++;
			milli = 0;
		}
		if(sec == 60) {
			min++;
			sec = 0;
		}
		if(min<10) {
			text1= "0"+ min + ":";
		}
		else {text1 = ""+ min+ ":";}
		
		if(sec<10) {
			text2= "0"+ sec + ",";
		}
		else {text2 = ""+ sec+ ",";}
		
		if(milli<10) {
			text3= "00"+ milli++;
		}
		else if(milli<100){
			text3="0"+ milli++;
		}
		else {text3 = ""+ milli++;}
		
		
		text.setText(text1+ text2 + text3);
		
		if(sec<10) {
			text2= "0"+ sec + ".";
		}
		else {text2 = ""+ sec+ ".";}
		mytime= "       "+text1+text2+text3;
		
		}
		 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void start(Stage stage) {
		text = new Text("00:00:000");
		timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
            	changetime(text);
			}
		}));
		
		
		TableView tableView = new TableView();
		
		TableColumn<User, String> column1 = new TableColumn<>("Date Time");
		column1.setCellValueFactory(new PropertyValueFactory<>("datetime"));
		
		TableColumn<User, String> column2 = new TableColumn<>("Time");
		column2.setCellValueFactory(new PropertyValueFactory<>("time"));
		
		column1.prefWidthProperty().bind(tableView.widthProperty().multiply(0.5));
		column2.prefWidthProperty().bind(tableView.widthProperty().multiply(0.5));
		
		tableView.getColumns().add(column1);
		tableView.getColumns().add(column2);
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(false);
		
		sasButton = new Button("Start");
		sasButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	if(starting) {
            		timeline.play();
            		starting = false;
            		sasButton.setText("Stop");
            	} else {
            		timeline.pause();
            		starting = true;
            		sasButton.setText("Start");
            	
            		current= myDate();
            		
            		tableView.getItems().add(new User(current, mytime) );
            		
            	}
            }
        });
		resetButton = new Button("Reset");
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	min = 0; sec = 0; milli = 0;
            	timeline.pause();
            	text.setText("00:00:000");
            	if(!starting) {
            		starting = true;
            		sasButton.setText("Start");
            	}
            }
        });
		clearButton = new Button("Clr History");
		clearButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tableView.getItems().clear();	
			}
		});
		
		hBox = new HBox(30);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(sasButton, resetButton, clearButton);
		vBox = new VBox(50);
		
		vBox.setAlignment(Pos.CENTER);
		 vBox.getChildren().addAll(text, hBox,tableView);
		 
		scene = new Scene(vBox, 260, 300); 
		stage.setScene(scene);
        stage.setTitle("Stopwatch");
		stage.show();
	
	}

	private String myDate() {//function to generate date time
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateString = format.format( new Date()   );
		
		return dateString;
	
	}

		

}
