package oit.is.z0026.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {
    @GetMapping("/JankenController")
    public String janken() {
      return "janken.html";
    }

    @PostMapping("/JankenController")
    public String janken(@RequestParam String user, ModelMap model) {
      model.addAttribute("username","Hi! "+user); //userがもってきた変数
      return "janken.html";
    }

    @GetMapping("/Janken")
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
