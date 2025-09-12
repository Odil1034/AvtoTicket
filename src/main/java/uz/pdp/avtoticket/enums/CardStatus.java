package uz.pdp.avtoticket.enums;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 22:04
 */

@Schema(description = "Plastik karta holati")
public enum CardStatus {
    @Schema(description = "Bloklanmagan")
    UNBLOCKED,
    @Schema(description = "Bloklangan")
    BLOCKED
}
