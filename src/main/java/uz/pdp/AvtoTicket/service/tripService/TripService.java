package uz.pdp.AvtoTicket.service.tripService;

import uz.pdp.AvtoTicket.dto.request.create.CreateTripDTO;
import uz.pdp.AvtoTicket.dto.response.TripDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateTripDTO;
import uz.pdp.AvtoTicket.entity.trip.Trip;
import uz.pdp.AvtoTicket.service.BaseService;

public interface TripService extends BaseService<Trip, CreateTripDTO, UpdateTripDTO, TripDTO> {
}
