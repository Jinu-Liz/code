package the.java.code.spring;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Spring을 사용하지 않은 Proxy 패턴
 */
class BookServiceV2Test {

  Bookservice bookservice = (Bookservice) Proxy.newProxyInstance(
    Bookservice.class.getClassLoader(),
    new Class[]{Bookservice.class},
    new InvocationHandler() {
      Bookservice bookservice = new DefaultBookService();

      /**
       * 코드가 유연하지 못하고, 해당 Proxy를 감싸는 Proxy를 또 만들어야 할 수도 있음.
       */
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("rent")) {
          System.out.println("AAA");
          Object invoke = method.invoke(bookservice, args);
          System.out.println("BBB");

          return invoke;
        }

        return method.invoke(bookservice, args);
      }
    }
  );

  /**
   * Java의 Proxy가 클래스 기반의 프록시를 만들 수 없기 때문에
   * 인터페이스가 아닌 클래스 타입을 사용할 수 없다.
   */
  DefaultBookService defaultBookService = (DefaultBookService) Proxy.newProxyInstance(
    DefaultBookService.class.getClassLoader(),
    new Class[]{DefaultBookService.class},
    new InvocationHandler() {
      DefaultBookService bookservice = new DefaultBookService();

      /**
       * 코드가 유연하지 못하고, 해당 Proxy를 감싸는 Proxy를 또 만들어야 할 수도 있음.
       */
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("rent")) {
          System.out.println("AAA");
          Object invoke = method.invoke(bookservice, args);
          System.out.println("BBB");

          return invoke;
        }

        return method.invoke(bookservice, args);
      }
    }
  );

  @Test
  void di() {
    Book book = new Book();
    book.setId(1);
    book.setTitle("spring");
    bookservice.rent(book);
    bookservice.returnBook(book);
  }

  /**
   * 클래스 기반의 프록시이기 때문에 테스트 실패.
   */
  @Test
  void classDi() {
    Book book = new Book();
    book.setId(1);
    book.setTitle("spring");
    defaultBookService.rent(book);
    defaultBookService.returnBook(book);
  }
}