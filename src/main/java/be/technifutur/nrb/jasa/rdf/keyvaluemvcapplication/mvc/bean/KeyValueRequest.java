package be.technifutur.nrb.jasa.rdf.keyvaluemvcapplication.mvc.bean;

public class KeyValueRequest {
    
    private boolean isDeletion;
    private String key;
    private String value;
    
    public boolean isDeletion() {
        return this.isDeletion;
    }

    public void setIsDeletion(boolean isDeletion) {
        this.isDeletion = isDeletion;
    }

    public String getKey() {
        return this.key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

}
