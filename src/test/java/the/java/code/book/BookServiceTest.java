package the.java.code.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

  @Autowired BookService bookService;

  @Test
  void di() {
    /**
     * new로 생성하지 않았지만, null이 아니다.
     */
    assertNotNull(bookService);
    assertNotNull(bookService.bookRepository);
  }
}