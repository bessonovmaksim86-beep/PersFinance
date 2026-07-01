package ru.productstar.servlets.model;

public class Transaction {
    private String name;
    private int sum;
    private TransactionType type;

    public Transaction(String name, int sum, TransactionType type) {
        this.name = name;
        this.sum = sum;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public TransactionType getType() {
        return type;
    }
}