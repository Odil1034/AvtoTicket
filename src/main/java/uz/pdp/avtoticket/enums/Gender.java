package uz.pdp.avtoticket.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Jinsi")
public enum Gender {
    @Schema(description = "Erkak")
    MALE,
    @Schema(description = "Ayol")
    FEMALE,
    @Schema(description = "Noma'lum")
    UNKNOWN
}
