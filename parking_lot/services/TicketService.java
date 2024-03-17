package services;

import parking_lot.models.Ticket;

public interface TicketService {

    public Ticket generateTicket(int gateId, String vehicleNumber, String vehicleType) throws Exception;
}
