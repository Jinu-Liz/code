package the.java.code.book;

public class Book {

  private String title;

  private static String type = "BOOK";

  private static final String STATIC_TYPE = "BOOK TYPE";

  public String pubVal = "d";

  protected String proVal = "e";

  public Book() {
  }

  public Book(String title, String pubVal, String proVal) {
    this.title = title;
    this.pubVal = pubVal;
    this.proVal = proVal;
  }

  private void prvMethod() {
    System.out.println("F");
  }

  public void pubMethod() {
    System.out.println("G");
  }

  public int pubInt() {
    return 100;
  }
}
