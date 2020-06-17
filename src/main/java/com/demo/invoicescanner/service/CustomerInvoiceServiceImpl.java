package com.demo.invoicescanner.service;

import com.demo.invoicescanner.dao.CustomerInvoiceRepository;
import com.demo.invoicescanner.dao.ItemsRepository;
import com.demo.invoicescanner.entities.CustomerInvoice;
import com.demo.invoicescanner.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerInvoiceServiceImpl implements CustomerInvoiceService {

    @Autowired
    private CustomerInvoiceRepository customerInvoiceRepository;
    @Autowired
    private ItemsRepository itemsRepository;


    @Override
    public void uploadInvoice(CustomerInvoice invoice) {
        customerInvoiceRepository.save(invoice);
    }

    @Override
    public CustomerInvoice getInvoice(long id) {
        Optional<CustomerInvoice> invoice = customerInvoiceRepository.findById(id);
        //Optional<List<Item>> items = itemsRepository.findAll();
        return invoice.get();
    }

    @Override
    public boolean getInvoiceStatus(long id) {
        Optional<CustomerInvoice> invoice = customerInvoiceRepository.findById(id);
        return invoice.get().isInvoiceStatus();
    }
}
