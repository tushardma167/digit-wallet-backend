package com.machinecoding.digitalWallet.service;

import com.machinecoding.digitalWallet.entity.AccountHolder;
import com.machinecoding.digitalWallet.repository.AccountHolderRepository;

import java.util.*;

public class DigitalWalletService {

    AccountHolderRepository accountHolderRepository;

    public DigitalWalletService(AccountHolderRepository accountHolderRepository) {
        this.accountHolderRepository = accountHolderRepository;
    }

    public void createAccount(AccountHolder accountHolder) {
        accountHolderRepository.initAccount(accountHolder);
        System.out.println("Account created for " + accountHolder.getName());
    }

    public void getOverview(){
        accountHolderRepository.getAccountInformation();
    }

    public void transferMoney(String fromName, String toName, Double transferAmount){
        Map<String, AccountHolder> map = accountHolderRepository.getHolderInfo();
        AccountHolder fromAccount = map.get(fromName);
        AccountHolder toAccount = map.get(toName);
        accountHolderRepository.updateAccount(fromAccount, toAccount, transferAmount);
    }

    public void getStatement(String accountHolderName){
        Map<String, AccountHolder> map = accountHolderRepository.getHolderInfo();
        System.out.println(map.get(accountHolderName).getName()+" "+map.get(accountHolderName).getLastTransactionType()
                +" "+map.get(accountHolderName).getLastTransactionAmount());
    }

    public void giveBonus(){
        List<AccountHolder> list = new ArrayList<>();
        Map<String, AccountHolder> accountHolderMap = accountHolderRepository.getHolderInfo();
        for(Map.Entry<String, AccountHolder> map: accountHolderMap.entrySet()){
           list.add(map.getValue());
        }
        Collections.sort(list, new TransactionComparator()
                .thenComparing(new AmountComparator())
                .thenComparing(new AmountOpeningComparator()));

        int accountSize = list.size();
        AccountHolder ac1 = list.get(accountSize-1);
        AccountHolder ac2 = list.get(accountSize-2);
        AccountHolder ac3 = list.get(accountSize-3);

        accountHolderRepository.updateBonus(ac1, ac2, ac3);

    }

    class TransactionComparator implements Comparator<AccountHolder>{

        @Override
        public int compare(AccountHolder o1, AccountHolder o2) {
            return o1.getNumberOfTransaction().compareTo(o2.getNumberOfTransaction());
        }
    }

    class AmountComparator implements Comparator<AccountHolder>{

        @Override
        public int compare(AccountHolder o1, AccountHolder o2) {
            return o1.getBalance().compareTo(o2.getBalance());
        }
    }

    class AmountOpeningComparator implements Comparator<AccountHolder>{

        @Override
        public int compare(AccountHolder o1, AccountHolder o2) {
            return o1.getAccountOpeningTime().compareTo(o2.getAccountOpeningTime());
        }
    }
}
