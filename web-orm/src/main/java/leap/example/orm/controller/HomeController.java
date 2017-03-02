package leap.example.orm.controller;

import leap.core.annotation.Transactional;
import leap.core.value.Record;
import leap.example.orm.model.*;
import leap.lang.value.Page;
import leap.orm.dao.Dao;
import leap.orm.mapping.EntityMapping;
import leap.web.action.ControllerBase;

import java.util.List;

/**
 * Created by kael on 2016/12/26.
 */
public class HomeController extends ControllerBase {
    /**
     * 增删改查
     * @return
     */
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

    /**
     * 查询功能
     * @return
     */
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

    /**
     * 使用关系做join查询
     * @return
     */
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

    /**
     * 查询额外字段
     * @return
     */
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

    /**
     * 动态sql，部分sql写在conf/sqls.xml中
     * @return
     */
    public String dynamic(){
        Model1.deleteAll();
        Model1 model1 = new Model1();
        model1.setId("testId");
        model1.setName("model1Name");
        model1.create();
        
        // use dynamic
        List<Model1> model1s = Model1.<Model1>query("dynamic.sql1").param("name","model1Name").list();
        System.out.println(model1s.size());
        
        // use @if
        model1s = Model1.<Model1>query("dynamic.sql2").list();
        System.out.println(model1s.size());
        model1s = Model1.<Model1>query("dynamic.sql2").param("name","123").list();
        System.out.println(model1s.size());
        model1s = Model1.<Model1>query("dynamic.sql2").param("name","model1Name").list();
        System.out.println(model1s.size());
        
        // use @include fragment
        model1s = Model1.<Model1>query("dynamic.sql3").param("name","model1Name").list();
        System.out.println(model1s.size());
        
        // use sql query
        Model1.<Model1>query("select * from t_model1 where 1=1 {?AND name=:name} {?AND name=#name#} {?AND name='$name$'}")
                .param("name","model1Name").list();
        System.out.println(model1s.size());
        Model1.<Model1>query("select * from t_model1 where 1=1" +
                "        @if(name == null)" +
                "            AND name is null" +
                "        @elseif(name.equals(\"123\"))" +
                "            AND name = '123'" +
                "        @else" +
                "            AND name=:name" +
                "        @endif").param("name","model1Name").list();
        System.out.println(model1s.size());
        model1s = Model1.<Model1>query("select * from t_model1 where 1=1 @include(dynamic.fragment)").param("name","model1Name").list();
        System.out.println(model1s.size());
        
        return "ok";
    }

    /**
     * 不继承Model类的orm对象
     * @return
     */
    public String noExtendEntity(){
        
        Dao dao = Dao.get();
        EntityMapping em = dao.getOrmContext().getMetadata().getEntityMapping(NoExtendEntity.class);
        
        dao.deleteAll(NoExtendEntity.class);
        
        NoExtendEntity entity1 = new NoExtendEntity();
        entity1.setName("NoExtendEntity1");
        NoExtendEntity entity2 = new NoExtendEntity();
        entity2.setName("NoExtendEntity2");
        dao.cmdInsert(NoExtendEntity.class).setAll(entity1).execute();
        dao.cmdInsert(em).setAll(entity2).execute();
        
        List<NoExtendEntity> entities = dao.createCriteriaQuery(NoExtendEntity.class).where("name = ?", entity1.getName()).list();
        System.out.println(entities.size());
        return "ok";
    }

    /**
     * 多租户数据隔离
     * @return
     */
    public String multiTenant(){

        MultiTenantModel1 m1a = new MultiTenantModel1();
        MultiTenantModel1 m1b = new MultiTenantModel1();
        
        m1a.setName("m1a");
        m1a.setId("m1a");
        m1a.create();
        
        m1b.setName("m1b");
        m1b.setId("m1b");
        m1b.setTenantId("m1_2");
        m1b.create();

        /*
        * 
        * 这里的tenant_id参数值是从环境变量tenant中获取的，这个环境变量的值在leap.example.orm.MultiTenantVariable中定义了。
        * 这样就可以实现全局的多租户数据隔离，不需要自己写where
        * 
        * SQL  : select t.* from multi_tenant_model1 t where 1=1  and t.tenant_id = ? 
        * ARGS : ['m1_1']
        * 
        * */
        List<MultiTenantModel1> m1s = MultiTenantModel1.all();
        System.out.println(m1s.size());
        return "ok";
    }
}
