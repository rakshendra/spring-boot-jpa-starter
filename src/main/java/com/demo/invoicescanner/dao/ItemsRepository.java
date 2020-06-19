package com.demo.invoicescanner.dao;

import com.demo.invoicescanner.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemsRepository extends CrudRepository<Item, Long> {

    List<Item> findByInvoiceId(long id);
}
