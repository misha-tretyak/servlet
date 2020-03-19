package com.lviv.lgs.servise.serviseImpl;

import com.lviv.lgs.entity.User;
import com.lviv.lgs.servise.UserServise;

import java.util.*;

public class UserServiseImpl implements UserServise {

    private UserServiseImpl(){

    }

    public static UserServise getInstance(){return instance;}

    private static UserServiseImpl instance = new UserServiseImpl();

    private int fakeId = 1;
    private Map<Integer, User> fakeDb = new HashMap<>();

    @Override
    public void save(User user) {
        fakeDb.put(fakeId++, user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(fakeDb.values());
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(fakeDb.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return fakeDb.values().stream().filter(entry -> entry.getEmail().equals(email)).findFirst();
    }
}
