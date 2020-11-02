

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RunMe {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        run(Example1.class);
        run(Example2.class);
    }

    private static void run(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
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

        int skippedTestsCount = 0;
        int failedTestsCount = 0;

        for (Method method : testMethods) {
            Object object = constructor.newInstance();
            boolean beforeResult = true;

            for (Method m : beforeMethods) {
                try {
                    m.invoke(object);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    skippedTestsCount += 1;
                    beforeResult = false;
                }
            }
            if (beforeResult) {
                try {
                    method.invoke(object);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    failedTestsCount += 1;
                }
            }
            for (Method m : afterMethods)
                try {
                    m.invoke(object);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
        }

        System.out.println("---------------------------------------");
        System.out.println("Statistics for run " + clazz.getName());
        int successTestsCount = testMethods.size() - failedTestsCount - skippedTestsCount;
        System.out.println("Skipped tests: " + skippedTestsCount);
        System.out.println("Failed tests: " + failedTestsCount);
        System.out.println("Success tests: " + successTestsCount);
        System.out.println("All tests: " + (successTestsCount + failedTestsCount + skippedTestsCount));
        System.out.println("---------------------------------------");

    }

}
