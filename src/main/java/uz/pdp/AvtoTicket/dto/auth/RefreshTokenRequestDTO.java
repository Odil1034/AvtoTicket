package uz.pdp.AvtoTicket.dto.auth;

public record RefreshTokenRequestDTO(
        String username,
        String email,
        String password) {
}
