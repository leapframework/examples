package leap.example.mvc.function;

import leap.lang.Strings;

/**
 * Created by kael on 2016/12/27.
 */
public class Function {
    /**
     * 作为静态函数，必须是public和static的函数
     * 静态函数可以在视图中使用
     * 
     * leap目前内置了几个静态函数
     * classes:isPresent -> leap.lang.Classes.isPresent(java.lang.String)
     * 
     * json:decode -> leap.lang.json.JSON.decode(java.lang.String)
     * json:encode -> leap.lang.json.JSON.encode(java.lang.Object)
     * json:parse -> leap.lang.json.JSON.parse(java.lang.String)
     * json:stringify -> leap.lang.json.JSON.stringify(java.lang.Object)
     * 
     * arrays:contains -> leap.core.el.function.ArrayFuncs.contains(java.lang.Object,java.lang.Object)
     * 
     * times:fmt -> leap.core.el.function.TimeFuncs.format(java.lang.Object,java.lang.String)
     * times:hour -> leap.core.el.function.TimeFuncs.hour(java.lang.Object)
     * 
     * @param url
     * @return
     */
    public static String function(String url){
        if(Strings.isEmpty(url)){
            return "empty";
        }else{
            return "no empty";
        }
    }
}
