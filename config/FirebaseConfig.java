package com.Invitemee.Invitemee.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp initializeFirebase() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            GoogleCredentials serviceAccount = GoogleCredentials.fromStream(new ClassPathResource("spring-firebase-key.json").getInputStream());

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(serviceAccount)
                    .setStorageBucket("hfhgfhg-1c241.appspot.com")
                    .build();
            return FirebaseApp.initializeApp(options);
        } else {
            return FirebaseApp.getInstance();
        }
    }
}
