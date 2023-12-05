package org.group28projectjpa_21_11.core.validation;

public class IsAlreadyExistException extends RuntimeException {

    public IsAlreadyExistException(String message) {
        super(message);
    }
}
