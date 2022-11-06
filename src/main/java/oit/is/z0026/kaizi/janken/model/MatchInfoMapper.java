package oit.is.z0026.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchInfoMapper {
    
    @Insert("INSERT INTO matchinfo (user1,user2,user1Hand,isActive) VALUES (#{user1},#{user2},#{user1Hand},#{isActive})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    //void insertMatchInfo(int user1,int user2,String user1Hand,boolean isActive);
    void insertMatchInfo(MatchInfo matchinfo);

    @Select("SELECT * from matchinfo")  //where name = #{username} usernameに入っている変数が調べることができる
    ArrayList<MatchInfo> selectAllMatchInfo();

    @Select("SELECT * from MatchInfo where isActive = true;")
    ArrayList<MatchInfo> selectMatchInfoByTrue();

    @Select("SELECT * from MatchInfo where isActive = true and user1 = #{user1} and user2 = #{user2};")
    ArrayList<MatchInfo> selectMatchInfoByTrueComp(int user1,int user2);
}
