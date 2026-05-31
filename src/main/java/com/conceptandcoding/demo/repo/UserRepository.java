package com.conceptandcoding.demo.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class UserRepository {

    @Transactional
    public void saveUser() {
        System.out.println("Saving user to the database...");
    }

}
