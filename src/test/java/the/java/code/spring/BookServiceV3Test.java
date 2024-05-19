package the.java.code.spring;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 클래스 기반의 프록시 생성 방법
 * 
 * 1. 그러나 상속이 제한된 클래스에는 사용할 수 없고, (ex: final이 붙은 클래스)
 * 2. private 생성자만 있는 클래스에는 사용할 수 없다.
 */
class BookServiceV3Test {

  /**
   * CGLIB을 사용하여 클래스 기반의 프록시를 생성할 수 있다.
   */
  @Test
  void classProxy() {
    MethodInterceptor handler = new MethodInterceptor() {
      DefaultBookService bookservice = new DefaultBookService();

      @Override
      public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.getName().equals("rent")) {
          System.out.println("aaaa");
          Object invoke = method.invoke(bookservice, args);
          System.out.println("bbbb");
          return invoke;
        }

        return method.invoke(bookservice, args);
      }
    };

    DefaultBookService bookService = (DefaultBookService) Enhancer.create(DefaultBookService.class, handler);

    Book book = new Book();
    book.setId(1);
    book.setTitle("spring");
    bookService.rent(book);
    bookService.returnBook(book);
  }

  /**
   * ByteBuddy를 사용한 프록시 생성 방법.
   */
  @Test
  void byteBuddyProxy() throws Exception {
    Class<? extends DefaultBookService> proxyClass = new ByteBuddy().subclass(DefaultBookService.class)
      .method(ElementMatchers.named("rent"))
      .intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
        DefaultBookService bookservice = new DefaultBookService();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          if (method.getName().equals("rent")) {
            System.out.println("aaaa");
            Object invoke = method.invoke(bookservice, args);
            System.out.println("bbbb");
            return invoke;
          }

          return method.invoke(bookservice, args);
        }
      }))
      .make()
      .load(DefaultBookService.class.getClassLoader())
      .getLoaded();

    DefaultBookService bookService = proxyClass.getConstructor(null).newInstance();

    Book book = new Book();
    book.setId(1);
    book.setTitle("spring");
    bookService.rent(book);
    bookService.returnBook(book);
  }
}