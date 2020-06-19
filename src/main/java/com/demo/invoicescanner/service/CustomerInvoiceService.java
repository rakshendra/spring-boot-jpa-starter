package com.demo.invoicescanner.service;

import com.demo.invoicescanner.entities.CustomerInvoice;
import com.demo.invoicescanner.entities.Item;

import java.util.List;

public interface CustomerInvoiceService {
    void uploadInvoice(CustomerInvoice invoice);
    CustomerInvoice getInvoice(long id);
    List<Item> getInvoiceItems(long id);
    boolean getInvoiceStatus(long id);

}
