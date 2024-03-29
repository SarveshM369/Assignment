package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Txn;
import com.example.demo.repository.TxnRepository;
import com.example.demo.service.TxnService;

import java.util.List;

@Service
public class TxnServiceImpl implements TxnService {
    @Autowired
    private TxnRepository txnRepository;

    @Override
    public Txn addTxn(Txn txn) {
        if (txn.getAmount() >= 0) {
        	return txnRepository.save(txn);
        }
        return null;
    }

    @Override
    public List<Txn> getTxnsByAmountRange(Float initialRange, Float finalRange) {
        return txnRepository.findByAmountBetween(initialRange, finalRange);
    }

    @Override
    public List<Txn> getTxnsSortedByAmount() {
        return txnRepository.findAllByOrderByAmountAsc();
    }
}