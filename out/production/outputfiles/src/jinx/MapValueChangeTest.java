package jinx;

import java.util.HashMap;
import java.util.Map;

/**
 * 更改map中独立对象查看map中值变化
 */
public class MapValueChangeTest {

    public static void main(String[] args){
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("key","value");
        data.put("key2",3);
        data.put("user",new User("name","pwd"));

        String value = data.get("key").toString();
        value = "valueChanged";
        User user = (User)data.get("user");
        user.setUserName("userName");

        System.out.println(data.get("key"));

        User user1 = (User)data.get("user");
        System.out.println(user1.getUserName());
    }

}
class User{
    private String userName;
    private String password;

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}