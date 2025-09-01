package uz.pdp.AutoTicket.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.pdp.AutoTicket.utils.DescriptionConstants;

import java.util.Set;

import static uz.pdp.AutoTicket.enums.Permission.*;

/**
 * @author Baxriddinov Odiljon
 * @since 01/09/2025 14:00
 */

@Getter
@AllArgsConstructor
public enum Role {

    USER(DescriptionConstants.DESCRIPTION_USER,
            Set.of(VIEW_OWN_PROFILE,
                    EDIT_OWN_PROFILE,

                    BOOK_TICKETS,
                    CANCEL_TICKETS,
                    VIEW_TICKET_HISTORY,

                    SEARCH_BUSES,
                    SEARCH_ROUTES,
                    MAKE_PAYMENTS,
                    RATE_TRIPS,
                    REVIEW_TRIPS)),

    PASSENGER(DescriptionConstants.DESCRIPTION_PASSENGER,
            Set.of(VIEW_AVAILABLE_TRIPS,
                    VIEW_PERSONAL_TICKET_HISTORY,
                    RECEIVE_NOTIFICATION_ABOUT_TRIPS)),
    DRIVER(DescriptionConstants.DESCRIPTION_DRIVER,
            Set.of(VIEW_ASSIGNED_TRIPS,
                    UPDATE_TRIP_STATUS,
                    VIEW_PASSENGER_LIST_FOR_ASSIGNED_TRIPS,
                    UPDATE_BUS_STATUS,
                    COMMUNICATE_WITH_PASSENGERS)),
    ADMIN(DescriptionConstants.DESCRIPTION_ADMIN,
            Set.of(MANAGE_USERS, // create, update, deactivate_accounts
                    MANAGE_DRIVERS, // create, update, deactivate_accounts,
                    MANAGE_TRIPS_AND_SCHEDULES, // CRUD
                    VIEW_ALL_BOOKINGS,
                    GENERATE_REPORTS,
                    MODERATE_REVIEWS_AND_RATINGS,
                    MANAGE_PAYMENTS_OR_TRANSACTIONS)
    ),
    SUPER_ADMIN(DescriptionConstants.DESCRIPTION_SUPER_ADMIN,
            Set.of(ALL_ADMIN_PERMISSION,
                    MANAGE_ROLES_AND_PERMISSIONS,
                    MANAGE_SYSTEM_SETTINGS,
                    ACCESS_ALL_LOGS_AND_ANALYTICS,
                    EMERGENCY_ACTIONS));

    private final String description;
    private final Set<Permission> permissions;
}
