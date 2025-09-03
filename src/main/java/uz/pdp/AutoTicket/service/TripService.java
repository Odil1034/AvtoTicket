package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.request.CreateTripDTO;
import uz.pdp.AutoTicket.dto.request.UpdateTripDTO;
import uz.pdp.AutoTicket.dto.response.TripResponseDTO;
import uz.pdp.AutoTicket.entity.Trip;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:46
 */
public interface TripService
        extends GenericCruidService<Long, Trip, TripResponseDTO, CreateTripDTO, UpdateTripDTO> {
}
