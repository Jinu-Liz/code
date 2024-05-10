package the.java.code.useful;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
    Class<?> bookClass = Class.forName("the.java.code.useful.Book");
    Constructor<?> constructor = bookClass.getConstructor(String.class);  // String을 파라미터로 하는 생성자
    Book book = (Book) constructor.newInstance("myBook");
    System.out.println(book);

    Field a = Book.class.getDeclaredField("A");
    System.out.println(a.get(null));
    a.set(null, "ABCD");
    System.out.println(a.get(null));

    Field b = Book.class.getDeclaredField("B");
    b.setAccessible(true);
    System.out.println(b.get(book));

    b.set(book, "DCBA");
    System.out.println(b.get(book));

    // private 메서드 실행 방법
    Method c = Book.class.getDeclaredMethod("c");
    c.setAccessible(true);
    c.invoke(book);

    // 파라미터가 있는 메서드 실행 방법
    Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
    int invoke = (int) sum.invoke(book, 1, 2);
    System.out.println(invoke);
  }
}
