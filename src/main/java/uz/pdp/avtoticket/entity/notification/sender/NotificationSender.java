package uz.pdp.avtoticket.entity.notification.sender;

import uz.pdp.avtoticket.entity.notification.Notification;

/**
 * @author Baxriddinov Odiljon
 * @since 13/09/2025 11:18
 */
public interface NotificationSender<E extends Notification> {

    void send(E e);
}
