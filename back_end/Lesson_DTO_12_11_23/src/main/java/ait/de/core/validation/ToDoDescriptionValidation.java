package ait.de.core.validation;

import ait.de.dto.ToDoRequest;

public class ToDoDescriptionValidation {
    public void validation(ToDoRequest request){
        if(request.getDescription().length()>30){
            throw new IllegalArgumentException(" ToDo > max length");
        }
    }
}
