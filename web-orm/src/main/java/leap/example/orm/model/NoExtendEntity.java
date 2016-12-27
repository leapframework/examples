package leap.example.orm.model;

import leap.orm.annotation.Entity;
import leap.orm.annotation.Id;

/**
 * Created by kael on 2016/12/27.
 * 
 * model类也可以不继承Model，用{@link Entity}注解
 * 
 */
@Entity(table = "no_extend_model")
public class NoExtendEntity {
    @Id
    private String id;
    
    private String name;

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
}
