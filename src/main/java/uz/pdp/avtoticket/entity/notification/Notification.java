package uz.pdp.avtoticket.entity.notification;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import uz.pdp.avtoticket.entity.BaseEntity;
import uz.pdp.avtoticket.enums.NotificationStatus;
import uz.pdp.avtoticket.enums.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;


/**
 * @author Baxriddinov Odiljon
 * @since 13/09/2025 12:20
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Notification extends BaseEntity {

    private Long userId;

    @Enumerated(EnumType.STRING)
    private NotificationType type; // EMAIL, SMS, PUSH

    private String recipient; // kimga yuboriladi
    private String sender;    // kimdan yuboriladi (from)

    @Enumerated(EnumType.STRING)
    private NotificationStatus status; // PENDING, SENT, FAILED...

    private String providerMessageId;
    private String correlationId;

    private LocalDateTime createdAt;
    private LocalDateTime sentAt;
    private LocalDateTime deliveredAt;
    private LocalDateTime failedAt;

    private String errorMessage;

    @Builder.Default
    private UUID idempotencyKey = UUID.randomUUID();

    private String callbackUrl; // webhook status uchun

    @Lob
    private String metadata; // JSON qo‘shimcha info
}