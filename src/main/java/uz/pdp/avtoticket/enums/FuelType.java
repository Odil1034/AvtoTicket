package uz.pdp.avtoticket.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Avtobusning yoqilg'i turlari")
public enum FuelType {
    @Schema(description = "Dizel yoqilg'i")
    DIESEL,

    @Schema(description = "Siqilgan gaz (metan/propangaz)")
    COMPRESSED_GAS,

    @Schema(description = "Elektr energiyasi")
    ELECTRIC,

    @Schema(description = "Noma'lum yoqilg'i turi")
    UNKNOWN
}
