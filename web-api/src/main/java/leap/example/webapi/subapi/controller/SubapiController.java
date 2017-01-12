package leap.example.webapi.subapi.controller;

import leap.web.annotation.Path;
import leap.web.annotation.http.GET;
import leap.web.api.mvc.ApiController;
import leap.web.api.mvc.ApiResponse;

/**
 * Created by kael on 2017/1/11.
 */
@Path("/")
public class SubapiController extends ApiController {
    @GET
    public ApiResponse subapi(){
        return ApiResponse.ACCEPTED;
    }
    
}
