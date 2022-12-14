package oit.is.z0026.kaizi.janken.controller;

import java.lang.ProcessHandle.Info;
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
import oit.is.z0026.kaizi.janken.model.MatchInfo;
import oit.is.z0026.kaizi.janken.model.MatchMapper;
import oit.is.z0026.kaizi.janken.model.MatchInfoMapper;



@Controller
public class JankenController {
  /*@Autowired
  private Entry entry;
*/
  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  //@Autowired
  //MatchInfoMapper matchinfoMapper;

  @Autowired
  MatchInfoMapper info;


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
      ArrayList<MatchInfo> matchinfo = info.selectMatchInfoByTrue();
      model.addAttribute("matchinfo", matchinfo);
      return "janken.html";
    }

    @PostMapping("/JankenController")
    public String janken(@RequestParam String user, ModelMap model) {
      model.addAttribute("username","Hi! "+user); //user????????????????????????
      return "janken.html";
    }

    /*@GetMapping("/JankenComp")
    public String param(Principal prin, @RequestParam String param1, ModelMap model) {
      model.addAttribute("parameter","???????????? "+param1); //param????????????????????????
      model.addAttribute("cpu","???????????? ??????");
      String gu = "??????";
      String win = "????????????";
      String lose = "????????????";
      String draw = "???????????????";
      String pa = "??????";
      String tyo = "?????????";
      if(param1.equals(gu)){
        model.addAttribute("compare","?????? "+draw);
      }else if(param1.equals(pa)){
        model.addAttribute("compare","?????? "+win);
      }else if(param1.equals(tyo)){
        model.addAttribute("compare","?????? "+lose);
      }
      return "janken.html";
    }*/

    @GetMapping("/match")
    public String param(Principal prin,@RequestParam int id, ModelMap model) {
      String loginUser = prin.getName();
      model.addAttribute("username", loginUser);
      User user = userMapper.selectById(id);
      model.addAttribute("enemy", user);
     /*  model.addAttribute("parameter","???????????? "+param1); //param????????????????????????
      model.addAttribute("cpu","???????????? ??????");
      String gu = "??????";
      String win = "????????????";
      String lose = "????????????";
      String draw = "???????????????";
      String pa = "??????";
      String tyo = "?????????";
      if(param1.equals(gu)){
        model.addAttribute("compare","?????? "+draw);
      }else if(param1.equals(pa)){
        model.addAttribute("compare","?????? "+win);
      }else if(param1.equals(tyo)){
        model.addAttribute("compare","?????? "+lose);
      }*/
      return "match.html";
    }

    /*@GetMapping("/fight")
    public String fight(Principal prin,@RequestParam int id,@RequestParam String param1,ModelMap model){
      model.addAttribute("parameter","???????????? "+param1); //param????????????????????????
      model.addAttribute("cpu","???????????? ??????");
      Match match = new Match();
      User user = userMapper.selectByName(prin.getName());
      String loginUser = prin.getName();
      model.addAttribute("username", loginUser);
      User enemy = userMapper.selectById(id);
      model.addAttribute("enemy", enemy);
      String gu = "??????";
      String win = "????????????";
      String lose = "????????????";
      String draw = "???????????????";
      String pa = "??????";
      String tyo = "?????????";
      if(param1.equals(gu)){
        model.addAttribute("compare","?????? "+draw);
      }else if(param1.equals(pa)){
        model.addAttribute("compare","?????? "+win);
      }else if(param1.equals(tyo)){
        model.addAttribute("compare","?????? "+lose);
      }
      match.setUser1(Integer.toString(user.getId()));
      match.setUser2(Integer.toString(id));
      match.setUser1Hand(param1);
      match.setUser2Hand(gu);
      matchMapper.insertMatch(match);
      return "match.html";
    }*/

    @GetMapping("/fight")
    public String fight(Principal prin,@RequestParam int id,@RequestParam String param1,ModelMap model){
      String loginUser = prin.getName();
      MatchInfo matchinfo = new MatchInfo();
      User user = userMapper.selectByName(loginUser);
      //ArrayList<MatchInfo> matchInfos = info.selectMatchInfoByTrueComp(user.getId(),id);
      //if(matchInfos.size() == 0){
        //info.insertMatchInfo(user.getId(),id,hand,true);
      //}else if(matchInfos.size() == 1){
        //MatchInfo matchInfo = matchInfos.get(0);
        matchinfo.setUser1(user.getId());
        matchinfo.setUser2(id);
        matchinfo.setUser1Hand(param1);
        matchinfo.setIsActive(true);
        info.insertMatchInfo(matchinfo);
        String gu = "??????";
        String win = "????????????";
        String lose = "????????????";
        String draw = "???????????????";
        String pa = "??????";
        String tyo = "?????????";
        if(param1.equals(gu)){
          model.addAttribute("compare","?????? "+draw);
        }else if(param1.equals(pa)){
          model.addAttribute("compare","?????? "+win);
        }else if(param1.equals(tyo)){
          model.addAttribute("compare","?????? "+lose);
        }
      //}
      return "wait.html";
    }

}
