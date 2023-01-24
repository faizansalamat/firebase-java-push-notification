package com.springhow.examples.springbootfcmdemo.service;

import com.google.firebase.messaging.*;
import com.springhow.examples.springbootfcmdemo.pojo.Note;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }


    public String sendNotification(Note note) throws FirebaseMessagingException {

        Notification.Builder builder = Notification
                .builder();
        builder.setTitle(note.getSubject());
        builder.setBody(note.getContent());
        builder.setImage(note.getImage());
        Notification notification = builder
                .build();

        Message message = Message
                .builder()
                .setNotification(notification)
                // This token will be generated from the Frontend. By integrating firebase in Frontend
                .setToken("cEudZcbCvdCojLONdFdOtV:APA91bHwU4YP-JhmSCepDW9ZgvRwNInM4n0wxBmPRetR_t73Ur3NPXmpiqxnXl7xLJLcgK9bEylJ7ObtFQ96poh9-9e_894Fevl-TuEvuvgn34y6h3AYbFFtiQgV88BRn9jEp9ozwvht")
                .putAllData(note.getData())
                .build();

        return firebaseMessaging.send(message);
    }

}
