package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class TervehdysGUI extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Tervehdyksiä");
			BorderPane root = new BorderPane();
			GridPane grid = new GridPane();
			Button aamuBTN = new Button("Aamu");
			Button paivaBTN = new Button("Päivä");
			Button iltaBTN = new Button("Ilta");
			Button yoBTN = new Button("Yö");

			Text txt = new Text("Napsauta painiketta");
			txt.setFont(Font.font("arial", FontWeight.BOLD, 20));
			aamuBTN.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					txt.setText("Hyvää Huomenta!");
					System.out.println("Aamu");
				}
			});
			paivaBTN.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					txt.setText("Hyvää Päivää!");
					System.out.println("Päivä");
				}
			});
			iltaBTN.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					txt.setText("Hyvää Iltaa!");
					System.out.println("Ilta");
				}
			});
			yoBTN.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					txt.setText("Hyvää Yötä!");
					System.out.println("Yö");
				}
			});
			grid.setAlignment(Pos.CENTER);
			grid.setVgap(20);
			grid.setHgap(10);
			grid.add(txt, 2, 0);
			grid.add(aamuBTN, 0, 1);
			grid.add(paivaBTN, 1, 1);
			grid.add(iltaBTN, 3, 1);
			grid.add(yoBTN, 4, 1);
			BorderPane.setAlignment(txt, Pos.CENTER);
			root.setTop(txt);
			root.setCenter(grid);
			Scene scene = new Scene(root,400,150);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
