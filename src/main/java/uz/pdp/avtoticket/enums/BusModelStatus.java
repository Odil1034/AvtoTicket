package uz.pdp.avtoticket.enums;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 21:16
 */

@Schema(description = "Avtobus modeli holati")
public enum BusModelStatus {

    @Schema(description = "Faol model")
    ACTIVE,

    @Schema(description = "Nofaol model")
    INACTIVE
}
