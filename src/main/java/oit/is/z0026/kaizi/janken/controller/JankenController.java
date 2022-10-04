package oit.is.z0026.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {
    @GetMapping("/janken")
    public String janken() {
      return "janken.html";
    }

    @PostMapping("/janken")
    public String janken(@RequestParam String user, ModelMap model) {
      model.addAttribute("username",user); //userがもってきた変数
      return "janken.html";
    }
}
