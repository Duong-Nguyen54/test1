package Model;


import java.sql.*;

import static Model.DBinfor.DBURL;
import static Model.DBinfor.DRIVERNAME;
import static Model.DBinfor.PASSDB;
import static Model.DBinfor.USERDB;
import java.util.Stack;

/**
 *
 * @author DELL
 */
public class function {

    

    public Connection getConnect() {
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
        try {
            Connection con = DriverManager.getConnection(DBURL, USERDB, PASSDB);
            return con;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public double getTotalAmountByType(String cardNumber, String transactionType) {
        double totalAmount = 0.0;
        String sql = "SELECT SUM(amount) AS total_amount FROM Transactions WHERE card_number = ? AND transaction_type = ?";

        try (Connection connection = getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cardNumber);
            preparedStatement.setString(2, transactionType);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalAmount = resultSet.getDouble("total_amount");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return totalAmount;
    }
    public static void main(String[] args) {
        function f = new  function();
        System.out.println(f.getAllTransactions());
    }
    
    public Stack<Transaction> getAllTransactions() {
        Stack<Transaction> transactionsStack = new Stack<>();

       
        try (Connection connection = getConnect();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Transactions");
             ResultSet rs = pstmt.executeQuery()) {

           
            while (rs.next()) {
                int id = rs.getInt("id");
                String cardNumber = rs.getString("card_number");
                String transactionDate = rs.getString("transaction_date");
                double amount = rs.getDouble("amount");
                String transactionType = rs.getString("transaction_type");

                Transaction transaction = new Transaction(id, getCardByCardNumber(cardNumber), transactionDate, amount, transactionType);
                transactionsStack.push(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactionsStack;
    }
    public Card getCardByCardNumber(String cardNumber) {
        Card card = null;
        String sql = "SELECT * FROM Cards WHERE card_number = ?";

        try (Connection connection = getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cardNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String accountNumber = resultSet.getString("account_number");
                String customerName = resultSet.getString("customer_name");
                String expirationDate = resultSet.getString("expiration_date");
                boolean isBlocked = resultSet.getBoolean("is_blocked");
                card = new Card(cardNumber, accountNumber, customerName, expirationDate, isBlocked);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return card;
    }

    
    public void insertTransaction(Transaction transaction) {
        String sql = "INSERT INTO Transactions (card_number, transaction_date, amount, transaction_type,id) VALUES (?,?, ?, ?, ?)";

        try (Connection connection = getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, getCardByCardNumber(transaction.getCardNumber().getCardNumber()).getCardNumber());
            preparedStatement.setString(2, transaction.getTransactionDate());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getTransactionType());
            preparedStatement.setInt(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
}
