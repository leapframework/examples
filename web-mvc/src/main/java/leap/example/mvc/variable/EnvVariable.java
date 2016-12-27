package leap.example.mvc.variable;

import leap.core.variable.Variable;

/**
 * Created by kael on 2016/12/27.
 */
public class EnvVariable implements Variable {
    /**
     * 作为环境变量，必须实现leap.core.variable.Variable接口，环境变量可以在整个应用的任何地方使用，包括sql，配置等。
     * 
     * leap内置了几个环境变量：
     * now：当前日期，java.util.Date类型
     * timestamp： 当前时间戳，java.sql.Timestamp类型
     * uuid：随机uuid， java.lang.String类型
     * user：当前用户(只有在需要登录并且用户已登录的情况下不为空)，leap.core.security.UserPrincipal类型
     * 
     * @return
     */
    @Override
    public Object getValue() {
        return "env-variable";
    }
}
