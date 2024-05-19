package the.java.code.spring;

import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
public class Book {

  @GeneratedValue
  @Id
  private Integer id;

  private String title;

  /**
   * 프록시 객체를 사용하여, 우선 객체를 생성한 후
   * 실제로 Entity가 사용되는 시점에 실제 객체를 참조하여
   * 쿼리를 날리게 된다.
   */
  @OneToMany(fetch = LAZY)
  private List<Note> notes;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
