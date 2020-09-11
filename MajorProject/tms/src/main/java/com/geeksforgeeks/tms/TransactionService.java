package com.geeksforgeeks.tms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    KafkaTemplate kafkaTemplate;
    public void create(TransactionRequest transactionRequest){
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setMode(transactionRequest.getMode());
        transaction.setStatus(Status.SUCCESS.toString());
        transaction.setType(transactionRequest.getType());
        transaction.setUsername(transactionRequest.getUsername());

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setBankId(transactionRequest.getBankId());
        paymentDetails.setSource(transactionRequest.getSource());
        paymentDetails.setTransactionId(transactionRequest.getTransactionId());

        transaction.setPaymentDetails(paymentDetails);

        transactionRepository.save(transaction);
        Event event = new Event();
        event.setName(transaction.getMode()+"TRANSACTION"+transaction.getType());
        event.setUser(transaction.getUsername());
        event.setData(String.valueOf(transaction.getAmount()));
        kafkaTemplate.send("TRANSACTION", event);
    }



}
