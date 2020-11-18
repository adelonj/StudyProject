import org.junit.Assert;

public class Example1 {


    @Before
    public void before1() {
        System.out.println("Invoke method - before1");
        //throw new RuntimeException("I failed here!");
    }

    @Test
    public void test1() {
        System.out.println("Invoke method - test1");
    }

    @Test
    public void test2() {
        System.out.println("Invoke method - test2");
        //throw new RuntimeException("I failed here!");
    }

    @Test
    public void test3() {
        System.out.println("Invoke method - test3");
        throw new RuntimeException("I failed here!");
    }

    public void test4() {
        System.out.println("Invoke method - test4");
    }

    public void before2() {
        System.out.println("Invoke method - before2");
    }

    @After
    public void after1() {
        System.out.println("Invoke method - after1");
         throw new RuntimeException("I failed here!");
    }

    @After
    public void after2() {
        System.out.println("Invoke method - after2");
    }



}
