package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.request.UpdateDocumentDTO;
import uz.pdp.AutoTicket.dto.response.DocumentResponseDTO;
import uz.pdp.AutoTicket.entity.Document;
import uz.pdp.AutoTicket.service.markers.GenericQueryService;
import uz.pdp.AutoTicket.service.markers.GenericUDService;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:48
 */
public interface DocumentService
        extends GenericUDService<Long, Document, UpdateDocumentDTO, DocumentResponseDTO>,
        GenericQueryService<Long, Document, DocumentResponseDTO> {

    void updateDocumentName(UpdateDocumentDTO dto);
}
