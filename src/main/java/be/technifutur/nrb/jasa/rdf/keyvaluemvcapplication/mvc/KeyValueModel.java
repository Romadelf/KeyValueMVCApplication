package be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc;

import java.util.TreeMap;

import be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.enums.StateEnum;
import be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.exception.OverloadException;

public class KeyValueModel {
    
    private TreeMap<String, String> pool = new TreeMap<String, String>();
    private static final int CAPACITY = 10;
    
    public String add(String key, String value) {
	String oldValueIfAnyNullOtherwise;
	if (this.pool.size() < CAPACITY) {
	    oldValueIfAnyNullOtherwise = this.pool.put(key, value);
	} else {
	    oldValueIfAnyNullOtherwise = this.pool.replace(key, value);
	    if (oldValueIfAnyNullOtherwise == null) {
		throw new OverloadException();
	    }
	}
	return oldValueIfAnyNullOtherwise;
    }

    public String remove(String key) {
	String oldValueIfAnyNullOtherwise = this.pool.remove(key);
	return oldValueIfAnyNullOtherwise;
    }
    
    public StateEnum getState() {
	StateEnum state;
	switch(this.pool.size()) {
	case 0:
	    state = StateEnum.VIDE;
	    break;
	case CAPACITY:
	    state = StateEnum.PLEIN;
	    break;
	default:
	    state = StateEnum.NONVIDE;
	    break;
	}
	return state;
    }

}
