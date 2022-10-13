package oit.is.z0026.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0026.kaizi.janken.model.Entry;

@Controller

public class JankenController {
  @Autowired
  private Entry entry;

    @GetMapping("/JankenController")
    public String jankenController() {
      return "janken.html";
    }

    @GetMapping("/janken")
    public String janken(Principal prin, ModelMap model) {
      String loginUser = prin.getName();
      this.entry.addUser(loginUser);
      model.addAttribute("username", "Hi! "+loginUser);
      model.addAttribute("entry", this.entry);
      return "janken.html";
    }

    @PostMapping("/JankenController")
    public String janken(@RequestParam String user, ModelMap model) {
      model.addAttribute("username","Hi! "+user); //userがもってきた変数
      return "janken.html";
    }

    @GetMapping("/JankenComp")
    public String param(@RequestParam String param1, ModelMap model) {
      model.addAttribute("parameter","自分の手 "+param1); //paramがもってきた変数
      model.addAttribute("cpu","相手の手 グー");
      String gu = "グー";
      String win = "勝ちです";
      String lose = "負けです";
      String draw = "あいこです";
      String pa = "パー";
      String tyo = "チョキ";
      if(param1.equals(gu)){
        model.addAttribute("compare","結果 "+draw);
      }else if(param1.equals(pa)){
        model.addAttribute("compare","結果 "+win);
      }else if(param1.equals(tyo)){
        model.addAttribute("compare","結果 "+lose);
      }
      return "janken.html";
    }
}
