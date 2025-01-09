/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Transaction {
    private int id;
    private Card cardNumber;
    private String transactionDate; 
    private double amount;
    private String transactionType;

    public Transaction() {
    }

    public Transaction(int id, Card cardNumber, String transactionDate, double amount, String transactionType) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.transactionDate = transactionDate; 
        this.amount = amount;
        this.transactionType = transactionType;
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Card getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Card cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getTransactionDate() {
        return transactionDate; 
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate; 
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", cardNumber=" + cardNumber + ", transactionDate=" + transactionDate + ", amount=" + amount + ", transactionType=" + transactionType + '}';
    }
    
}


