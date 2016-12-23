package leap.example.datasource;

import leap.example.datasource.model.Datasource1Model;
import leap.example.datasource.model.Datasource2Model;
import leap.example.datasource.model.DatasourceDefaultModel;
import leap.example.datasource.model.datasource3.Datasource3Model;
import leap.lang.logging.Log;
import leap.lang.logging.LogFactory;
import leap.web.App;

/**
 * Created by kael on 2016/12/23.
 */
public class Global extends App{
    
    private static final Log log = LogFactory.get(Global.class);
    
    @Override
    protected void init() throws Throwable {
        log.info("web app init...");

        Datasource1Model d1 = new Datasource1Model();
        d1.setId("d1");
        d1.setName("d1");
        d1.create();
        Datasource2Model d2 = new Datasource2Model();
        d2.setId("d2");
        d2.setName("d2");
        d2.create();
        Datasource3Model d3 = new Datasource3Model();
        d3.setId("d2");
        d3.setName("d2");
        d3.create();
        DatasourceDefaultModel dd = new DatasourceDefaultModel();
        dd.setId("dd");
        dd.setName("dd");
        dd.create();
        
        log.info("Datasource1Model db name : " + Datasource1Model.db().getName());
        log.info("Datasource2Model db name : " + Datasource2Model.db().getName());
        log.info("Datasource3Model db name : " + Datasource3Model.db().getName());
        log.info("DatasourceDefaultModel db name : " + DatasourceDefaultModel.db().getName());
        
        
    }
}
