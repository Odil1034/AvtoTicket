package uz.pdp.avtoticket.enums;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:38
 */
@Schema(description = "Davlatlar nomlari")
public enum CountryNames {
    @Schema(description = "O'zbekiston")
    UZBEKISTAN,
    @Schema(description = "Qozog'iston")
    KAZAKHSTAN,
    @Schema(description = "Qizg'iziston")
    KYRGYZSTAN,
    @Schema(description = "Tojikiston")
    TAJIKISTAN,
    @Schema(description = "Turkmaniston")
    TURKMENISTAN,
    @Schema(description = "Afg'oniston")
    AFGHANISTAN,
    @Schema(description = "Rossiya")
    RUSSIAN,
    @Schema(description = "Xitoy")
    CHINA,
    @Schema(description = "Hindiston")
    INDIA
}
