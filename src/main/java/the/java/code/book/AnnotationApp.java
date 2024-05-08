package the.java.code.book;

import the.java.code.MyAnnotation;

import java.util.Arrays;

public class AnnotationApp {
  public static void main(String[] args) {
    Arrays.stream(Book.class.getDeclaredFields())
      .forEach(f -> {
        Arrays.stream(f.getAnnotations())
          .forEach(a -> {
            if (a instanceof MyAnnotation) {
              MyAnnotation myAnnotation = (MyAnnotation) a;
              System.out.println(myAnnotation.value());
              System.out.println(myAnnotation.number());
              System.out.println(myAnnotation.name());
            }
          });
      });
  }
}
