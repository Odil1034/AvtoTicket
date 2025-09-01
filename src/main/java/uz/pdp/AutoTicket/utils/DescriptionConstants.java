package uz.pdp.AutoTicket.utils;

/**
 * @author Baxriddinov Odiljon
 * @since 01/09/2025 15:05
 */
public interface DescriptionConstants {

    String DESCRIPTION_USER = """
            A regular registered user. Main responsibilities include managing their own profile, searching for trips,
             booking tickets, and making payments.
            """;

    String DESCRIPTION_PASSENGER = """
            A traveler who uses the app mainly for trips. Can book and cancel tickets, view their travel history, and receive
             notifications about trips.""";

    String DESCRIPTION_DRIVER = """
            A vehicle driver. Responsibilities include managing assigned trips, updating trip status, viewing the
             list of passengers for assigned trips, and monitoring vehicle status.
            """;

    String DESCRIPTION_ADMIN = """
            A system administrator with broad management rights but below super_admin level. Can manage users and drivers,
             create and modify trips and schedules, handle payments, moderate reviews and ratings, and generate reports.
            """;

    String DESCRIPTION_SUPER_ADMIN = """
            The highest-level user in the system. Has all admin privileges plus the ability to manage roles and permissions,
             configure system settings, access all logs and analytics, and perform emergency actions if needed.""";
}
