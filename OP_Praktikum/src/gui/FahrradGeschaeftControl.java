package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.*;
import javafx.stage.Stage;

public class FahrradGeschaeftControl {

	private FahrradGeschaeftModel fahrradModel;

	private FahrradGeschaeftView fahrradView;

	public FahrradGeschaeftControl(Stage primaryStage) {
		this.fahrradModel = new FahrradGeschaeftModel();
		this.fahrradView = new FahrradGeschaeftView(this, primaryStage, fahrradModel);
	}

	public void schreibeFahrradInCsvDatei() throws IOException {
		try {
			fahrradModel.schreibeFahrradInCsvDatei();
		} catch (IOException exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

	public void leseAusDatei(String typ) {
		try {
			fahrradModel.leseAusDatei();
			if ("csv".equals(typ)) {
				fahrradView.zeigeInformationsfensterAn("Die Cafes wurden gelesen!");

			} else {

				fahrradView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			fahrradView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			fahrradView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}

}
