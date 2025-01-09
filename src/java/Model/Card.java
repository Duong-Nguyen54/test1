    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Card {
    private String cardNumber;
    private String accountNumber;
    private String customerName;
    private String expirationDate;
    private boolean isBlocked;

    public Card() {
    }

    public Card(String cardNumber, String accountNumber, String customerName, String expirationDate, boolean isBlocked) {
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.expirationDate = expirationDate;
        this.isBlocked = isBlocked;
    }

    // Getters và Setters
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "Card{" + "cardNumber=" + cardNumber + ", accountNumber=" + accountNumber + ", customerName=" + customerName + ", expirationDate=" + expirationDate + ", isBlocked=" + isBlocked + '}';
    }
    
}

