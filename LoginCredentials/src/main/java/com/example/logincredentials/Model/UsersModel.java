package com.example.logincredentials.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "users_table")
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    String login;

    String Email;

    String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersModel that = (UsersModel) o;
        return Objects.equals(Id, that.Id) && Objects.equals(login, that.login) && Objects.equals(Email, that.Email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, login, Email, password);
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "Id=" + Id +
                ", Login='" + login + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
