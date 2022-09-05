package board.boardspring.service;

import board.boardspring.domain.Member;
import board.boardspring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void join(Member member){
        memberRepository.save(member);
    }

    // 아이디 중복 체크

    public boolean validateDuplicate(String id) {
        return memberRepository.findById(id).isPresent();
    }

    // 아이디 형식 체크

    public boolean checkIdForm(String id) {
        String pattern = "^[a-zA-Z0-9]{6,20}$";
        return Pattern.matches(pattern, id);
    }

    // 비밀번호 형식 체크

    public boolean checkPasswordForm(String password) {
        String pattern = "^[a-zA-Z0-9!@#$%^&*]{6,20}$";
        return Pattern.matches(pattern, password);
    }

    // 로그인 성공 체크

    public boolean logincheck(String ID, String PWD){

        boolean success = false;

        if(memberRepository.findById(ID).isPresent()){


        }



        return success;
    }


}
