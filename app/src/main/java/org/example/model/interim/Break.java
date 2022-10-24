package org.example.model.interim;

public class Break extends InterimState {

    public Break() {
        super(InterimType.BREAK);
    }

    @Override
    public String handle() {
        return "break";
    }

}
