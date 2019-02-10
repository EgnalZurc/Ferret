package com.ferret;

import com.blade.mvc.annotation.*;
import com.blade.mvc.ui.RestResponse;
import com.blade.mvc.RouteContext;
import com.jsoniter.JsonIterator;

@Path("")
public class ActionController {

    @PostRoute("/ferret")
    @JSON
    public RestResponse doAction(@Param String request){
        try {
            Action action = JsonIterator.deserialize(request, Action.class); 
            return RestResponse.ok(action.doAction());
        } catch (Exception e) {
            return RestResponse.fail(e.toString());
        }
    }
}