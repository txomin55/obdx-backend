package com.obdx.infrastructure.in.rest.endpoints.authentication;

import com.obdx.oas.stub.api.VerifyApiDelegate;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Profile("develop")
@Service
public class Verify implements VerifyApiDelegate {

    @Override
    public ResponseEntity<String> verify(String authorization) {
        return ResponseEntity.ok("--MOCKED VERIFY OK");
    }
}
