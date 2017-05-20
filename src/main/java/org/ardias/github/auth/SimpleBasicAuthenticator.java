package org.ardias.github.auth;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import org.ardias.github.db.UserRepository;

import java.util.Optional;

/**
 * Created by Antonio Dias on 20/05/2017.
 */
public class SimpleBasicAuthenticator implements Authenticator<BasicCredentials, User> {

    UserRepository userRepository;

    public SimpleBasicAuthenticator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        return userRepository.findUser(basicCredentials.getUsername(), basicCredentials.getPassword());
    }
}
