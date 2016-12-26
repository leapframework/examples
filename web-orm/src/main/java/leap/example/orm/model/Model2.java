package leap.example.orm.model;

import leap.orm.annotation.Id;
import leap.orm.model.Model;

/**
 * Created by kael on 2016/12/26.
 */
// default table name model2_
public class Model2 extends Model {
    @Id
    // default column name id_
    private String id;
    // default column name name_
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
