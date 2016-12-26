package leap.example.orm.model;

import leap.orm.annotation.Column;
import leap.orm.annotation.Id;
import leap.orm.annotation.Table;
import leap.orm.model.Model;

/**
 * Created by kael on 2016/12/26.
 */
@Table("t_model1")
public class Model1 extends Model {
    @Id
    @Column("id")
    private String id;
    @Column("name")
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
