package oit.is.z0026.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT id,name from users where id = #{id}")
  User selectById(int id);

  @Select("SELECT * from users")  //where name = #{username} usernameに入っている変数が調べることができる
  ArrayList<User> selectAllUser();

  @Select("SELECT id,name from users where name = #{name}")
  User selectByName(String name);

}
