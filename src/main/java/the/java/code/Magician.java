package the.java.code;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Magician {
  public static void main(String[] args) {
    try {
      new ByteBuddy().redefine(Moja.class)
        .method(named("pullOut"))
        .intercept(FixedValue.value("Rabbit!"))
        .make()
        .saveIn(new File("C:\\workSpace\\code\\build\\classes\\java\\main\\"));

    } catch (IOException e) {
      e.printStackTrace();
    }

//    System.out.println(new Moja().pullOut());
  }
}
