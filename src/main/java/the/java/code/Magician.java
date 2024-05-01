package the.java.code;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Magician {
  public static void main(String[] args) {
    ClassLoader classLoader = Magician.class.getClassLoader();
    TypePool typePool = TypePool.Default.of(classLoader);
    try {
      new ByteBuddy().redefine(
        typePool.describe("the.java.code.Moja").resolve(),
          ClassFileLocator.ForClassLoader.of(classLoader)
        )
        .method(named("pullOut"))
        .intercept(FixedValue.value("Rabbit!"))
        .make()
        .saveIn(new File("C:\\workSpace\\code\\build\\classes\\java\\main\\"));

    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(new Moja().pullOut());
  }
}
