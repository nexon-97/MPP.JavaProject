package com.services.impl;

import com.model.Transaction;
import com.dao.TransactionDAO;
import com.model.User;
import com.services.TransactionService;
import com.services.shared.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class TransactionServiceImpl extends BaseService implements TransactionService {

    @Autowired
    TransactionDAO transactionDAO;

    @Override
    public boolean addTransaction(User buyer, User seller, BigDecimal companyFine, BigDecimal payment) {
        Transaction transaction = new Transaction();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        long now = calendar.getTimeInMillis();

        Timestamp date = new Timestamp(now);

        transaction.setBuyer(buyer);
        transaction.setSeller(seller);
        transaction.setCompanyFine(companyFine);
        transaction.setPayment(payment);
        transaction.setDate(date);

        return transactionDAO.addTransaction(transaction);
    }

    @Override
    public Transaction getTransactionById(int id){
        return transactionDAO.getById(id);
    }

    @Override
    public List<Transaction> getIncomingTransactions(User user){
        return transactionDAO.getIncomingList(user);
    }

    @Override
    public List<Transaction> getOutgoingTransactions(User user){
        return transactionDAO.getOutgoingList(user);
    }

    @Override
    public List<Transaction> getTransactionsList(){
        return transactionDAO.list();
    }
}
