package controllers;

import Models.Invoice;
import dtos.GenerateTicketResponseDto;
import dtos.Response;
import dtos.ResponseStatus;
import exceptions.InvalidRequestException;
import services.InvoiceService;

public class InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public GenerateInvoiceResponseDto generateInvoice(GenerateInvoiceRequestDto requestDto){
        GenerateInvoiceResponseDto responseDto = new GenerateInvoiceResponseDto();
        try {
            if(requestDto.getTicketId() < 0){
                throw new InvalidRequestException("Ticket id can not be negative");
            }
            if(requestDto.getGateId() < 0){
                throw new InvalidRequestException("Gate id can not be negative");
            }
        } catch (Exception e){
            Response response = new Response();
            response.setStatus(ResponseStatus.FAILED);
            response.setError(e.getMessage());
            responseDto.setResponse(response);
            return responseDto;
        }

        try {
            Invoice invoice = invoiceService.generateInvoice(requestDto.getTicketId(), requestDto.getGateId());
            Response response = new Response();
            response.setStatus(ResponseStatus.SUCCESS);
            responseDto.setInvoice(invoice);
            responseDto.setResponse(response);
            return responseDto;
        } catch (Exception e){
            Response response = new Response();
            response.setStatus(ResponseStatus.FAILED);
            response.setError(e.getMessage());
            responseDto.setResponse(response);
            return responseDto;
        }

    }
}
