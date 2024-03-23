package services;

import Models.Ticket;

public interface TicketService {

    public Ticket generateTicket(int gateId, String vehicleNumber, String vehicleType) throws Exception;

    public Ticket getTicketById(int ticketId);
}
