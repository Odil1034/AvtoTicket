package uz.pdp.avtoticket.utils;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Baxriddinov Odiljon
 * @since 01/09/2025 21:21
 */
@Getter
public enum ErrorCode {

    // ==== AUTH & USER ====
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "User already exists"),
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "Invalid email/phone or password"),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "Token expired"),
    TOKEN_INVALID(HttpStatus.UNAUTHORIZED, "Invalid token"),
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "Wrong password"),

    // ==== COUNTRY ====
    COUNTRY_NOT_FOUND(HttpStatus.NOT_FOUND, "Country not found"),
    COUNTRY_ALREADY_EXISTS(HttpStatus.CONFLICT, "Country already exists"),

    // ==== REGION ====
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "Region not found"),
    REGION_ALREADY_EXISTS(HttpStatus.CONFLICT, "Region already exists"),

    // ==== DISTRICT ====
    DISTRICT_NOT_FOUND(HttpStatus.NOT_FOUND, "District not found"),
    DISTRICT_ALREADY_EXISTS(HttpStatus.CONFLICT, "District already exists"),

    // ==== ROUTE / TRIP ====
    ROUTE_NOT_FOUND(HttpStatus.NOT_FOUND, "Route not found"),
    ROUTE_ALREADY_EXISTS(HttpStatus.CONFLICT, "Route already exists"),
    TRIP_NOT_FOUND(HttpStatus.NOT_FOUND, "Trip not found"),
    TRIP_ALREADY_EXISTS(HttpStatus.CONFLICT, "Trip already exists"),

    // ==== BUS ====
    BUS_NOT_FOUND(HttpStatus.NOT_FOUND, "Bus not found"),
    BUS_ALREADY_EXISTS(HttpStatus.CONFLICT, "Bus already exists"),
    BUS_MODEL_NOT_FOUND(HttpStatus.NOT_FOUND, "Bus model not found"),
    BUS_MODEL_ALREADY_EXISTS(HttpStatus.CONFLICT, "Bus model already exists"),

    // ==== NOTIFICATION ====
    NOTIFICATION_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Notification failed"),
    EMAIL_SEND_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Email sending failed"),
    SMS_SEND_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "SMS sending failed"),
    PUSH_SEND_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Push notification failed"),

    // ==== GENERAL ====
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found"),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "Validation error"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
