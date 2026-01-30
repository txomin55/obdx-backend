package com.obdx.infrastructure.in.rest.endpoints.authentication;

import com.obdx.oas.stub.api.LoginUrlApiDelegate;
import com.obdx.oas.stub.model.LoginUrlWeb;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Profile("develop")
@Service
public class LoginUrl implements LoginUrlApiDelegate {

    @Override
    public ResponseEntity<LoginUrlWeb> loginUrl() {
        return ResponseEntity.ok(new LoginUrlWeb("https://accounts.google.com/o/oauth2/v2/auth?response_type=code&code_challenge=challenge-test&code_challenge_method=plain&client_id=1011194036460-ggb1ouh6l0894kbdihmkdid8tjimdnhh.apps.googleusercontent.com&redirect_uri=http://localhost:3000/&scope=openid%20email%20profile&state=state-example&access_type=offline"
        ));
    }

}
