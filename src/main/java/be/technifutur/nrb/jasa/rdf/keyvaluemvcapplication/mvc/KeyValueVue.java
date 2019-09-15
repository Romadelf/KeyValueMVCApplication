package be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc;

import be.technifutur.applicationrunner.mvc.View;

public class KeyValueVue implements View<KeyValueModel> {

    private final String APP_TITLE = "     ---  Application Clés-Valeurs  ---     \n";

    private KeyValueModel model;
    private int viewState;

    public void setModel(KeyValueModel model) {
	this.model = model;
    }

    public void start() {
	this.viewState = 1;
    }

    public StringBuilder getScreen() {
	StringBuilder screen = new StringBuilder();
	switch (this.model.getState()) {
	case VIDE:
	    if (this.model.getKeyValueRequest().isDeletion() == false) {
		for (int i = 0; i < 100; i++) { // Aim: clean the console -- WARNING: may be dependent to the ConsoleEnvironnement Environnement
		    screen.append("\n");
		}
		screen.append(this.APP_TITLE);
		screen.append("\n   liste vide...\n");
		screen.append("\n> Entrez une clé: ");
	    }
//	    case 2:
//		screen.append("> Entrez sa valeur: ");
//		break;
//	    default:
//		// ??
//		break;
	    break;
	case NONVIDE:
	    //
	    break;
	case PLEIN:
	    //
	    break;
	default:
	    // ???
	    break;
	}
	return screen;
    }

    public void stop() {
	// TODO Auto-generated method stub

    }

}
