package org.ardias.github.db;

import org.ardias.github.auth.User;

import java.util.Optional;

/**
 * Created by Antonio Dias on 20/05/2017.
 */
public interface UserRepository {
    Optional<User> findUser(String username, String password);
}
