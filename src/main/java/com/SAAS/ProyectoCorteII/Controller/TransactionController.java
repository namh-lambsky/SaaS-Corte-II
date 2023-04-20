package com.SAAS.ProyectoCorteII.Controller;

import com.SAAS.ProyectoCorteII.Model.Transaction;
import com.SAAS.ProyectoCorteII.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ArrayList<Transaction>getTransactions(){
        return this.transactionService.getTransactions();
    }

    @GetMapping(path = "/{id}")
    public Transaction getTransactionById(@PathVariable int id){
        return this.transactionService.getTransactionById(id);
    }

    @PostMapping(path = "/new")
    public Transaction saveTransaction(@RequestBody Transaction transaction){
        return this.transactionService.saveTransaction(transaction);
    }

    @PutMapping(path = "/update-{id}")
    public Transaction updateTransaction(@RequestBody Transaction request,  @PathVariable int id){
        return this.transactionService.updateTransactionById(request,id);
    }

    @DeleteMapping(path = "/delete-{id}")
    public String deleteTransaction(@PathVariable int id){
        boolean isDeleted = this.transactionService.deleteTransactionById(id);
        if (isDeleted){
            return "Transaccion con el id: "+id+" fue eliminada";
        }
        else {
            return "Unexpected error: Transaction with id:"+id+" was not deleted";
        }
    }
}
