package com.restaurante.exceptions.groups;

import com.restaurante.exceptions.ErrorResponse;

public class GroupAlerdyExistExceptioin extends ErrorResponse {
    public GroupAlerdyExistExceptioin(){

        super("GroupAlerdyExistExceptioin", 409);
    }
}
