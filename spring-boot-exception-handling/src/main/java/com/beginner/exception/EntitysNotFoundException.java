package com.beginner.exception;

public class EntitysNotFoundException extends RuntimeException {

    public EntitysNotFoundException (String param) {
        super(param);
    }
}
