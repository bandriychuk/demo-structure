package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.responses.UserLoginPayload;
import io.qameta.allure.Step;

public class AuthenticationApiService extends ApiService {

    @Step
    public AssertableResponse loginUser(UserLoginPayload user) {
        return new AssertableResponse(
                setUp()
                        .body(user)
                        .when()
                        .post("/api/login")
                        .then()
                        .extract()
                        .response());
    }
}
