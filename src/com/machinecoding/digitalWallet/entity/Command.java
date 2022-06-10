package com.machinecoding.digitalWallet.entity;

import java.util.HashMap;

public enum Command {
    CREATE_WALLET("CreateWallet"),
    OVERVIEW("Overview"),
    TRANSFER_MONEY("TransferMoney"),
    STATEMENT("Statement"),
    EXIT("Exit"),
    OFFER2("Offer2");

    private final String command;

    Command(String c) {
        command = c;
    }

    public String toString(){
        return this.command;
    }

    private static final HashMap<String, Command> map = new HashMap<>(values().length, 1);

    static{
        for(Command c: values()){
            map.put(c.command, c);
        }
    }
    public static Command of(String name){
        return map.get(name);
    }
}
