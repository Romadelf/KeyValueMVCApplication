package be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc;

import be.technifutur.applicationrunner.mvc.Controler;

public class KeyValueControler implements Controler<KeyValueModel> {

    private KeyValueModel model;

    public void setModel(KeyValueModel model) {
	this.model = model;
    }

    public void start() {
	this.model.start();
    }

    public boolean isfinish() {
	return this.model.isStopped();
    }

    public void newInput(String input) {
	// TODO Auto-generated method stub
	
    }

    public boolean hasLastScreen() {
	// TODO Auto-generated method stub
	return false;
    }

    public void stop() {
	// TODO Auto-generated method stub
	
    }

}
