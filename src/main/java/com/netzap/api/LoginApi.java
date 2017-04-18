package com.netzap.api;

import com.google.common.collect.Lists;
import com.google.common.primitives.Bytes;
import com.netzap.api.request.LoginRequest;
import com.netzap.api.response.LoginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Date;

import static java.time.ZoneOffset.UTC;

@RestController
@RequestMapping("api/login")
public class LoginApi {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest credentials,
                               HttpServletResponse response) throws FailedLoginException {
        if(!credentials.getLogin().equals("jacek")){
            throw new FailedLoginException();
        }
        byte[] bytes = Bytes.toArray(Lists.newArrayList(1000));
        Date expiration = Date.from(LocalDateTime.now().plusHours(12).toInstant(UTC));
        String jwt = Jwts.builder()
                .setSubject(credentials.getLogin())
                .setExpiration(expiration)
                .setIssuer("com.netzap")
                .signWith(SignatureAlgorithm.HS512, bytes)
                .compact();
        response.setHeader("Token", jwt);
        return new LoginResponse(credentials.getLogin(), jwt);
    }
}
