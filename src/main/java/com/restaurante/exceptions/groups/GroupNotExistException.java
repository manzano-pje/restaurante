package com.restaurante.exceptions.groups;

import com.restaurante.exceptions.ErrorResponse;

public class GroupNotExistException extends ErrorResponse {
    public GroupNotExistException(){
        super("Group not exist.", 404);
    }
}
