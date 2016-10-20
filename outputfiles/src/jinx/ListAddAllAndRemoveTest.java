package jinx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinx on 10/13/16.
 */
public class ListAddAllAndRemoveTest {

    public static void main(String[] args){
        List<TestModel> list = new ArrayList<TestModel>();
        List<TestModel> list2 = new ArrayList<TestModel>();
        List<TestModel> list3 = new ArrayList<TestModel>();
        List<TestModel> list4 = new ArrayList<TestModel>();
        List<TestModel> list5 = new ArrayList<TestModel>();

        TestModel testModel2 = new TestModel("21","11");
        TestModel testModel3 = new TestModel("31","11");
        TestModel testModel4 = new TestModel("41","11");
        TestModel testModel5 = new TestModel("51","11");

        list2.add(testModel2);
        list3.add(testModel3);
        list4.add(testModel4);
        list5.add(testModel5);

        list.addAll(list2);
        list.addAll(list3);
        list.addAll(list5);
        list.addAll(list4);

        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).getUserName());
        }
    }

}
class TestModel{

    private String userName;
    private String password;

    public TestModel(String userName,String password){
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
