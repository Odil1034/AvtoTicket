package uz.pdp.avtoticket.entity.notification;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import uz.pdp.avtoticket.enums.SMSType;
import uz.pdp.avtoticket.utils.NotificationConstants;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 13/09/2025 11:37
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SMSNotification extends Notification {
    private boolean unicode;
    private Integer maxRetries;
    private String templateId;
    private String message;
    @Builder.Default
    private SMSType smsType = NotificationConstants.DEFAULT_SMS_TYPE; // sms | otp | mms | whatsapp
    private LocalDateTime expiresAt = NotificationConstants.SMS_EXPIRED_AT; // OTP uchun TTL
}

    /*
        SMS yuborish (OTP)
        {
            "idempotencyKey": "b1a2c3d4-5678-90ab-cdef-1234567890ab",
            "to": "+998901234567",
            "from": "AvtoTicket",
            "type": "otp",
            "message": "Sizning AvtoTicket tasdiqlash kodingiz: 654321 (5 daqiqa ichida amal qiladi).",
            "ttl": 300,
            "templateId": "sms_otp_v1",
            "templateVariables": { "code": "654321" },
            "callbackUrl": "https://yourapp.example.com/webhook/sms-status",
            "metadata": { "userId": 42 }
         }
    */
