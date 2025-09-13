package uz.pdp.avtoticket.entity.notification;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author Baxriddinov Odiljon
 * @since 13/09/2025 11:31
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EmailNotification extends Notification {
    private String subject;
    private String bodyText;
    private String bodyHtml;
    private String templateId;
}

    /*
    {
        "idempotencyKey": "6d8f9c7a-1234-4abc-9ef0-a1b2c3d4e5f6",
        "to": "user@example.com",
        "from": "AvtoTicket <no-reply@avtoticket.uz>",
        "subject": "Hisobingiz tasdiqlash kodi",
        "bodyText": "Salom, tasdiqlash uchun kod: 123456",
        "bodyHtml": "<p>Salom, tasdiqlash uchun kod: <strong>123456</strong></p>",
        "templateId": "email_verify_v1",
        "templateVariables": { "code": "123456", "name": "Odiljon" },
        "callbackUrl": "https://yourapp.example.com/webhook/email-status",
        "metadata": { "userId": 42, "campaign": "signup" }
    }
    */
