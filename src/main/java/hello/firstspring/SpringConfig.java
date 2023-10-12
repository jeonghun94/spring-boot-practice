package hello.firstspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.firstspring.repository.MemberRepository;
import hello.firstspring.repository.MemoryMemberRepository;
import hello.firstspring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
