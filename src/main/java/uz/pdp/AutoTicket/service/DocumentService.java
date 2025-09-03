package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.UpdateDocumentDTO;
import uz.pdp.AutoTicket.dto.response.DocumentResponseDTO;
import uz.pdp.AutoTicket.entity.Document;
import uz.pdp.AutoTicket.service.markers.GenericQueryService;
import uz.pdp.AutoTicket.service.markers.GenericUDService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:48
 */
public interface DocumentService
        extends GenericUDService<Long, Document, UpdateDocumentDTO, DocumentResponseDTO>,
        GenericQueryService<Long, Document, DocumentResponseDTO> {

    // document nomini yangilash
    Response<Void> updateDocumentName(UpdateDocumentDTO dto);

    // Userning barcha hujjatlari
    Response<List<DocumentResponseDTO>> getDocumentsByUserId(Long userId);

    // Busga tegishli barcha fayllar
    Response<List<DocumentResponseDTO>> getDocumentsByBusId(Long busId);

    // Yangi fayl qo'shish (url yoki multipart file orqali)
    Response<DocumentResponseDTO> addDocumentForUser(Long userId, String fileUrl, String fileType);

    Response<DocumentResponseDTO> addDocumentForBus(Long busId, String fileUrl, String fileType);

    // Faylni o'chirish
    Response<Void> deleteDocument(Long documentId);

    // URL yoki fayl turini yangilash
    Response<Void> updateDocumentUrl(Long documentId, String newUrl);

    Response<Void> updateDocumentType(Long documentId, String newType);

    // Fayl turiga ko'ra filterlash (image, pdf, license, ... )
    Response<List<DocumentResponseDTO>> getDocumentsByTypeForUser(Long userId, String type);

    Response<List<DocumentResponseDTO>> getDocumentsByTypeForBus(Long busId, String type);

    // Oxirgi yuklangan fayllar
    Response<List<DocumentResponseDTO>> getRecentDocuments(int limit);
}
