package com.sargintek.furniture_draw_backend.authentication_service.services;

import com.sargintek.furniture_draw_backend.user_service.dtos.RegisterUserDto;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GoogleAuthServiceImpl {
    private static final String CLIENT_ID = "YOUR_GOOGLE_CLIENT_ID";

    public RegisterUserDto verifyGoogleToken(String idTokenString) {
        try {
            JsonFactory jsonFactory = GsonFactory.getDefaultInstance();

            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                    new NetHttpTransport(), jsonFactory)
                    .setAudience(Collections.singletonList(CLIENT_ID))
                    .build();

            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();
                String email = payload.getEmail();
                String name = (String) payload.get("username");

                return new RegisterUserDto(name, email, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
