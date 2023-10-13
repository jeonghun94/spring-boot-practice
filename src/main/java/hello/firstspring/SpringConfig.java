package hello.firstspring;

import hello.firstspring.repository.JdbcMemberRepository;
import hello.firstspring.repository.MemberRepository;
// import hello.firstspring.repository.MemoryMemberRepository;
import hello.firstspring.service.MemberService;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private DataSource dataSource;

  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    // return new MemoryMemberRepository();
    return new JdbcMemberRepository(dataSource);
  }
}
