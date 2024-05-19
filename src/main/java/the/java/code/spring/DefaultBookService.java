package the.java.code.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class DefaultBookService implements Bookservice{

  public void rent(Book book) {
    System.out.println("rent : " + book.getTitle());
  }
}
