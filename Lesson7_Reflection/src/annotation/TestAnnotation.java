package annotation;

import java.lang.reflect.Method;

@MarketingAnnotation(type = "Type")
public class TestAnnotation {

    @MarketingAnnotation
    private String title;

    @MarketingAnnotation(type = "Type")
    public void markedMethod() {
        System.out.println("Hello, World!");
    }

    public void unmarkedMethod() {
        System.out.println("Goodbye, World!");
    }

    public static void main(@MarketingAnnotation String[] args) throws Exception {
        TestAnnotation test = new TestAnnotation();

        for (Method method : test.getClass().getDeclaredMethods()) {
            MarketingAnnotation annotation = method.getAnnotation(MarketingAnnotation.class);
            if (annotation != null) {
                method.invoke(test);
                System.out.println("Annotation value is " + annotation.value());
                System.out.println("Annotation type is " + annotation.type());
            }
        }

    }
}
