package uz.pdp.avtoticket.utils;

import uz.pdp.avtoticket.entity.Permission;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Baxriddinov Odiljon
 * @since 01/09/2025 16:38
 */
public class RolePermissionConstants {

    public static final Set<Permission> USER = Set.of(
            Permission.builder().access("VIEW_OWN_PROFILE").build(),
            Permission.builder().access("EDIT_OWN_PROFILE").build(),
            Permission.builder().access("BOOK_TICKETS").build(),
            Permission.builder().access("CANCEL_TICKETS").build(),
            Permission.builder().access("VIEW_TICKET_HISTORY").build(),
            Permission.builder().access("SEARCH_BUSES").build(),
            Permission.builder().access("SEARCH_ROUTES").build(),
            Permission.builder().access("MAKE_PAYMENTS").build(),
            Permission.builder().access("RATE_TRIPS").build(),
            Permission.builder().access("REVIEW_TRIPS").build()
    );

    public static final Set<Permission> PASSENGER = new HashSet<>() {{
//        addAll(USER);
        addAll(Set.of(
                Permission.builder().access("VIEW_AVAILABLE_TRIPS").build(),
                Permission.builder().access("VIEW_PERSONAL_TICKET_HISTORY").build(),
                Permission.builder().access("RECEIVE_NOTIFICATION_ABOUT_TRIPS").build()
        ));
    }};

    public static final Set<Permission> DRIVER = new HashSet<>() {{
//        addAll(USER);
//        addAll(PASSENGER);
        addAll(Set.of(
                Permission.builder().access("VIEW_ASSIGNED_TRIPS").build(),
                Permission.builder().access("UPDATE_TRIP_STATUS").build(),
                Permission.builder().access("VIEW_PASSENGER_LIST_FOR_ASSIGNED_TRIPS").build(),
                Permission.builder().access("UPDATE_BUS_STATUS").build(),
                Permission.builder().access("COMMUNICATE_WITH_PASSENGERS").build()
        ));
    }};

    public static final Set<Permission> ADMIN = new HashSet<>() {{
//        addAll(USER);
//        addAll(PASSENGER);
//        addAll(DRIVER);
        addAll(Set.of(
                Permission.builder().access("MANAGE_USERS").build(),
                Permission.builder().access("MANAGE_DRIVERS)").build(),
                Permission.builder().access("MANAGE_TRIPS_AND_SCHEDULES").build(),
                Permission.builder().access("VIEW_ALL_BOOKINGS").build(),
                Permission.builder().access("GENERATE_REPORTS").build(),
                Permission.builder().access("MODERATE_REVIEWS_AND_RATINGS").build(),
                Permission.builder().access("MANAGE_PAYMENTS_OR_TRANSACTIONS").build()
        ));
    }};

    public static final Set<Permission> SUPER_ADMIN = new HashSet<>() {{
//        addAll(USER);
//        addAll(PASSENGER);
//        addAll(DRIVER);
//        addAll(ADMIN);
        addAll(Set.of(
                Permission.builder().access("ALL_ADMIN_PERMISSION").build(),
                Permission.builder().access("MANAGE_ROLES_AND_PERMISSIONS").build(),
                Permission.builder().access("MANAGE_SYSTEM_SETTINGS").build(),
                Permission.builder().access("ACCESS_ALL_LOGS_AND_ANALYTICS").build(),
                Permission.builder().access("EMERGENCY_ACTIONS").build()
        ));
    }};
}