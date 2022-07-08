package com.opencode.practice.repos;

import com.opencode.practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(nativeQuery = true, value = "select DISTINCT au.id, au.email, au.password" +
            " FROM app_user au JOIN users_answer ua JOIN answer a JOIN question q" +
            " ON q.id = a.question_id ON a.id  = ua.answer_id on ua.app_user_id = au.id  WHERE q.questionnaire_id = 34 ORDER BY au.id  ASC")
    List<User> findUsersByQuestionnaireId(long id);
}
