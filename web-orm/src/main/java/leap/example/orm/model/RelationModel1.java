package leap.example.orm.model;

import leap.orm.annotation.Id;
import leap.orm.model.Model;

/**
 * Created by kael on 2016/12/26.
 */
public class RelationModel1 extends Model {
    @Id
    private String r1id;
    private String r1name;

    public String getR1id() {
        return r1id;
    }

    public void setR1id(String r1id) {
        this.r1id = r1id;
    }

    public String getR1name() {
        return r1name;
    }

    public void setR1name(String r1name) {
        this.r1name = r1name;
    }
}
