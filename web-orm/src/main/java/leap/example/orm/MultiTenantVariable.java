package leap.example.orm;

import leap.core.annotation.Bean;
import leap.core.variable.Variable;

/**
 * Created by kael on 2016/12/27.
 */
@Bean(name = "tenant", type = Variable.class)
public class MultiTenantVariable implements Variable {
    
    @Override
    public Object getValue() {
        return "m1_1";
    }
}
