package the.java.code.book;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {
  public static void main(String[] args) throws ClassNotFoundException {
    // 타입을 통한 접근
    Class<Book> bookClass = Book.class;

    // 인스턴스를 통한 접근
    Book book = new Book();
    Class<? extends Book> aClass = book.getClass();

    // 문자열 경로를 통한 접근
    Class<?> aClass1 = Class.forName("the.java.code.book.Book");


    // getFields는 public한 필드만 가져온다.
    Arrays.stream(bookClass.getFields())
      .forEach(System.out::println);

    System.out.println("---------------------------------------");

    // 모든 필드를 가져오려면 getDeclaredFields를 사용
    Arrays.stream(bookClass.getDeclaredFields())
      .forEach(System.out::println);

    System.out.println("---------------------------------------");

    Arrays.stream(bookClass.getDeclaredFields())
      .forEach(f -> {
        try {
          // private 변수에는 접근할 수 없기 때문에 접근 가능하도록 변경해준다.
          f.setAccessible(true);
          System.out.printf("%s %s\n", f, f.get(book));
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      });

    System.out.println("---------------------------------------");

    // 메서드 가져오기
    Arrays.stream(bookClass.getMethods())
      .forEach(System.out::println);

    System.out.println("---------------------------------------");

    // 생성자 가져오기
    Arrays.stream(bookClass.getConstructors())
      .forEach(System.out::println);

    System.out.println("---------------------------------------");

    // 부모 클래스 가져오기
    System.out.println(MyBook.class.getSuperclass());

    System.out.println("---------------------------------------");

    // 인터페이스 가져오기
    Arrays.stream(MyBook.class.getInterfaces())
      .forEach(System.out::println);

    System.out.println("---------------------------------------");

    // 그 외 여러 정보를 알 수 있다.
    Arrays.stream(bookClass.getDeclaredFields())
      .forEach(f -> {
        int modifiers = f.getModifiers();
        System.out.println(f);
        System.out.println(Modifier.isPrivate(modifiers));  // private 여부
        System.out.println(Modifier.isStatic(modifiers));   // static 여부
      });
  }
}
