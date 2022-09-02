package board.boardspring.service;

import board.boardspring.domain.Member;
import board.boardspring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void join(Member member){
        memberRepository.save(member);
    }

    public boolean validateDuplicate(String id) {
        return memberRepository.findById(id).isPresent();
    }

    public boolean checkIdForm(String id) {
        String pattern = "^[a-zA-Z0-9]{6,20}$";
        return Pattern.matches(pattern, id);
    }

    public boolean checkPasswordForm(String password) {
        String pattern = "^[a-zA-Z0-9!@#$%^&*]{6,20}$";
        return Pattern.matches(pattern, password);
    }
}
