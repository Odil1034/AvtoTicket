package uz.pdp.avtoticket.service.imp;

import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.UpdateDocumentDTO;
import uz.pdp.avtoticket.dto.response.DocumentResponseDTO;
import uz.pdp.avtoticket.mapper.DocumentMapper;
import uz.pdp.avtoticket.repository.DocumentRepository;
import uz.pdp.avtoticket.service.DocumentService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:47
 */
@Service
public class DocumentServiceImp
        extends AbstractService<DocumentRepository, DocumentMapper> implements DocumentService {

    public DocumentServiceImp(DocumentRepository repository, DocumentMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<Void> updateDocumentName(UpdateDocumentDTO dto) {
        return null;
    }

    @Override
    public Response<List<DocumentResponseDTO>> getDocumentsByUserId(Long userId) {
        return null;
    }

    @Override
    public Response<List<DocumentResponseDTO>> getDocumentsByBusId(Long busId) {
        return null;
    }

    @Override
    public Response<DocumentResponseDTO> addDocumentForUser(Long userId, String fileUrl, String fileType) {
        return null;
    }

    @Override
    public Response<DocumentResponseDTO> addDocumentForBus(Long busId, String fileUrl, String fileType) {
        return null;
    }

    @Override
    public Response<Void> deleteDocument(Long documentId) {
        return null;
    }

    @Override
    public Response<Void> updateDocumentUrl(Long documentId, String newUrl) {
        return null;
    }

    @Override
    public Response<Void> updateDocumentType(Long documentId, String newType) {
        return null;
    }

    @Override
    public Response<List<DocumentResponseDTO>> getDocumentsByTypeForUser(Long userId, String type) {
        return null;
    }

    @Override
    public Response<List<DocumentResponseDTO>> getDocumentsByTypeForBus(Long busId, String type) {
        return null;
    }

    @Override
    public Response<List<DocumentResponseDTO>> getRecentDocuments(int limit) {
        return null;
    }

    @Override
    public Response<DocumentResponseDTO> update(UpdateDocumentDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long aLong) {
        return null;
    }

    @Override
    public Response<DocumentResponseDTO> find(Long aLong) {
        return null;
    }

    @Override
    public Response<List<DocumentResponseDTO>> findAll() {
        return null;
    }
}
