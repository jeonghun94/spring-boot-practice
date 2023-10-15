package hello.firstspring;

import hello.firstspring.repository.JdbcTemplateMemberRepository;
// import hello.firstspring.repository.MemoryMemberRepository;
// import hello.firstspring.repository.JdbcMemberRepository;
import hello.firstspring.repository.JpaMemberRepository;
import hello.firstspring.repository.MemberRepository;
import hello.firstspring.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private DataSource dataSource;
  private EntityManager em;

  public SpringConfig(DataSource dataSource, EntityManager em) {
    this.dataSource = dataSource;
    this.em = em;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    // return new MemoryMemberRepository();
    // return new JdbcMemberRepository(dataSource);
    // return new JdbcTemplateMemberRepository(dataSource);
    return new JpaMemberRepository(em);
  }
}
