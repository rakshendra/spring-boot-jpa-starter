package com.demo.invoicescanner.dao;

import com.demo.invoicescanner.entities.CustomerInvoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInvoiceRepository extends CrudRepository<CustomerInvoice, Long> {
}
