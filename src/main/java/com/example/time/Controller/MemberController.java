package com.example.time.Controller;
import com.example.time.DAO.UserDao;
import com.example.time.DTO.MemberDTO;
import com.example.time.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    UserDao userDao = new UserDao();

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println(memberDTO);
        memberService.save(memberDTO);
        return "index";
    }
    @GetMapping("/login/alert")
    public String showAlertPage(){return "LoginRequire";}

    @GetMapping("/login")
    public String showLoginPage(){return "login";}
    @PostMapping("/login")
    public String logIn(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model){
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult != null){
            System.out.println("로그인 성공");
            session.setAttribute("id", loginResult.getId());
            model.addAttribute("name", loginResult.getName());
            model.addAttribute("id", loginResult.getId());
            model.addAttribute("member", loginResult);
            return "index_logind";
        }
        else{
            System.out.println("로그인 실패");
            return "LoginFailure";
        }
    }
    @GetMapping("/member")
    public String findALl(Model model){
        List<MemberDTO> memberDTOArrayList = memberService.findAll();
        model.addAttribute("memberList", memberDTOArrayList);
        return "list_good";
    }

    @GetMapping("/member/{id}")
    public String showMemberInfo(@PathVariable Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }
    @GetMapping("/MyPage/{id}")
    public String showMyPage(@PathVariable Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "MyPage";
    }
    @GetMapping("/delete/warning")
    public String showWarning(){return "DeleteWarning";}
}
