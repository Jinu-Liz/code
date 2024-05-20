package the.java.code.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Lombok의 원리
 * AST(Abstract Syntax Tree)를 원래는 참조만 할 수 있는데
 * Lombok의 경우, 이를 수정가능한 하위 타입으로 캐스팅하여 수정하는 방법을 사용.
 * 이는 공개 API를 사용한 방법이 아니므로, 해킹으로 보는 시각도 존재한다.
 */
@EqualsAndHashCode
@ToString
@Getter @Setter
public class Member {

  private String name;

  private int age;

}
