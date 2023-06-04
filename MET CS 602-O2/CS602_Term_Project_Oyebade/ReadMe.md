## CS602 - Term Project

This project serves as my term project for the CS602 Server-Side Web Development course. This project emphasizes server-side functionality, consists of PHP and MySQL with a little of JS. It also contains REST API endpoints of data for XML and JSON formats.


## Scope
Shop-shopping Kart is an shopping cart application designed for an online store website. The owner will have a list of products that they are selling. Each product has 
- Unique ID
- Name, 
- Color
- Description 
- Price 
- Quantity
- and etc..

The application will show the list of products and it should allow the products to be searched by name/ID's.


## Customer Interface

The customer of the application can do the following:
- Search for products by **Name** or **ID** via the search at the top.
- View the newly added products
- Order products by selecting from the imagery list of products.
    - Can specify the color and the quantity of the order
- Can view the the list of orders they made.


## The Admin Interface

The admin of the application can do the following:

- Add, update, and delete products, categories. 
- Create new accounts
- View the list of orders, the total accounts for the page, total products available and view current transactions. 


## Rest End Points

*JSON*

- http://localhost/CS602_Term_Project_Oyebade/rest.php?format=json&action=product

- http://localhost/CS602_Term_Project_Oyebade/rest.php?format=json&action=product_options&option=1

*XML*
- http://localhost/CS602_Term_Project_Oyebade/rest.php?format=xml&action=product

- http://localhost/CS602_Term_Project_Oyebade/rest.php?format=xml&action=product_options&option=1


*A little side note*

The admin login **email**: testqueen@gmail.com
The admin login **password**: admin
