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
	    switch (this.viewState) {
	    case 1:
		screen.append(this.APP_TITLE);
		screen.append("\n   liste vide...\n");
		screen.append("\n> Entrez une clé: ");
		break;
	    case 2:
		screen.append("> Entrez sa valeur: ");
		break;
	    default:
		// ??
		break;
	    }
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
