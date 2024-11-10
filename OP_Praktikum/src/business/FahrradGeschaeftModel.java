package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FahrradGeschaeftModel {

	private Fahrrad fahrrad;

	public Fahrrad getFahrrad() {
		return this.fahrrad;
	}

	public void setFahrrad(Fahrrad fahrrad) {
		this.fahrrad = fahrrad;
	}

	public void schreibeFahrradInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("Fahrrad.csv", true));
		aus.write(this.fahrrad.gibFahrradZurueck(';'));
		aus.close();
	}

	public void leseAusDatei() throws IOException{
			BufferedReader ein = new BufferedReader(new FileReader("Fahrrad.csv"));
			String[] zeile = ein.readLine().split(";");
			this.fahrrad = new Fahrrad(zeile[0], Integer.parseInt(zeile[1]), zeile[2], zeile[3],
					zeile[4].split("_"));
			ein.close();
		}
	}

