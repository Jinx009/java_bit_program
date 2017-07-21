package jinx.json.compare;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jinx on 7/17/17.
 */
public class JsonTest {

    public static void main(String[] args) throws Exception {

        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 100; i++) {
            Date date = new Date();
            map.put(date.toLocaleString() + i, date.toLocaleString());
        }
        long startTimestamp = System.currentTimeMillis();
        Gson gson = new Gson();
        gson.toJson(map);
        System.out.println("gson 消耗:" + (System.currentTimeMillis() - startTimestamp));
        long startTimestamp2 = System.currentTimeMillis();
        JSON.toJSONString(map);
        System.out.println("fastjson 1消耗:" + (System.currentTimeMillis() - startTimestamp2));
        long startTimestamp3 = System.currentTimeMillis();
        JSONObject.toJSONString(map);
        System.out.println("fastjson 2消耗:" + (System.currentTimeMillis() - startTimestamp3));
        long startTimestamp4 = System.currentTimeMillis();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(map);
        System.out.println("jackson 消耗:" + (System.currentTimeMillis() - startTimestamp4));
    }

}
