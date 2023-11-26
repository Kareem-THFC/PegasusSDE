package com.example.logincredentials.Repository;


import com.example.logincredentials.Model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository <UsersModel, Integer> {

    Optional<UsersModel> findByLoginAndPassword(String login, String password);
}
