# Point of Sales
<br>
Overview
<br>
Sales POS and Print Bill is a Java-based Point of Sale (POS) system for managing sales transactions. The application allows users to input product details, calculate total amounts, and print a bill for the customer. It features a graphical user interface (GUI) built using Swing and connects to a MySQL database to retrieve product information.
<br>
<br>
Features: -
<br>
Product Lookup: Search for products by code and retrieve product name and price
<br>
Sales Entry: Add products to a sales list with quantity and calculate the total amount.
<br>
Bill Generation: Print a bill with a list of purchased items, total, payment amount, and balance.
<br>
User-Friendly Interface: Easy-to-use interface with intuitive controls
<br>
<br>
Requirements: -
<br>
Java Development Kit (JDK): Ensure you have JDK 8 or higher installed.
<br>
MySQL Database: A MySQL database to store product details.
<br>
JDBC Driver: MySQL JDBC driver to connect Java application with the MySQL database.
<br>
<br>
Database Setup: -
<br>
Ensure MySQL is installed and running.
<br>
Create a database named salespos and a table product with columns for product code, name, and price.
<br>
Populate the product table with sample data for testing
<br>
<br>
Configure Database Connection: -
<br>
The application uses the MySQL JDBC driver to connect to the database. Ensure the JDBC driver is included in your project's classpath.
<br>
<br>
Running the Application: -
<br>
You can run the application by executing the pos class. Ensure you have a Java IDE or use the command line.
<br>
<br>
Usage : -
<br>
Product Code Entry: Enter the product code in the text field and press Enter. The product name and price will be auto-filled if the product exists.
<br>
Quantity and Amount: Enter the quantity and the application will calculate the amount.
<br>
Add Product: Click on the "ADD" button to add the product to the sales list.
<br>
Print Bill: After adding all products, enter the payment amount and click "PrintBill" to generate and display the bill.
<br>
<br>
Troubleshooting: -
<br>
Ensure the database is running and the connection details are correct.
<br>
Verify the MySQL JDBC driver is included in the project dependencies.
<br>
Check for any exceptions in the console and ensure all required fields are filled.
<br>
<br>
Contributing: -
<br>
Contributions are welcome! Please fork the repository and submit a pull request with any improvements or bug fixes.
<br>
<br>
Contact
<br>
For any questions or support, please contact numarahamath@gmail.com
<br>
<br>
