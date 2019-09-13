package be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc;

import java.util.TreeMap;

import be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.enums.ModelStateEnum;
import be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.exception.OverloadException;

public class KeyValueModel {
    
    private static final int CAPACITY = 10;

    private TreeMap<String, String> pool;
    private ModelStateEnum modelState;
    private boolean stopped;
    
    private void updateState() {
	ModelStateEnum state;
	switch(this.pool.size()) {
	case 0:
	    state = ModelStateEnum.VIDE;
	    break;
	case CAPACITY:
	    state = ModelStateEnum.PLEIN;
	    break;
	default:
	    state = ModelStateEnum.NONVIDE;
	    break;
	}
	this.modelState = state;
    }

    public boolean isStopped() {
        return stopped;
    }
    
    public ModelStateEnum getState() {
        return this.modelState;
    }
    
    public void start() {
	this.pool = new TreeMap<String, String>();
	this.stopped = false;
	this.updateState();
    }

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
	this.updateState();
	return oldValueIfAnyNullOtherwise;
    }

    public String remove(String key) {
	String oldValueIfAnyNullOtherwise = this.pool.remove(key);
	this.updateState();
	return oldValueIfAnyNullOtherwise;
    }

}
