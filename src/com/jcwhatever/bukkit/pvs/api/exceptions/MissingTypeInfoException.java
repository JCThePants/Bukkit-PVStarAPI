package com.jcwhatever.bukkit.pvs.api.exceptions;

/**
 * Created by John on 10/2/2014.
 */
public class MissingTypeInfoException extends RuntimeException {

    private String _msg;

    public MissingTypeInfoException(Class<?> clazz) {
        _msg = "Expected but did not find proper type info annotation on class: " + clazz.getName();
    }

    @Override
    public String getMessage() {
        return _msg;
    }


}
