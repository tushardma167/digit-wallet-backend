package com.machinecoding.digitalWallet;

import com.machinecoding.digitalWallet.entity.AccountHolder;
import com.machinecoding.digitalWallet.entity.Command;
import com.machinecoding.digitalWallet.repository.AccountHolderRepository;
import com.machinecoding.digitalWallet.service.DigitalWalletService;

import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        AccountHolderRepository accountHolderRepository = new AccountHolderRepository();
        DigitalWalletService digitalWalletService = new DigitalWalletService(accountHolderRepository);
        Integer accountOrder = 0;
        while(true){
            Scanner in = new Scanner(System.in);
            Command type = Command.of(in.next());
            accountOrder++;
            switch (type) {
                case CREATE_WALLET:
                    String name = in.next();
                    Double amount = in.nextDouble();
                    digitalWalletService.createAccount(new AccountHolder(name, amount, 1, "CREDIT", amount, accountOrder));
                    break;
                case OVERVIEW:
                    digitalWalletService.getOverview();
                    break;
                case TRANSFER_MONEY:
                    digitalWalletService.transferMoney(in.next(), in.next(), in.nextDouble());
                    break;
                case STATEMENT:
                    digitalWalletService.getStatement(in.next());
                    break;
                case OFFER2:
                    digitalWalletService.giveBonus();
                    break;
                case EXIT: return;
            }
        }
    }
}
