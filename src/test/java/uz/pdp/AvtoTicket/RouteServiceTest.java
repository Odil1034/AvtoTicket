package uz.pdp.AvtoTicket;

/**
 * @author Baxriddinov Odiljon
 * @since 13/09/2025 10:39
 */

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import uz.pdp.avtoticket.entity.Address;
import uz.pdp.avtoticket.entity.address.District;
import uz.pdp.avtoticket.service.RouteService;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalTime;

@RequiredArgsConstructor
public class RouteServiceTest {

    private final RouteService routeService;

    @Test
    void testCalculateDistance() {
        Address from = new Address();
        from.setLatitude(41.2995);   // Toshkent lat
        from.setLongitude(69.2401); // Toshkent lon

        Address to = new Address();
        to.setLatitude(39.6542);    // Samarqand lat
        to.setLongitude(66.9597);   // Samarqand lon

        double distance = routeService.calculateDistance(from, to);

        // O'rtacha ~ 270-310 km chiqishi kerak
        assertThat(distance).isBetween(270.0, 310.0);
    }

    @Test
    void testCalculateEstimateTime() {
        LocalTime time = routeService.calculateEstimateTime(120); // 120 km
        assertThat(time).isEqualTo(LocalTime.of(3, 0)); // 3 soat
    }

    @Test
    void testGenerateRouteName() {
        District d1 = new District();
        d1.setNameUz("Toshkent");
        Address from = new Address();
        from.setDistrict(d1);

        District d2 = new District();
        d2.setNameUz("Samarqand");
        Address to = new Address();
        to.setDistrict(d2);

        String name = routeService.generateRouteName(from, to);
        assertThat(name).isEqualTo("Toshkent - Samarqand");
    }
}
