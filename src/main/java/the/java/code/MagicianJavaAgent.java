package the.java.code;

public class MagicianJavaAgent {
  public static void main(String[] args) {

    /**
     * Moja.class 파일의 bytecode는 그대로 빈 값을 반환한다.
     *
     * VMOption 설정
     * -javaagent:C:\workSpace\masulsa-java-agent\target\masulsa-java-agent-1.0-SNAPSHOT.jar
     *
     * 클래스로더가 클래스를 읽어올 때, javaagent를 거쳐서 변경된 바이트코드를 읽어 사용하기 때문.
      */
    System.out.println(new Moja().pullOut());
  }
}
