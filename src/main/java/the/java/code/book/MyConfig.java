package the.java.code.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * componentScan을 통해 Bean을 찾을 때,
 * {@link org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider} 를 사용한다.
 * 해당 클래스에서 {@link org.springframework.core.type.classreading.SimpleMetadataReader}를 사용하여 메타 정보를 읽어온다.
 * (ASM 사용)
 */
@Configuration
public class MyConfig {

  @Bean
  public String hello() {
    return "world";
  }

}
