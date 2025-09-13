package uz.pdp.avtoticket.entity.notification.sender;

import org.springframework.stereotype.Component;
import uz.pdp.avtoticket.entity.notification.EmailNotification;

/**
 * @author Baxriddinov Odiljon
 * @since 13/09/2025 11:20
 */
@Component
public class EmailNotificationSender implements NotificationSender<EmailNotification> {

    @Override
    public void send(EmailNotification emailNotification) {

    }
}
