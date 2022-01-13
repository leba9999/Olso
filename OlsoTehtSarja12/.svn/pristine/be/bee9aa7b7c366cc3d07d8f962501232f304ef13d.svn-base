package view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import controller.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ValuuttakoneenGUI extends Application implements IValuuttakoneenUI {

	private IValuuttakoneenOhjain ohjain;

	private TextField määräField = new TextField();
	private TextField tulosField = new TextField();
	private ListView<String> valuuttaList = new ListView<String>();
	private ListView<String> valuuttaList2 = new ListView<String>();
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public int getMistäIndeksi() {
		return this.valuuttaList.getSelectionModel().getSelectedIndex();
	}

	@Override
	public int getMihinIndeksi() {
		return this.valuuttaList2.getSelectionModel().getSelectedIndex();
	}

	@Override
	public double getMäärä() {
		double määrä = -1;
		try{
			String txt = määräField.getText();
			if(!txt.isBlank()) {
				NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
				Number number;
				try {
					number = format.parse(txt);
					määrä = number.doubleValue();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error: NumberFormatException");
			alert.setContentText("Syötetty numero ei kelpaa");
			alert.showAndWait();
		}
		return määrä;
	}

	@Override
	public void setTulos(double määrä) {
		DecimalFormat formatter = new DecimalFormat("#0.00");
		this.tulosField.setText(formatter.format(määrä));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			ohjain = new ValuuttakoneenOhjain(this);
			primaryStage.setTitle("Valuuttakone");
			
			HBox hBox = new HBox();
			hBox.setPadding(new Insets(15, 12, 15, 12)); // marginaalit ylä, oikea, ala, vasen
			hBox.setSpacing(10); // väliiin 10 pikseliä
			hBox.setStyle("-fx-background-color: #30aeff");

			valuuttaList.setPrefSize(150, 120);
			valuuttaList2.setPrefSize(150, 120);

			ObservableList<String> valuutat = FXCollections.observableArrayList();
			for(int i = 0; i < ohjain.getValuutat().length; i++) {
				valuutat.add(ohjain.getValuutat()[i]);
			}
			valuuttaList.setItems(valuutat);
			valuuttaList2.setItems(valuutat);
			//valuuttaList.getSelectionModel().select(0);
			//valuuttaList2.getSelectionModel().select(0);

			Button muunnosBtn = new Button("Muunna");
			muunnosBtn.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					boolean error = false;
					if(getMistäIndeksi() < 0 || getMihinIndeksi() < 0) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Valitse muunnettavat valuutat");
						alert.setHeaderText("Valitse muunnettavat valuutat");
						alert.setContentText("Ei ole valittu Mistä tai Mihin valuuttoja");
						error = true;
						alert.showAndWait();
					}
					if(getMäärä() < 0){
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Valitse muunnettava Määrä");
						alert.setHeaderText("Valitse muunnettava määrä");
						alert.setContentText("Muunnettava määrä ei ole hyväsyttävä numero arvo");
						error = true;
						alert.showAndWait();
					}
					if(!error && getMäärä() > 0) {
						ohjain.muunnos();
					}
				}
			});

			VBox inputBox = new VBox();
			inputBox.getChildren().addAll(new Label("Määrä"), määräField, muunnosBtn, new Label("Tulos:"), tulosField);
			VBox valuuttaBox = new VBox();
			valuuttaBox.getChildren().addAll(new Label("Mistä"), valuuttaList);
			VBox valuuttaBox2 = new VBox();
			valuuttaBox2.getChildren().addAll(new Label("Mihin"), valuuttaList2);

			GridPane valuuttaGrid = new GridPane();
			valuuttaGrid.setHgap(10);
			valuuttaGrid.setVgap(10);
			valuuttaGrid.setPadding(new Insets(0, 10, 0, 10));

			valuuttaGrid.setAlignment(Pos.CENTER);
			valuuttaGrid.add(valuuttaBox, 0, 0);
			valuuttaGrid.add(valuuttaBox2, 1, 0);
			valuuttaGrid.add(inputBox, 2, 0);
			
			hBox.getChildren().addAll(valuuttaGrid);
			Scene scene = new Scene(hBox,500,200);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
