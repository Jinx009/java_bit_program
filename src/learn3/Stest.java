package learn3;

import static learn4.StaticTest.AGE;
import static learn4.StaticTest.outPut;


public class Stest {
    public static void main(String[] args) throws Exception {

        System.out.println(AGE);

        outPut();

//			Class<?> classType = Class.forName(args[0]);
//			
//			Method[] method = classType.getMethods();
//			
//			for(Method m:method)
//			{
//				System.out.println(m+"::"+m.getName());
//			}

        Class<?> classType = Stest.class;

        Object instan = classType.newInstance();

        System.out.println(instan instanceof Stest);

        Stest s = new Stest();

        System.out.println(s.getClass() instanceof Class);

        System.out.println();
    }
}
