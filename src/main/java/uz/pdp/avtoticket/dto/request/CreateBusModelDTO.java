package uz.pdp.avtoticket.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.enums.Manufacturer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateBusModelDTO implements Request {

    private Long id;

    @NotNull(message = "ModelName can not be null")
    @NotBlank
    private String modelName;

    @Schema(description = "Avtobus ishlab chiqaruvchisi", implementation = Manufacturer.class)
    private Manufacturer manufacturer;
}
