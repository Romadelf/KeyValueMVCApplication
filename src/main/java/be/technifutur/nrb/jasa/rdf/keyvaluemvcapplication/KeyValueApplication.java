package be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication;

import be.technifutur.applicationrunner.mvc.MVCFramework;
import be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc.KeyValueMVCFactory;
import be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc.KeyValueModel;

public class KeyValueApplication {

    public static void main(String[] args) {
	new MVCFramework<KeyValueModel>().start(new KeyValueMVCFactory());
    }

}
