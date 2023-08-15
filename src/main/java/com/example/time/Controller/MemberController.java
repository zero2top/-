package com.example.time.Controller;
import com.example.time.DAO.UserDao;
import com.example.time.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.SQLException;


@Controller
@RequiredArgsConstructor
public class MemberController {
    UserDao userDao = new UserDao();
    private static MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String save(@RequestParam("email") String email,
                       @RequestParam("name") String name,
                       @RequestParam("password1") String password1,
                       @RequestParam("password2") String password2) throws SQLException, ClassNotFoundException {
        System.out.printf("name : %s, email : %s, password1 : %s, password2 : %s", name, email, password1, password2);
        if(password1.equals(password2)){
            userDao.add(name, email, password1);
            return "first-page";
        }
        else{
            return "signup";
        }
    }
    @GetMapping("/login")
    public String showLoginPage(){return "login";}
    @PostMapping("/login")
    public String logIn(@RequestParam("id") String id,
                        @RequestParam("password") String password){
        /*MemberInfo member = memberRepository.findById(id);
        if(member == null){
            return "login";
        }
        else{
            if(member.getPassword().equals(password)){
                return "first-page";
            }
            else{
                return "login";
            }
        }*/
        return "login";
    }
}
