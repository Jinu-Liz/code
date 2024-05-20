package the.java.code.lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

  /**
   * 어노테이션만 붙였는데 getter setter가 만들어진다.
   */
  @Test
  void getterSetter() {
    Member member = new Member();
    member.setName("jinuliz");

    assertEquals(member.getName(), "jinuliz");
  }
}