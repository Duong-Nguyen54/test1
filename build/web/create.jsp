<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Transaction"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert Transaction</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #007BFF;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin: 10px 0 5px;
        }
        input[type="text"],
        input[type="number"],
        select {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        input[type="submit"] {
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #007BFF;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Insert Transaction</h1>
        <form action="insertTransaction" method="post">
            <label for="card_number">Card Number:</label>
            <input type="text" id="card_number" name="card_number" value="${transaction.cardNumber}" required>
            
            <label for="transaction_date">Transaction Date:</label>
            <input type="text" id="transaction_date" name="transaction_date" placeholder="YYYY-MM-DD HH:MM:SS" required>
            
            <label for="amount">Amount:</label>
            <input type="number" step="0.01" id="amount" name="amount" value="${transaction.amount}" required>
            
            <label for="transaction_type">Transaction Type:</label>
            <select id="transaction_type" name="transaction_type" required>
                <option value="withdrawal" ${transaction.transactionType == 'withdrawal' ? 'selected' : ''}>Withdrawal</option>
                <option value="deposit" ${transaction.transactionType == 'deposit' ? 'selected' : ''}>Deposit</option>
                <option value="transfer" ${transaction.transactionType == 'transfer' ? 'selected' : ''}>Transfer</option>
            </select>
            
            <input type="submit" value="Insert Transaction">
        </form>
    </div>

    <script>
        window.onload = function() {
            
            var msg = '${msg != null ? msg : ""}';
            if (msg) {
                alert(msg); 
            }
        };
    </script>
</body>
</html>
