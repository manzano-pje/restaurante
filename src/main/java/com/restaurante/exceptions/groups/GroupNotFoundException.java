package com.restaurante.exceptions.groups;

import com.restaurante.exceptions.ErrorResponse;

public class GroupNotFoundException extends ErrorResponse {
    public GroupNotFoundException(){
        super("Groups not found.", 404);
    }
}
