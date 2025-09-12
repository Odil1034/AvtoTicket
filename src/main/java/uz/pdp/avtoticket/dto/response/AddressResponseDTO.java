package uz.pdp.avtoticket.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.entity.Address;
import uz.pdp.avtoticket.entity.address.Country;
import uz.pdp.avtoticket.entity.address.District;
import uz.pdp.avtoticket.entity.address.Region;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 11:44
 */

@Getter
@Setter
@AllArgsConstructor
public class AddressResponseDTO implements Response {
    private Long id;
    private Long districtId;
    private String districtName;
    private String regionName;
    private String countryName;
    private Double latitude;
    private Double longitude;

    public AddressResponseDTO toDto(Address address) {
        District district = address.getDistrict();
        Region region = district.getRegion();
        Country country = region.getCountry();

        return new AddressResponseDTO(
                address.getId(),
                district.getId(),
                district.getNameUz(),
                region.getNameUz(),
                country.getName(),
                address.getLatitude(),
                address.getLongitude()
        );
    }
}
