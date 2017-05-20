package org.ardias.github.db;

import org.apache.commons.codec.digest.DigestUtils;
import org.ardias.github.auth.User;
import org.ardias.github.db.UserRepository;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by Antonio Dias on 20/05/2017.
 */
public class InMemoryUseRepository implements UserRepository {

    private final Map<String, byte[]> users;

    public InMemoryUseRepository() {
        this.users = new HashMap<>();
        byte[] sha1Password = DigestUtils.sha1("admin".getBytes(StandardCharsets.UTF_8));
        this.users.put("admin", sha1Password);
    }

    @Override
    public Optional<User> findUser(String username, String password) {
        if(this.users.containsKey(username)) {
            byte[] sha1Password =  DigestUtils.sha1(password);
            byte[] secretPassword = this.users.get(username);
            if(Arrays.equals(sha1Password,secretPassword)) {
                return Optional.of(new User(username));
            }
        }
        return Optional.empty();
    }
}
