package com.machinecoding.digitalWallet.repository;

import com.machinecoding.digitalWallet.entity.AccountHolder;

import java.util.HashMap;
import java.util.Map;

public class AccountHolderRepository {

    HashMap<String, AccountHolder> holderInfo;

    public AccountHolderRepository() {
        holderInfo = new HashMap<>();
    }

    public void initAccount(AccountHolder holder) {
        holderInfo.put(holder.getName(), holder);
    }

    public void getAccountInformation() {
        for(Map.Entry<String, AccountHolder> map: holderInfo.entrySet()){
            System.out.println(map.getValue().getName()+" "+map.getValue().getBalance());
        }
    }

    public Map<String, AccountHolder> getHolderInfo(){
        return holderInfo;
    }

    public void updateAccount(AccountHolder fromAccount, AccountHolder toAccount, Double amount){
        Double balance1 = fromAccount.getBalance();
        Double balance2 = toAccount.getBalance();
        Integer trans1 = fromAccount.getNumberOfTransaction();
        Integer trans2 = toAccount.getNumberOfTransaction();
        if(balance1 < amount){
            System.out.println("Insufficient fund");
            return;
        }

        fromAccount.setBalance(balance1-amount);
        fromAccount.setNumberOfTransaction(trans1+1);
        fromAccount.setLastTransactionType("DEBIT");
        fromAccount.setLastTransactionAmount(amount);

        toAccount.setBalance(balance2+amount);
        toAccount.setNumberOfTransaction(trans2+1);
        toAccount.setLastTransactionType("CREDIT");
        toAccount.setLastTransactionAmount(amount);

        holderInfo.put(fromAccount.getName(), fromAccount);
        holderInfo.put(toAccount.getName(), toAccount);
        System.out.println("Transaction Successful");

        if(fromAccount.getBalance().equals(toAccount.getBalance())) {

            System.out.println("Offer1 Credit 10");
            balance1 = fromAccount.getBalance()+10.0;
            balance2 = toAccount.getBalance()+10.0;
            fromAccount.setBalance(balance1);
            fromAccount.setLastTransactionType("CREDIT");

            toAccount.setBalance(balance2);
            toAccount.setLastTransactionType("CREDIT");

            holderInfo.put(fromAccount.getName(), fromAccount);
            holderInfo.put(toAccount.getName(), toAccount);
        }
    }

    public void updateBonus(AccountHolder ac1, AccountHolder ac2, AccountHolder ac3){
        Double balance1 = ac1.getBalance()+10.0;
        Integer numberTrans1 = ac1.getNumberOfTransaction()+1;
        ac1.setBalance(balance1);
        ac1.setLastTransactionAmount(10.0);
        ac1.setLastTransactionType("CREDIT");
        ac1.setNumberOfTransaction(numberTrans1);

        Double balance2 = ac2.getBalance()+5.0;
        Integer numberTrans2 = ac2.getNumberOfTransaction()+1;
        ac2.setBalance(balance2);
        ac2.setLastTransactionAmount(5.0);
        ac2.setLastTransactionType("CREDIT");
        ac2.setNumberOfTransaction(numberTrans2);

        Double balance3 = ac3.getBalance()+2.0;
        Integer numberTrans3 = ac3.getNumberOfTransaction()+1;
        ac3.setBalance(balance3);
        ac3.setLastTransactionAmount(2.0);
        ac3.setLastTransactionType("CREDIT");
        ac3.setNumberOfTransaction(numberTrans3);
    }
}
