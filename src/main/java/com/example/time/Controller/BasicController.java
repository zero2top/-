package com.example.time.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping()
@RequiredArgsConstructor
public class BasicController {
    @GetMapping("/home")
    public String showFirstPage(){
        return "first-page";
    }

    @GetMapping("/main")
    public String showMainPage(){return "main";}

}
