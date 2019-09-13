package be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc;

import be.technifutur.applicationrunner.mvc.Controler;
import be.technifutur.applicationrunner.mvc.MVCFactory;
import be.technifutur.applicationrunner.mvc.View;

public class KeyValueMVCFactory implements MVCFactory<KeyValueModel> {
    
    private KeyValueModel model;
    private KeyValueControler controler;
    private KeyValueVue vue;    
    
    public KeyValueMVCFactory() {
	super();
	KeyValueModel model = new KeyValueModel();
	KeyValueControler controler = new KeyValueControler();
	KeyValueVue vue = new KeyValueVue();
	// Les deux lignes suivantes sont redondantes car un MVCApplication les exécute également lors d'un start. 
	controler.setModel(model);
	vue.setModel(model);
	//
	this.model = model;
	this.controler = controler;
	this.vue = vue;
    }

    public KeyValueModel getModel() {
	return this.model;
    }

    public Controler<KeyValueModel> getControler() {
	return this.controler;
    }

    public View<KeyValueModel> getVue() {
	return this.vue;
    }

}
