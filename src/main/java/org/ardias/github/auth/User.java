package org.ardias.github.auth;

import io.dropwizard.auth.PrincipalImpl;

import java.security.Principal;

/**
 * Created by Antonio Dias on 20/05/2017.
 */
public class User implements Principal {

    private String login;

    public User(String login) {
        this.login = login;
    }

    @Override
    public String getName() {
        return login;
    }
}
