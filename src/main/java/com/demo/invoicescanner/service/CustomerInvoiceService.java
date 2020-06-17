package com.demo.invoicescanner.service;

import com.demo.invoicescanner.entities.CustomerInvoice;

public interface CustomerInvoiceService {
    void uploadInvoice(CustomerInvoice invoice);
    CustomerInvoice getInvoice(long id);
    boolean getInvoiceStatus(long id);

}
