package com.doctorhere.reference.authorization.exception;

import com.doctorhere.reference.authorization.token.JwtToken;
import org.springframework.security.core.AuthenticationException;

/**
 * 
 * @author dh-software-team
 *
 * Aug 3, 2016
 */
public class JwtExpiredTokenException extends AuthenticationException {
    private static final long serialVersionUID = -5959543783324224864L;
    
    private JwtToken token;

    public JwtExpiredTokenException(String msg) {
        super(msg);
    }

    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }
}
