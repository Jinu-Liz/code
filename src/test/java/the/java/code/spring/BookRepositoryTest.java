package the.java.code.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

  @Autowired BookRepository bookRepository;

  /**
   * BookRepository는 인터페이스인데 인스턴스가 생성됨.
   */
  @Test
  void di() {
    assertNotNull(bookRepository);
  }
}