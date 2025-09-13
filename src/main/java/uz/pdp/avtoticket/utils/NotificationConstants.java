package uz.pdp.avtoticket.utils;

import uz.pdp.avtoticket.enums.SMSType;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 13/09/2025 12:49
 */
public interface NotificationConstants {

    SMSType DEFAULT_SMS_TYPE = SMSType.SMS;
    LocalDateTime SMS_EXPIRED_AT = LocalDateTime.now().plusSeconds(120);
}
