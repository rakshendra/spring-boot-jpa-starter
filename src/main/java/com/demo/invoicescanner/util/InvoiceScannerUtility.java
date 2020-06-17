package com.demo.invoicescanner.util;

import com.demo.invoicescanner.entities.CustomerInvoice;
import com.demo.invoicescanner.entities.Item;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class InvoiceScannerUtility {

    private static final String[] sellers = {"Seller1","Seller2","Seller3","Seller4"};
    private static final String[] buyers = {"Buyer1","Buyer2","Buyer3","Buyer4"};
    private static final String[] products = {"ProductA","ProductB","ProductC","ProductD"};
    private static final String[] desc = {"It's A","It's B","It's C","It's D"};
    private static final double[] prices = {12.0,10.0,13.0,4.0};
    private static final Random random = new Random();
    private static final Path path = Paths.get(System.getProperty("java.io.tmpdir"));

    public static CustomerInvoice storeFile(MultipartFile file){
        try {
            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scanInvoice();
    }

    private static CustomerInvoice scanInvoice(){
        CustomerInvoice invoice = new CustomerInvoice();
        invoice.setSellerName(sellers[random.nextInt(sellers.length)]);
        invoice.setBuyerName(buyers[random.nextInt(buyers.length)]);
        String invoiceNumber = String.valueOf(System.currentTimeMillis());
        invoice.setInvoiceNumber(invoiceNumber);
        invoice.setInvoiceDate(new Date());
        invoice.setInvoiceStatus(false);

        List<Item> items = new ArrayList<>();
        items.add(consructItem(invoice));
        items.add(consructItem(invoice));

        invoice.setItems(items);

        return invoice;
    }

    private static Item consructItem(CustomerInvoice invoice) {
        Item item = new Item();
        int i = random.nextInt(prices.length);
        item.setProductName(products[i]);
        item.setProductDescription(desc[i]);
        item.setPrice(prices[i]);
        item.setQuantity(random.nextInt(20)+1);
        item.setInvoice(invoice);
        return item;
    }

}
