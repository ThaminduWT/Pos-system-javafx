package com.pos.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordGenerator {
    public static String encrypt(String passwordText){
        return BCrypt.hashpw(passwordText, BCrypt.gensalt(12));
    }
    public static boolean check(String passwordText, String hashedPassword){
        return BCrypt.checkpw(passwordText, hashedPassword);
    }
}
