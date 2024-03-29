package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Txn;

public interface TxnService {
    Txn addTxn(Txn txn);
    List<Txn> getTxnsByAmountRange(Float initialRange, Float finalRange);
    List<Txn> getTxnsSortedByAmount();
}
