package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)   // Interface, Class, Enum 에 사용할 수 있다.
@Retention(RetentionPolicy.SOURCE)
public @interface Magic {
}
