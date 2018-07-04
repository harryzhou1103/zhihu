package com.zhihu.dao;

import com.zhihu.model.Question;
import com.zhihu.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionDAO {
    String TABLE_NAME = "question";
    String INSERT_FILEDS = "title, content, create_date, user_id, comment_count";
    String SELECT_FILEDS = "id, " + INSERT_FILEDS;


    @Insert({"insert into", TABLE_NAME, "("
            , INSERT_FILEDS, ") values(#{title}, #{content}, #{createdDate}, #{userId}, #{commentCount})"})
    int addQuestion(Question question);

    List<Question> selectLatestQuestions(@Param("userId") int userId,
                                         @Param("offset") int offset,
                                         @Param("limit") int limit);
    @Select({"select ", SELECT_FILEDS, " from ", TABLE_NAME, " where id=#{id}"})
    Question getById(int id);

    @Update({"update", TABLE_NAME, " set password=#{password} where id=#{id}"})
    void updatePassword(User user);

    @Delete({"delete from ", TABLE_NAME, " where id=#{id}"})
    void deleteById(int id);
}
