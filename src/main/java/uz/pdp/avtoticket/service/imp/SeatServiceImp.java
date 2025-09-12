package uz.pdp.avtoticket.service.imp;

import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.mapper.SeatMapper;
import uz.pdp.avtoticket.repository.SeatRepository;
import uz.pdp.avtoticket.service.SeatService;
import uz.pdp.avtoticket.service.markers.AbstractService;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:57
 */
@Service
public class SeatServiceImp extends AbstractService<SeatRepository, SeatMapper> implements SeatService {
}
