package be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc;

import java.util.TreeMap;

import be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.exception.OverloadException;
import be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc.bean.KeyValueRequest;
import be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc.enum_.ModelStateEnum;

public class KeyValueModel {
    
    private static final int CAPACITY = 10;

    private TreeMap<String, String> pool;
    private KeyValueRequest keyValueRequest;
    private boolean stopped;

    public KeyValueRequest getKeyValueRequest() {
        return this.keyValueRequest;
    }
    
    public ModelStateEnum getState() {
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
	return state;
    }

    public boolean isStopped() {
        return this.stopped;
    }
    
    public void start() {
	this.pool = new TreeMap<String, String>();
	this.keyValueRequest = new KeyValueRequest();
	this.keyValueRequest.setIsDeletion(false);
	this.stopped = false;
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
	return oldValueIfAnyNullOtherwise;
    }

    public String remove(String key) {
	String oldValueIfAnyNullOtherwise = this.pool.remove(key);
	return oldValueIfAnyNullOtherwise;
    }

}
