package uz.pdp.avtoticket.enums;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Baxriddinov Odiljon
 * @since 01/09/2025 14:43
 */
@Schema(description = "Avtobus holati")
public enum BusStatus {
    @Schema(description = "Ta'mirda")
    MAINTENANCE,
    @Schema(description = "Foydalanish imkoni mavjud")
    AVAILABILITY
}