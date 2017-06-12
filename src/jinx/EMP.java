package jinx;

/**
 * Created by jinx on 6/12/17.
 */
public class EMP {

    private Integer ID;
    private String Name;
    private String Sex;
    private Integer Age;
    private String Mahor;


    public EMP(Integer ID,String Name,String Sex,String Mahor,Integer Age){
        this.ID = ID;
        this.Name = Name;
        this.Sex = Sex;
        this.Mahor = Mahor;
        this.Age = Age;
    }


    private void PrintEMP(){
        System.out.print("雇员编号:"+this.ID+";雇员名:"+this.Name+";年龄:"+this.Age+";性别:"+this.Sex+";专业:"+this.Mahor);
    }

    public static void main(String[] args){
        EMP emp = new EMP(5,"王强","男","计算机网络",23);
        emp.PrintEMP();
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getMahor() {
        return Mahor;
    }

    public void setMahor(String mahor) {
        Mahor = mahor;
    }
}
