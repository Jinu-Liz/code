package the.java.code.spring;

/**
 * Proxy 패턴으로 구현 시, 비슷한 기능을 하는 메서드가 늘어날 수 있다.
 * 이에, 클래스를 만드는 것이 아니라 동적으로 런타임에 생성해내는 다이나믹 프록시를 사용하게 된다.
 */
public class BookServiceProxy implements Bookservice {

  Bookservice bookservice;

  public BookServiceProxy(Bookservice bookservice) {
    this.bookservice = bookservice;
  }

  @Override
  public void rent(Book book) {
    System.out.println("Aaaaaaa");
    bookservice.rent(book);
    System.out.println("Bbbbbbb");
  }

  @Override
  public void returnBook(Book book) {
    System.out.println("Aaaaaaa");
    bookservice.rent(book);
    System.out.println("Bbbbbbb");
  }
}
