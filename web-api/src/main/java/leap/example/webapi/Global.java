package leap.example.webapi;

import leap.core.annotation.Inject;
import leap.oauth2.rs.OAuth2ResServerConfigurator;
import leap.web.App;
import leap.web.config.WebConfigurator;
import leap.web.security.SecurityConfigurator;
import leap.web.security.user.UserDetails;
import leap.web.security.user.UserStore;

/**
 * Created by kael on 2017/1/11.
 */
public class Global extends App {

    private @Inject OAuth2ResServerConfigurator rsc;
    private @Inject SecurityConfigurator sc;
    
    @Override
    protected void configure(WebConfigurator c) {
        // 设置启用oauth2资源服务器
        rsc.enable().useRemoteAuthorizationServer("http://localhost:8089/ssov3/oauth2/tokeninfo").useRsaJwtVerifier();
        // 设置启用身份校验
        sc.enable().authenticateAnyRequests().setUserStore(new UserStore() {
            
            private UserDetails ud = new UserDetails() {
                @Override
                public String getPassword() {
                    return "ISMvKXpXpadDiUoOSoAfww==";
                }

                @Override
                public String getName() {
                    return "test";
                }

                @Override
                public String getLoginName() {
                    return "admin";
                }

                @Override
                public Object getId() {
                    return "adminid";
                }
            };
            
            @Override
            public UserDetails loadUserDetailsById(Object userId) {
                return ud;
            }

            @Override
            public UserDetails loadUserDetailsByLoginName(String loginName) {
                if(ud.getLoginName().equals(loginName)){
                    return ud;
                }
                return null;
            }
        });
        super.configure(c);
    }
}
