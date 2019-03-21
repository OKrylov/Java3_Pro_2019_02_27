import java.lang.reflect.*;
import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) throws Exception {
//        testClass();
        testCat();
    }

    private static void testCat() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        ICat cat = new Cat("Baarsik", "black", 4);
        Class<? extends ICat> clazz = cat.getClass();

        System.out.println("Interfaces:");
        for (Class<?> anInterface : clazz.getInterfaces()) {
            System.out.println("Is interface: " + anInterface.isInterface());
            System.out.println(anInterface.getSimpleName());
        }
        System.out.println();

        System.out.println("Superclasses:");
        Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            System.out.println(superclass.getSimpleName());
            System.out.println("Superclass is abstract: " + Modifier.isAbstract(superclass.getModifiers()));
        }
        System.out.println();

        System.out.println("Fields");

        for (Field declaredField : clazz.getDeclaredFields()) {
            declaredField.setAccessible(true);
            System.out.println(String.format("Type '%s' for field '%s'; value = %s",
                    declaredField.getType().getSimpleName(),
                    declaredField.getName(),
                    declaredField.get(cat)));
        }

//        changeAge(cat, clazz);

        changeCatty(cat, clazz);

        System.out.println();
        System.out.println("Methods");

        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println(getPublicOrPrivate(declaredMethod) + " "
                    + declaredMethod.getReturnType() + " "
                    + declaredMethod.getName() + " "
                    + Arrays.toString(declaredMethod.getParameterTypes()));

        }

        Method jumpMethod = clazz.getDeclaredMethod("jump");
        jumpMethod.setAccessible(true);
        jumpMethod.invoke(cat);//cat.jump();

        Method meowMethod = clazz.getMethod("meow", int.class);
        meowMethod.invoke(cat, 60);//cat.meow(60)


        System.out.println();
        System.out.println("Constructors");

        for (Constructor<?> declaredConstructor : clazz.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }

        Constructor<? extends ICat> constructor = clazz.getDeclaredConstructor(String.class, String.class, int.class);
        ICat cat2 = constructor.newInstance("Markiz", "Yellow", 2);
        System.out.println(cat2);
    }

    private static String getPublicOrPrivate(Method declaredMethod) {
        if (Modifier.isPublic(declaredMethod.getModifiers())) {
            return "Public";
        }

        return "Private";
    }

    private static void changeCatty(ICat cat, Class<? extends ICat> clazz) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(cat);

        Field cattyField = clazz.getDeclaredField("catty");
        cattyField.setAccessible(true);
        System.out.println("catty is " + cattyField.get(cat));


        cattyField.set(cat, false);
        System.out.println(cat);

        //Change static
    }

    private static void changeAge(ICat cat, Class<? extends ICat> clazz) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(cat);

        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(cat, 7);

        System.out.println(cat);
    }


    private static void testClass() throws ClassNotFoundException {
        String str = "Java";
        Class<? extends String> clazz = str.getClass();

        System.out.println("Full Name: " + clazz.getName());
        System.out.println("Short Name: " + clazz.getSimpleName());

        int modifiers = clazz.getModifiers();
        if ( Modifier.isPublic(modifiers) ) {
            System.out.println("String is public");
        }
        if ( Modifier.isFinal(modifiers) ) {
            System.out.println("String is final");
        }
        if ( Modifier.isAbstract(modifiers) ) {
            System.out.println("String is abstract");
        }





    }
}
