package application;

import controller.IView;
import controller.Tehtava5Ohjain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class KolikkoGUI extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			IView ohjain = new Tehtava5Ohjain();
			
			primaryStage.setTitle("Kolikko");
			BorderPane root = new BorderPane();
			GridPane grid = new GridPane();
			Button hettoBTN = new Button("Heitä");

			Text txt = new Text("Napsauta painiketta");
			txt.setFont(Font.font("arial", FontWeight.BOLD, 20));
			txt.setTextAlignment(TextAlignment.CENTER);
			hettoBTN.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					ohjain.heitäNoppa();
					txt.setText("Heittokertoja: " + ohjain.heittojenLkm() + "\nTulos:" + ohjain.tulos() );
					System.out.println("Arvo: " + ohjain.nopanArvo() + ", Heittojen Lukumäärä: " + ohjain.heittojenLkm());
				}
			});
			grid.setAlignment(Pos.CENTER);
			grid.setVgap(20);
			grid.setHgap(10);
			grid.add(hettoBTN, 0, 1);
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
