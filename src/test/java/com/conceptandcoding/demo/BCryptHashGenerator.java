package com.conceptandcoding.demo;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptHashGenerator {

    @Test
    void generateHashes() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("admin hash: " + encoder.encode("admin"));
        System.out.println("1234 hash:  " + encoder.encode("1234"));
    }
}
