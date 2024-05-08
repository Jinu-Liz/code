package the.java.code;

import java.lang.annotation.*;

/**
 * 어노테이션은 기본적으로 주석과 동일시 취급된다.
 * Retention을 사용해야 확인이 가능하다.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface AnotherAnnotation {

  /**
   * 기본값을 정해주면 어노테이션을 사용할 때, 값을 주지 않아도 상관 없다.
   * 반대로 기본값이 없으면 반드시 값을 주어야한다.
   */
  String name() default "jinuliz";

  int number() default 100;

  /**
   * value의 경우, value= 이라고 명시하지 않아도 된다.
   */
  String value() default "jinu";

}
