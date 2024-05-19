package the.java.code.spring;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceV4Test {

  /**
   * Mockito에서 Mock객체를 생성할 때
   * 프록시를 사용하여 생성한다.
   */
  @Test
  void di() {
    BookRepository repositoryMock = mock(BookRepository.class);
    Book hibernateBook = new Book();
    hibernateBook.setTitle("Hibernate");
    when(repositoryMock.save(any())).thenReturn(hibernateBook);

    BookServiceClass bookService = new BookServiceClass(repositoryMock);

    Book book = new Book();
    book.setId(1);
    book.setTitle("spring");
    bookService.rent(book);
    bookService.returnBook(book);
  }
}