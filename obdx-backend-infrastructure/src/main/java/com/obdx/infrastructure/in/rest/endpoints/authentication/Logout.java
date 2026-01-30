package com.obdx.infrastructure.in.rest.endpoints.authentication;

import com.obdx.oas.stub.api.LogoutApiDelegate;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Profile("develop")
@Service
public class Logout implements LogoutApiDelegate {

    @Override
    public ResponseEntity<String> logout(String authorization) {
        return ResponseEntity.ok("--MOCKED LOGOUT OK");
    }
}
