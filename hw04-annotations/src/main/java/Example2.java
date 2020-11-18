public class Example2 {

    @After
    public void after1() {
        System.out.println("Run method - after1");
    }

    @Before
    public void before1() {
        System.out.println("Run method - before1");
    }

    @Test
    public void test1() {
        System.out.println("Run method - test1");
    }

    @Test
    public void test2() {
        System.out.println("Run method - test2");
    }
    @Test
    public void test3() {
        System.out.println("Run method - test3");
    }

    public void test4() {
        System.out.println("Run method - test4");
    }

    public void before2() {
        System.out.println("Run method - before2");
    }

    public void after2() {
        System.out.println("Run method - before2");
    }

}
