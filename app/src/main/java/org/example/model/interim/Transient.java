package org.example.model.interim;

public class Transient extends InterimState {

    private String metadata;

    public Transient(String metadata) {
        super(InterimType.TRANSIENT);
        this.metadata = metadata;
    }

    @Override
    public String handle() {
        return metadata;
    }

}
