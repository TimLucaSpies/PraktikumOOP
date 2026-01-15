package gui.Wahrenuebersicht;

import business.Tees.TeeladenModel;
import business.Tees.Teesorte;
import business.Teetasse.Teetasse;
import business.Teetasse.TeetasseModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class WarenuebersichtView {

	private WarenuebersichtControl warenuebersichtControl;
	private TeeladenModel teesModel;
	private TeetasseModel teetasseModel;
	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeTees = new Label("Anzeige Tees");
	private TextArea txtAnzeigeTees = new TextArea();
	private Button btnAnzeigeTees = new Button("Anzeige");
	private Label lblAnzeigeTeetasse = new Label("Anzeige Teetasse");
	private TextArea txtAnzeigeTeetasse = new TextArea();
	private Button btnAnzeigeTeetasse = new Button("Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public WarenuebersichtView(WarenuebersichtControl warenuebersichtControl, Stage primaryStage,
			TeeladenModel teesModel, TeetasseModel teetasseModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige der Warenuebersicht");
		primaryStage.show();
		this.warenuebersichtControl = warenuebersichtControl;
		this.teesModel = teesModel;
		this.teetasseModel = teetasseModel;
		this.initKomponentenTees();
		this.initKomponentenTeetasse();
		this.initListener();
	}

	private void initKomponenten() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeTees.setLayoutX(310);
		lblAnzeigeTees.setLayoutY(40);
		lblAnzeigeTees.setFont(font);
		lblAnzeigeTees.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeTees);
// Textbereich	
		txtAnzeigeTees.setEditable(false);
		txtAnzeigeTees.setLayoutX(310);
		txtAnzeigeTees.setLayoutY(90);
		txtAnzeigeTees.setPrefWidth(220);
		txtAnzeigeTees.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeTees);
		// Button
		btnAnzeigeTees.setLayoutX(310);
		btnAnzeigeTees.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeTees);
	}
	
	private void initKomponentenTees() {
		Font font = new Font("Arial", 20);
		lblAnzeigeTees.setLayoutX(310);
		lblAnzeigeTees.setLayoutY(40);
		lblAnzeigeTees.setFont(font);
		lblAnzeigeTees.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeTees);
// Textbereich	
		txtAnzeigeTees.setEditable(false);
		txtAnzeigeTees.setLayoutX(310);
		txtAnzeigeTees.setLayoutY(90);
		txtAnzeigeTees.setPrefWidth(220);
		txtAnzeigeTees.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeTees);
		// Button
		btnAnzeigeTees.setLayoutX(310);
		btnAnzeigeTees.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeTees);
	}
	
	private void initKomponentenTeetasse() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeTeetasse.setLayoutX(100);
		lblAnzeigeTeetasse.setLayoutY(40);
		lblAnzeigeTeetasse.setFont(font);
		lblAnzeigeTeetasse.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeTeetasse);
// Textbereich	
		txtAnzeigeTeetasse.setEditable(false);
		txtAnzeigeTeetasse.setLayoutX(70);
		txtAnzeigeTeetasse.setLayoutY(90);
		txtAnzeigeTeetasse.setPrefWidth(220);
		txtAnzeigeTeetasse.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeTeetasse);
		// Button
		btnAnzeigeTeetasse.setLayoutX(100);
		btnAnzeigeTeetasse.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeTeetasse);
	}

	private void initListener() {
		btnAnzeigeTees.setOnAction(e -> zeigeTeesAn());
		btnAnzeigeTeetasse.setOnAction(e -> zeigeTeetassenAn());
	}

	public void zeigeTeesAn() {
		if (teesModel.getTs().size() > 0) {
			String text = "";
			for (Teesorte ts : teesModel.getTs()) {
				text = text + ts.gibTeesorteZurueck(' ') + "\n";
			}
			txtAnzeigeTees.setText(text);
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Tee aufgenommen!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

	private void zeigeTeetassenAn() {
		warenuebersichtControl.leseTeetassenAusCsvDatei();
		if (teetasseModel.getTt().size() > 0) {
			StringBuffer text = new StringBuffer();
			for (Teetasse sh : teetasseModel.getTt()) {
				text.append(sh.gibTeetasseZurueck(' ') + "\n");
			}
			this.txtAnzeigeTeetasse.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Es gibt keine Tetasse in der csv-Datei!");
		}
	}

}
