package leap.example.api2.controller;

import leap.web.annotation.Path;
import leap.web.annotation.http.GET;
import leap.web.annotation.http.POST;
import leap.web.api.mvc.ApiController;
import leap.web.api.mvc.ApiResponse;
import leap.web.api.mvc.params.QueryOptions;

/**
 * Created by kael on 2017/1/12.
 */
@Path("/")
public class Api2Controller extends ApiController {
    @GET("/get")
    public ApiResponse get(String id){
        return ApiResponse.OK;
    }
    @POST("/post")
    public ApiResponse post(QueryOptions options){
        return ApiResponse.OK;
    }
    
    @Path("inner")
    public class InnerController extends ApiController{
        @GET("/get")
        public ApiResponse get(){
            return ApiResponse.OK;
        }
    }
}
