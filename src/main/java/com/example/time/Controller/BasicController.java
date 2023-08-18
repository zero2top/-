package com.example.time.Controller;
import com.example.time.DTO.MemberDTO;
import com.example.time.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping()
@RequiredArgsConstructor
public class BasicController {
    private final MemberService memberService;
    @GetMapping("/home")
    public String showFirstPage(){
        return "first-page";
    }

    @GetMapping("/home/logind/{id}")
    public String showLogindFirstPage(@PathVariable Long id, Model model, HttpSession session) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        session.setAttribute("id", memberDTO.getId());
        System.out.println( memberDTO.getId());
        return "first-page-logind";
    }

    @GetMapping("/home/{id}")
    public String showFirstPageLogind(@PathVariable Long id, Model model){
        return "first-page-logind";
    }

    @GetMapping("/main")
    public String showMainPage(){return "main";}

    @GetMapping("/main/logind/{id}")
    public String showMainPageLogind(@PathVariable Long id, Model model, HttpSession session){
        MemberDTO  memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        session.setAttribute("id", memberDTO.getId());
        System.out.println( memberDTO.getId());
        return "main-logind";
    }

    @GetMapping("/ask")
    public String showAskForm(){
        return "ask";
    }
}
