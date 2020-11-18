import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Executor {

    public void run(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();

        List<Method> beforeMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();

        for (Method method : clazz.getMethods()) {
            if (method.isAnnotationPresent(Before.class)) {
                beforeMethods.add(method);
            }
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
            if (method.isAnnotationPresent(After.class)) {
                afterMethods.add(method);
            }
        }

        int skipped = 0;
        int failed = 0;

        for (Method method : testMethods) {
            Object object = constructor.newInstance();
            boolean beforeResult = true;

            for (Method m : beforeMethods) {
                try {
                    m.invoke(object);
                } catch (Exception e) {
                    System.err.println("@Before |  method [" + m.getName() + "] failed with error : " + e.getCause());
                    skipped += 1;
                    beforeResult = false;
                }
            }
            if (beforeResult) {
                try {
                    method.invoke(object);
                } catch (Exception e) {
                    System.err.println("@Test |  method [" + method.getName() + "] failed with error : " + e.getCause());
                    failed += 1;
                }
            }
            for (Method m : afterMethods)
                try {
                    m.invoke(object);
                } catch (Exception e) {
                    System.err.println("@After | method [" + m.getName() + "] failed with error : " + e.getCause());
                }
        }

        int success = testMethods.size() - failed - skipped;

        System.out.println("---------------------------------------");
        System.out.println("Statistics for run " + clazz.getName());
        System.out.println("Skipped tests: " + skipped);
        System.out.println("Failed tests: " + failed);
        System.out.println("Success tests: " + success);
        System.out.println("All tests: " + (success + failed + skipped));
        System.out.println("---------------------------------------");

    }
}
