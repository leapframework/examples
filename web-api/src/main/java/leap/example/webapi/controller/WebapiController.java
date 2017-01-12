package leap.example.webapi.controller;

import leap.lang.New;
import leap.web.annotation.Path;
import leap.web.annotation.http.DELETE;
import leap.web.annotation.http.GET;
import leap.web.annotation.http.POST;
import leap.web.api.mvc.ApiController;
import leap.web.api.mvc.ApiResponse;

import java.util.Map;

/**
 * Created by kael on 2017/1/11.
 */
@Path("/webapi")
public class WebapiController extends ApiController {
    @GET
    public ApiResponse webapiGet(){
        return ApiResponse.ACCEPTED;
    }
    @POST("/post")
    public ApiResponse webapiPost(){
        return ApiResponse.ACCEPTED;
    }
    @GET("/map")
    public ApiResponse<Map<String, Object>> webapiGetMap(){
        return ApiResponse.ok(New.hashMap("key","value"));
    }
    @DELETE
    public ApiResponse webapiDelete(){
        return ApiResponse.OK;
    }
    
}
