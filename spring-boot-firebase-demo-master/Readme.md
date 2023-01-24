

Generate a new Private key from

settings/serviceaccounts/adminsdk in firebase. It will download a json file.

Paste this json file under resources' folder.

![](/Users/faizanslamat/Desktop/Screenshot 2023-01-24 at 6.39.14 PM.png)

Magic happens under FirebaseMessagingService

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
