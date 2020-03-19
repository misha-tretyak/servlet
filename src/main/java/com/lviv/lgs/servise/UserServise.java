package com.lviv.lgs.servise;

import com.lviv.lgs.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServise {

    void save(User user);

    List<User> findAll();

    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);
}
