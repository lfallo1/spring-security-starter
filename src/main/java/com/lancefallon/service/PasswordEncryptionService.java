package com.lancefallon.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * Password encryption service
 *
 * @author lfallon
 *
 */
@Service
public class PasswordEncryptionService {

    /**
     * Encrypt string using bcrypt
     *
     * @param password
     * @return
     */
    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    /**
     * compare a password with a hash
     *
     * @param candidate
     * @param hash
     * @return
     */
    public Boolean checkpw(String candidate, String hash) {
        return BCrypt.checkpw(candidate, hash);
    }
}
