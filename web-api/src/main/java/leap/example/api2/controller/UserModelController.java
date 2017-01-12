package leap.example.api2.controller;

import leap.example.api2.model.UserModel;
import leap.web.annotation.Path;
import leap.web.annotation.http.DELETE;
import leap.web.annotation.http.GET;
import leap.web.annotation.http.PATCH;
import leap.web.annotation.http.POST;
import leap.web.api.mvc.ApiResponse;
import leap.web.api.mvc.ModelController;
import leap.web.api.mvc.params.DeleteOptions;
import leap.web.api.mvc.params.Partial;
import leap.web.api.mvc.params.QueryOptions;

import java.util.List;

/**
 * Created by kael on 2017/1/12.
 *
 * 继承 {@link ModelController} 可以获得许多强大的查询接口，但是一般只有在针对某个Model做增删改查业务的时候我们才继承这个控制器
 * 如果不是针对单个Model的业务接口，一般继承 {@link leap.web.api.mvc.ApiController}
 *
 */
@Path("/user")
public class UserModelController extends ModelController<UserModel> {
    /**
     * 使用 {@link QueryOptions}作为参数，可以得到强大的查询过滤功能，详细的功能请查阅官方文档{@docRoot https://leapframework.gitbooks.io/doc/content/}
     * @param options
     * @return
     */
    @GET("/query")
    public ApiResponse<List<UserModel>> queryUser(QueryOptions options){
        return queryList(options);
    }

    /**
     * 使用 {@link Partial}可以根据泛型类型自动计算模型的参数，并且根据模型的注解进行记录创建前的校验
     * @param partial
     * @return
     */
    @POST("/create")
    public ApiResponse<UserModel> createUser(Partial<UserModel> partial){
        return createAndReturn(partial);
    }

    /**
     * {@link PATCH}请求方法一般指增量修改，可以使用 {@link Partial}指定哪些属性会修改
     * @param id
     * @param partial
     * @return
     */
    @PATCH("/update/{id}")
    public ApiResponse updateUser(String id, Partial<UserModel> partial){
        return updatePartial(id,partial);
    }

    /**
     * 删除记录一般使用 {@link DELETE}请求方法，使用 {@link DeleteOptions}参数可以增强删除功能，目前只有级联删除一个选项，
     * 并且级联删除只能支持一级的关联
     * @param id
     * @param options
     * @return
     */
    @DELETE("/delete/{id}")
    public ApiResponse deleteUser(String id, DeleteOptions options){
        return delete(id,options);
    }
    
}
