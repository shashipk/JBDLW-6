package com.geeksforgeeks.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public void create(@RequestBody TransactionRequest transactionRequest){
        transactionService.create(transactionRequest);
    }
}
