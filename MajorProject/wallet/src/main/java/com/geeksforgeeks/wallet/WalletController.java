package com.geeksforgeeks.wallet;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {
    @Autowired
    WalletService walletService;
    @PostMapping("/wallet")
    void createWallet(@RequestBody WalletRequest walletRequest){
        walletService.createWallet(walletRequest.getUserId(),
                walletRequest.getCurrency());


    }

    @GetMapping("/wallet/{id}")
    Double getWallet(@PathVariable("id") long id){
        try {
            return  walletService.getBaltById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    @GetMapping("/wallet/user/{id}")
    Double getWalletByUser(@PathVariable("id") String id){
        try {
            return  walletService.getBalUserId(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

}
