package com.demo.invoicescanner.controller;

import com.demo.invoicescanner.entities.CustomerInvoice;
import com.demo.invoicescanner.entities.Item;
import com.demo.invoicescanner.service.CustomerInvoiceService;
import com.demo.invoicescanner.util.InvoiceScannerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerInvoiceController {

    @Autowired
    private CustomerInvoiceService operations;

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadInvoice(@RequestBody MultipartFile file) {
        operations.uploadInvoice(InvoiceScannerUtility.storeFile(file));
    }

    @PostMapping(value = "/uploadTemp")
    public void uploadInvoice() {
        operations.uploadInvoice(InvoiceScannerUtility.storeFile(null));
    }

    @GetMapping(value = "/getInvoice/{id}")
    public CustomerInvoice getInvoice(@PathVariable long id) {
        return operations.getInvoice(id);
    }

    @GetMapping(value = "/getItems/{id}")
    public List<Item> getInvoiceItems(@PathVariable long id) {
        return operations.getInvoiceItems(id);
    }

    @GetMapping(value = "/getStatus/{id}")
    public boolean getInvoiceStatus(long id) {
        return operations.getInvoiceStatus(id);
    }


}
