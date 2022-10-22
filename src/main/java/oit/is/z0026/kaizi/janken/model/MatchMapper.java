package oit.is.z0026.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {

  /*@Select("SELECT id,userName,chamberName from chamber where id = #{id}")
  User selectById(int id);

  @Insert("INSERT INTO chamber (userName,chamberName) VALUES (#{userName},#{chamberName});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertChamber(User chamber);
 */
  @Select("SELECT * from matches")  //where name = #{username} usernameに入っている変数が調べることができる
  ArrayList<Match> selectAllMatch();

}
