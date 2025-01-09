<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Total Transactions</title>
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
        h1, h2 {
            text-align: center;
            color: #007BFF;
        }
        form {
            display: flex;
            flex-direction: column;
            margin-bottom: 20px;
        }
        input[type="text"] {
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        button {
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #007BFF;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0056b3;
        }
        .total {
            font-size: 24px;
            font-weight: bold;
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to ATM Cards</h1>
        <form action="CardController" method="get">
            <input type="text" placeholder="Card Number" id="cardNumber" name="cardNumber" required>
            <input type="text" placeholder="Transaction Type" id="transactionType" name="transactionType" required>
            <button type="submit">Get All Transactions</button>
        </form>
        
        <h2>Total Amount:</h2>
        <div class="total">
            <%
                double total = (double) request.getAttribute("total");
            %>
            <p><%= total != 0 ? total : "0.00" %></p>
        </div>
        
        <form action="CardController" method="post">
            <button type="submit">Create Transactions</button>
        </form>
    </div>
</body>
</html>
