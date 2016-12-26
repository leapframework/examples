package leap.example.orm.controller;

import leap.core.value.Record;
import leap.example.orm.model.Model1;
import leap.example.orm.model.RelationModel1;
import leap.example.orm.model.RelationModel2;
import leap.orm.dao.Dao;
import leap.web.action.ControllerBase;

import java.util.List;

/**
 * Created by kael on 2016/12/26.
 */
public class HomeController extends ControllerBase {
    public String crud(){
        Model1 model1 = new Model1();
        model1.setId("testId");
        model1.setName("testName");
        
        Model1 model2 = new Model1();
        model2.setName("model2Name");
        
        // insert into database
        model1.create();
        
        // update
        model1.setName("updateName");
        model1.update();
        
        // insert or update
        // insert
        model2.save();
        // update
        model2.save();
        
        // delete
        model1.delete();
        model1.create();
        Model1.delete(model1.getId());
        return "ok";
    }
    
    public String query(){
        Model1 model1 = new Model1();
        model1.setId("testId");
        model1.setName("testName");
        model1.create();
        
        
        model1 = Model1.find("testId");
        //query all
        List<Model1> list = Model1.all();
        System.out.println(list.size());
        // select * from t_model1 where name = 'testName'
        
        list = Model1.<Model1>where("name = ?","testName").list();
        System.out.println(list.size());
        list = Model1.<Model1>query("select * from t_model1 where name = :name").param("name","testName").list();
        System.out.println(list.size());
        // sql key,see conf/sqls.xml
        list = Model1.<Model1>query("select-model1").param("name","testName").list();
        System.out.println(list.size());
        List<Record> records = Dao.get().createNamedQuery("select-model1").param("name","testName").list();
        Object name = records.get(0).get("name");// name value is testName
        System.out.println(name);
        
        return "ok";
    }
    
    public String relation(){
        RelationModel1 r1 = new RelationModel1();
        r1.setR1id("r1Id");
        r1.setR1name("r1Name");
        r1.create();
        RelationModel2 r2 = new RelationModel2();
        r2.setId("r2Id");
        r2.setName("r2Name");
        r2.setRelationTo(r1.getR1id());
        r2.create();
        
        List<RelationModel2> list = RelationModel2.<RelationModel2>where("id = ? AND r1.r1name = ?", 
                r2.getId(), r1.getR1name()).join(RelationModel1.class, "r1").list();
        System.out.println(list.get(0).getRelationTo());
        
        return "ok";
    }
    
    public String extendField(){
        RelationModel1 r1 = new RelationModel1();
        r1.setR1id("r1Id");
        r1.setR1name("r1Name");
        r1.create();
        RelationModel2 r2 = new RelationModel2();
        r2.setId("r2Id");
        r2.setName("r2Name");
        r2.setRelationTo(r1.getR1id());
        r2.create();

        List<RelationModel2> list = RelationModel2.<RelationModel2>query("select * from relation_model2 t join relation_model1 r1 on t.relation_to=r1.r1id where id = :id AND r1.r1name = :r1name")
                .param("id",r2.getId()).param("r1name",r1.getR1name()).list();
        System.out.println(list.get(0).get("r1name"));
        
        return "ok";
    }
    
    
    
    
}
