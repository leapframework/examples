package leap.example.orm.model;

import leap.orm.annotation.Id;
import leap.orm.annotation.ManyToOne;
import leap.orm.model.Model;

/**
 * Created by kael on 2016/12/26.
 */
public class RelationModel2 extends Model {
    @Id
    private String id;
    private String name;
    @ManyToOne(target = RelationModel1.class)
    private String relationTo;

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

    public String getRelationTo() {
        return relationTo;
    }

    public void setRelationTo(String relationTo) {
        this.relationTo = relationTo;
    }
}
