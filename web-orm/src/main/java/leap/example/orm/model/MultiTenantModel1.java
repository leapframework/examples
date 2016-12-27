package leap.example.orm.model;

import leap.orm.model.Model;

/**
 * Created by kael on 2016/12/27.
 */
public class MultiTenantModel1 extends Model {
    private String id;
    private String name;
    private String tenantId;

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

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
