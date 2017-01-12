package leap.example.api1.controller;

import leap.web.annotation.Path;
import leap.web.annotation.http.GET;
import leap.web.annotation.http.POST;
import leap.web.api.mvc.ApiController;
import leap.web.api.mvc.ApiResponse;

/**
 * Created by kael on 2017/1/12.
 */
@Path("")
public class Api1Controller extends ApiController {
    @GET("/")
    public ApiResponse get(){
        return ApiResponse.OK;
    }
    @POST("/")
    public ApiResponse POST(){
        return ApiResponse.OK;
    }
}
