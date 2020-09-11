package com.geeksforgeeks.wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {

    public Optional<Wallet> findWalletByUserid(String userid);
}
