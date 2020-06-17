package com.demo.invoicescanner.dao;

import com.demo.invoicescanner.entities.CustomerInvoice;
import com.demo.invoicescanner.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Item, Long> {
}
