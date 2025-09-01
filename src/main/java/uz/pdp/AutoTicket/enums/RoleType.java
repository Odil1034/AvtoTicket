package uz.pdp.AutoTicket.enums;

import lombok.Getter;
import uz.pdp.AutoTicket.utils.DescriptionConstants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static uz.pdp.AutoTicket.enums.PermissionType.*;

/**
 * @author Baxriddinov Odiljon
 * @since 01/09/2025 14:00
 */

@Getter
public enum RoleType {

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
            unionOf(USER),
            Set.of(VIEW_AVAILABLE_TRIPS,
                    VIEW_PERSONAL_TICKET_HISTORY,
                    RECEIVE_NOTIFICATION_ABOUT_TRIPS)),
    DRIVER(DescriptionConstants.DESCRIPTION_DRIVER,
            unionOf(USER),
            Set.of(VIEW_ASSIGNED_TRIPS,
                    UPDATE_TRIP_STATUS,
                    VIEW_PASSENGER_LIST_FOR_ASSIGNED_TRIPS,
                    UPDATE_BUS_STATUS,
                    COMMUNICATE_WITH_PASSENGERS)),
    ADMIN(DescriptionConstants.DESCRIPTION_ADMIN,
            unionOf(USER, PASSENGER, DRIVER),
            Set.of(
                    MANAGE_USERS, // create, update, deactivate_accounts
                    MANAGE_DRIVERS, // create, update, deactivate_accounts,
                    MANAGE_TRIPS_AND_SCHEDULES, // CRUD
                    VIEW_ALL_BOOKINGS,
                    GENERATE_REPORTS,
                    MODERATE_REVIEWS_AND_RATINGS,
                    MANAGE_PAYMENTS_OR_TRANSACTIONS)
    ),
    SUPER_ADMIN(DescriptionConstants.DESCRIPTION_SUPER_ADMIN, Set.of(PermissionType.values()));

    private final String description;
    private final Set<PermissionType> permissions;

    // oddiy konstruktor
    RoleType(String description, Set<PermissionType> permissions) {
        this.description = description;
        this.permissions = permissions;
    }

    // inheritance konstruktor
    RoleType(String description, Set<PermissionType> inherited, Set<PermissionType> extra) {
        this.description = description;
        this.permissions = new HashSet<>(inherited);
        this.permissions.addAll(extra);
    }

    // helper: boshqa rolening permissionlarini yig‘ish
    private static Set<PermissionType> unionOf(RoleType... roles) {
        return Arrays.stream(roles)
                .flatMap(r -> r.getPermissions().stream())
                .collect(Collectors.toSet());
    }
}


