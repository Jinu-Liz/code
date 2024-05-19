package the.java.code.spring;

public class DefaultBookService implements Bookservice{

  public void rent(Book book) {
    System.out.println("rent : " + book.getTitle());
  }

  @Override
  public void returnBook(Book book) {
    System.out.println("returnBook : " + book.getTitle());
  }
}
