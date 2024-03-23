package services;

import Models.Invoice;
import exceptions.InvalidGateException;
import exceptions.InvalidTicketException;

public interface InvoiceService {
    public Invoice generateInvoice(int ticketId, int gateId) throws InvalidTicketException, InvalidGateException;
}
