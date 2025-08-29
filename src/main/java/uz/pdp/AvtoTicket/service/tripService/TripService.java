package uz.pdp.AvtoTicket.service.tripService;

import uz.pdp.AvtoTicket.dto.trip.CreateTripDTO;
import uz.pdp.AvtoTicket.dto.trip.TripResponseDTO;
import uz.pdp.AvtoTicket.dto.trip.UpdateTripDTO;
import uz.pdp.AvtoTicket.entity.trip.Trip;
import uz.pdp.AvtoTicket.service.BaseService;

public interface TripService extends BaseService<Trip, CreateTripDTO, UpdateTripDTO, TripResponseDTO> {
}
