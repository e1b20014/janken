package oit.is.z0026.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {

  //@Insert("INSERT INTO matches (user1,user2,user1Hand,user2Hand) VALUES (#{user1},#{user2},#{user1Hand},#{user2Hand},#{isActive})")
  //void insertMatch(Match match);

  @Insert("INSERT INTO matches (user1,user2,user1Hand,user2Hand) VALUES (#{user1},#{user2},#{user1Hand},#{user2Hand},#{isActive})")
  void insertMatch(String user1,String user2,String user1hand,String user2Hand);

  @Select("SELECT * from matches")  //where name = #{username} usernameに入っている変数が調べることができる
  ArrayList<Match> selectAllMatch();

  @Select("SELECT * from matchinfo")  //where name = #{username} usernameに入っている変数が調べることができる
  ArrayList<Match> selectAllMatchInfo();

}
