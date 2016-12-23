package leap.example.datasource.model.datasource3;

import leap.orm.model.Model;

/**
 * Created by kael on 2016/12/23.
 * 
 * In this package, all of model are in datasource3
 * 
 */
public class Datasource3Model extends Model {
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
