package uz.pdp.avtoticket.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "To'lov holati")
public enum PaymentStatus {
    @Schema(description = "To'langan")
    PAID,
    @Schema(description = "To'lanishi kutilmoqda")
    PENDING,
    @Schema(description = "Muvaffaqatsiz")
    FAILED
}
