package learn4;

public class Private {
    private String edu = "zhangsan";

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    @SuppressWarnings("unused")
    private String sayHello(String name) {
        return "Hello:" + name;
    }
}

class Private1 extends Private {

}