package com.jcwhatever.bukkit.pvs.api.exceptions;

public class PlayerGroupExpectedException extends RuntimeException {

    private String _msg;

    public PlayerGroupExpectedException() {
        _msg = "Player was expected to be in a player group but was not.";
    }

    @Override
    public String getMessage() {
        return _msg;
    }


}