package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Txn;
import com.example.demo.service.TxnService;

import java.util.List;

@RestController
@RequestMapping("/txn")
public class TxnController {
    @Autowired
    private TxnService txnService;

    @PostMapping("/add")
    public ResponseEntity<Txn> addTxn(@RequestBody Txn txn) {
        Txn addTxn = txnService.addTxn(txn);
        return new ResponseEntity<Txn>(addTxn,HttpStatus.CREATED);
    }

    @GetMapping("/amount/{initialRange}/{finalRange}")
    public ResponseEntity<List<Txn>> getTxnsByAmountRange(@PathVariable Float initialRange, @PathVariable Float finalRange) {
        List<Txn> txns = txnService.getTxnsByAmountRange(initialRange, finalRange);
        if (txns.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } 
        return ResponseEntity.ok(txns);
    }

    @GetMapping("/sort/amount")
    public ResponseEntity<List<Txn>> getTxnsSortedByAmount() {
        List<Txn> txns = txnService.getTxnsSortedByAmount();
        return ResponseEntity.ok(txns);
    }
}
