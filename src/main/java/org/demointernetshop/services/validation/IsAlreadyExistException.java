package org.demointernetshop.services.validation;

    public class IsAlreadyExistException extends RuntimeException {

        public IsAlreadyExistException(String message) {
            super(message);
        }
    }

