package the.java.code.spring;

public class BookServiceClass implements Bookservice{

  BookRepository bookRepository;

  public BookServiceClass(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public void rent(Book book) {
    Book save = bookRepository.save(book);
    System.out.println("rent : " + save.getTitle());
  }

  @Override
  public void returnBook(Book book) {
    bookRepository.save(book);
    System.out.println("returnBook : " + book.getTitle());
  }
}
