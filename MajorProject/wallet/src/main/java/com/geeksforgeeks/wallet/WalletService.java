package com.geeksforgeeks.wallet;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    WalletRepository walletRepository;

    public void createWallet(String userId, String curr){
        Wallet wallet = new Wallet();
        wallet.setUserid(userId);
        wallet.setBalance(0.0);
        wallet.setCurrency(curr);
        walletRepository.save(wallet);
    }
    public void addAmountById(long id, double amount) throws NotFoundException {
       Wallet wallet =  walletRepository.findById(id)
               .orElseThrow(()-> new NotFoundException("Wallet not found"));
       Double prevBal = wallet.getBalance();
       Double newBal = prevBal+amount;
       wallet.setBalance(newBal);

       walletRepository.save(wallet);
    }

    @KafkaListener(topics = "TRANSACTION", groupId = "wallet")
    public void addAmountUserId(Event event) throws NotFoundException {
        if(event.getName().equalsIgnoreCase("WALLET"+"TRANSACTION"+"ADD")){
            Wallet wallet =  walletRepository.findWalletByUserid(event.getUser())
                    .orElseThrow(()-> new NotFoundException("Wallet not found"));
            Double prevBal = wallet.getBalance();
            Double newBal = prevBal+Double.parseDouble(
                    event.getData());
            wallet.setBalance(newBal);

            walletRepository.save(wallet); }

    }

    @KafkaListener(topics = "TRANSACTION", groupId = "wallet2")
    public void deductAmountById(Event event) throws NotFoundException, BadReequestException {
        if(event.getName().equalsIgnoreCase("WALLET"+"TRANSACTION"+"SUB")){
            Wallet wallet =  walletRepository.findWalletByUserid(event.getUser())
                    .orElseThrow(()-> new NotFoundException("Wallet not found"));
            Double amount = Double.parseDouble(
                    event.getData());
            if(wallet.getBalance()<amount)
                throw new BadReequestException("Invalid Transaction");

            Double prevBal = wallet.getBalance();
            Double newBal = prevBal-amount;
            wallet.setBalance(newBal);

            walletRepository.save(wallet);

        }


    }

    public void deductAmountUserId(String id, double amount) throws BadReequestException, NotFoundException {
        Wallet wallet =  walletRepository.findWalletByUserid(id)
                .orElseThrow(()-> new NotFoundException("Wallet not found"));
        if(wallet.getBalance()<amount)
            throw new BadReequestException("Invalid Transaction");
        Double prevBal = wallet.getBalance();

        Double newBal = prevBal+amount;
        wallet.setBalance(newBal);

        walletRepository.save(wallet);


    }

    public Double getBaltById(long id) throws NotFoundException {
        Wallet wallet =  walletRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Wallet not found"));

        return wallet.getBalance();
    }

    public Double getBalUserId(String id) throws NotFoundException {
        Wallet wallet =  walletRepository.findWalletByUserid(id)
                 .orElseThrow(()-> new NotFoundException("Wallet not found"));
        return wallet.getBalance();
    }
}
