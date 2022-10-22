package oit.is.z0026.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.transaction.annotation.Transactional;

//import oit.is.z0026.kaizi.janken.model.Entry;
import oit.is.z0026.kaizi.janken.model.User;
import oit.is.z0026.kaizi.janken.model.UserMapper;
import oit.is.z0026.kaizi.janken.model.Match;
import oit.is.z0026.kaizi.janken.model.MatchMapper;

@Controller
public class JankenController {
  /*@Autowired
  private Entry entry;
*/
  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

    @GetMapping("/JankenController")
    public String jankenController() {
      return "janken.html";
    }

    /*@GetMapping("/janken")
    public String janken(Principal prin, ModelMap model) {
      String loginUser = prin.getName();
      this.entry.addUser(loginUser);
      model.addAttribute("username", "Hi! "+loginUser);
      model.addAttribute("entry", this.entry);
      return "janken.html";
    }*/

    @GetMapping("/janken")
    @Transactional
    public String jankenDB(Principal prin, ModelMap model) {
      String loginUser = prin.getName();
      model.addAttribute("username", "Hi! "+loginUser);
      ArrayList<User> users = userMapper.selectAllUser();
      model.addAttribute("users", users);
      ArrayList<Match> matches = matchMapper.selectAllMatch();
      model.addAttribute("matches", matches);
      return "janken.html";
    }

    @PostMapping("/JankenController")
    public String janken(@RequestParam String user, ModelMap model) {
      model.addAttribute("username","Hi! "+user); //userがもってきた変数
      return "janken.html";
    }

    /*@GetMapping("/JankenComp")
    public String param(Principal prin, @RequestParam String param1, ModelMap model) {
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
    }*/

    @GetMapping("/match")
    public String param(Principal prin,@RequestParam int id, ModelMap model) {
      String loginUser = prin.getName();
      model.addAttribute("username", loginUser);
      User user = userMapper.selectById(id);
      model.addAttribute("enemy", user);
     /*  model.addAttribute("parameter","自分の手 "+param1); //paramがもってきた変数
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
      }*/
      return "match.html";
    }
}
