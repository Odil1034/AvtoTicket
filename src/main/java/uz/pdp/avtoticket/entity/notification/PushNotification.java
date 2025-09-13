package uz.pdp.avtoticket.entity.notification;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author Baxriddinov Odiljon
 * @since 13/09/2025 12:11
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PushNotification extends Notification {
    private String title;
    private String body;
    private String imageUrl;

    @Lob
    private String data; // qo‘shimcha JSON payload
}
    /*
        {
            "to": "DEVICE_TOKEN_HERE",
            "notification": {
            "title": "AvtoTicket",
            "body": "Sizning chiptangiz tasdiqlandi ✅",
            "icon": "https://avtoticket.uz/icon.png"
        },
            "data": {
            "ticketId": "12345",
            "action": "OPEN_TICKET"
        }
    */
