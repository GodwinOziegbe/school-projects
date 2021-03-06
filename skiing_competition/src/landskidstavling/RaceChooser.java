package landskidstavling;

import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RaceChooser {
	GUI gui = new GUI();

	ObservableList<Skiers> skiersLista = FXCollections.observableArrayList(Serializer.loadSkiers());

	public void jaktStart() {
		gui.Gui();

		FXCollections.sort(skiersLista, new Comparator<Skiers>() {

			@Override
			public int compare(Skiers o1, Skiers o2) {
				return String.valueOf(o1.getLastCompetitionTime()).compareTo(o2.getLastCompetitionTime());
			}

		});
		gui.skier1Name.setText("1. " + skiersLista.get(0).getName());
		gui.skier2Name.setText("2. " + skiersLista.get(1).getName());
		gui.skier3Name.setText("3. " + skiersLista.get(2).getName());
		gui.skier4Name.setText("4. " + skiersLista.get(3).getName());
		gui.skier5Name.setText("5. " + skiersLista.get(4).getName());
		gui.tableView.getItems().addAll(skiersLista);

	}

	public void gruppStart() {
		gui.Gui();

	}

	public void IndividuellStart() {
		gui.Gui();
	}

}
