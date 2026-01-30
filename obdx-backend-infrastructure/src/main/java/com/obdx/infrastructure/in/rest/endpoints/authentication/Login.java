package com.obdx.infrastructure.in.rest.endpoints.authentication;

import com.obdx.oas.stub.api.LoginApiDelegate;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Profile("develop")
@Service
public class Login implements LoginApiDelegate {

    @Override
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("--MOCKED LOGIN OK");
    }
}
