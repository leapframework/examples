package leap.example.datasource.model;

import leap.orm.annotation.DataSource;
import leap.orm.model.Model;

/**
 * Created by kael on 2016/12/23.
 */
@DataSource("datasource1")
public class Datasource1Model extends Model {
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
