package com.obdx.infrastructure.in.rest.configuration.auth;

import com.obdx.infrastructure.in.rest.configuration.session.user.DogTrainerAuthorizationExtractor;
import com.obdx.infrastructure.in.rest.configuration.session.user.type.jwt.JwtDogTrainerAuthorizationExtractor;
import com.obdx.infrastructure.in.rest.configuration.session.user.type.mocked.MockedDogTrainerAuthorizationExtractor;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfiguration {

    Logger logger = LoggerFactory.getLogger(AuthConfiguration.class);

    @Bean
    @ConditionalOnProperty(value = "obdx-backend.auth.mocked", havingValue = "true")
    DogTrainerAuthorizationExtractor mockExtractor() {
        logger.warn("YOU ARE SETTING UP THE REST API WITH MOCKED JWT VALUE");
        return new MockedDogTrainerAuthorizationExtractor("1", "Txomin Sirera", Collections.singletonList("obdx"));
    }

    @Bean
    @ConditionalOnProperty(value = "obdx-backend.auth.mocked", havingValue = "false")
    DogTrainerAuthorizationExtractor jwtExtractor() {
        return new JwtDogTrainerAuthorizationExtractor();
    }
}
