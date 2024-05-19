package the.java.code.spring;

import org.junit.jupiter.api.Test;

/**
 * Spring을 사용하지 않은 Proxy 패턴
 */
class BookServiceTest {

  Bookservice bookservice = new BookServiceProxy(new DefaultBookService());

  @Test
  void di() {
    Book book = new Book();
    book.setId(1);
    book.setTitle("spring");
    bookservice.rent(book);
  }

}