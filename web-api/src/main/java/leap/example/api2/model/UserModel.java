package leap.example.api2.model;

import leap.lang.meta.annotation.Creatable;
import leap.lang.meta.annotation.Filterable;
import leap.lang.meta.annotation.Sortable;
import leap.orm.annotation.Id;
import leap.orm.annotation.domain.CreatedAt;
import leap.orm.annotation.domain.UpdatedAt;
import leap.orm.model.Model;

import java.sql.Timestamp;

/**
 * Created by kael on 2017/1/12.
 */
public class UserModel extends Model {
    @Id
    private String id;
    /**
     * {@link Filterable}表示是否允许作为查询的过滤条件（where name = ?），默认是不允许的，需要允许的时候必须使用这个注解
     * <br/>
     * {@link Sortable}表示是否允许使用这个字段进行查询排序（order by name），默认是不允许的，需要允许的时候必须使用这个注解
     */
    @Sortable
    @Filterable
    private String name;
    @Filterable
    private int age;

    /**
     * {@link Creatable}表示是否允许在创建时指定
     * {@link CreatedAt}表示domain信息，这里不允许在创建时指定，会按照domain的规则指定这个字段的值
     */
    @Creatable(false)
    @CreatedAt
    private Timestamp createdAt;
    @Creatable(false)
    @UpdatedAt
    private Timestamp updatedAt;
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
