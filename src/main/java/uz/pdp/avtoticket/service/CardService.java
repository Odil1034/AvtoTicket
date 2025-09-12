package uz.pdp.avtoticket.service;

import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.card.CreateCardDTO;
import uz.pdp.avtoticket.dto.request.card.UpdateCardDTO;
import uz.pdp.avtoticket.dto.response.card.CardResponseDTO;
import uz.pdp.avtoticket.entity.Card;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:22
 */
public interface CardService
        extends GenericCruidService<Long, Card, CardResponseDTO, CreateCardDTO, UpdateCardDTO> {

    // karta ma'lumotlarini tekshirish (raqam formati, expire date)
    boolean validateCard(CreateCardDTO dto);

    // userning barcha kartalari
    Response<List<CardResponseDTO>> getUserCards(@NotNull Long userId);

    // sms yoki email orqali kod yuborish
    Response<Boolean> sendVerificationCode(Long cardId);

    // kartani tasdiqlash
    Response<Boolean> verifyCard(Long cardId, String code);

    // kartani blocklash/unblocklash
    Response<Boolean> blockCard(Long cardId);
    Response<Boolean> unblockCard(Long cardId);

    // default karta belgilash
    Response<Boolean> setDefaultCard(Long userId, Long cardId);

}
