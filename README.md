🥚 Egg Poultry Management System
A Java console application for managing egg stock, worker registration, sales transactions, and secure admin/worker login using Object-Oriented Programming (OOP).  
This project simulates how small poultry businesses handle inventory, staff, and daily sales through a terminal-based system.

📌 Features

🔐 Login System  
Admin login  
Worker login using Worker ID & password  
Prevents unauthorized access  

👷 Worker Management  
Register new workers  
Admin approval of workers  
Auto-generated Worker ID  
Activate or reject worker accounts  

🥚 Egg Stock Management  
Collect eggs by size (Small, Medium, Large, XL)  
Tray & individual egg tracking  
Automatic egg total conversion (1 tray = 30 eggs)  
View real-time stock  

🧾 Sales & Transactions  
Sell eggs with stock validation  
Automatic total price calculation  
Cash and change computation  
Auto-generated Transaction ID  
Receipt printing with date  

🗂 Record Keeping  
Stores all sales transactions  
Tracks buyer name and purchased quantities  
Prevents selling if stock is insufficient  

🧰 Technologies Used

Tool / Language        Description  
Java (JDK)             Main programming language  
NetBeans / VS Code     Development Environment  
Git & GitHub           Version Control & Repository  
Console-based UI       Text-based terminal application  
OOP Concepts           Inheritance, Polymorphism, Abstraction, Encapsulation  


🔑 Default Admin Login

Username: a  
Password: s  


▶ How to Run the Program

1. Clone the repository  
git clone https://github.com/JechrianHub2005/POULTRY_PROJECT_SYSTEM.git

2. Open the project in any Java IDE  
- NetBeans  
- IntelliJ  
- Eclipse  
- VS Code  

3. Run  
MainApp.java  


📋 System Workflow

1. Start Program  
2. Choose Login Type:
   - Admin
   - Worker
   - Register Worker  
3. Newly registered workers go to Pending List  
4. Admin approves worker and sets password  
5. Approved workers can:
   - Collect eggs
   - Sell eggs
   - View stock  
6. Every transaction prints a receipt and updates stock  


🧑‍💻 OOP Concepts Applied

Inheritance – Admin and Worker extend Person  
Polymorphism – showInfo() method is overridden  
Encapsulation – Data fields are protected/private  
Abstraction – Abstract Person class  


✅ Input Validation

Numbers-only input for age, stock, and cash  
Prevents negative values  
Restricts invalid menu choices  
Ensures non-empty names and valid contact numbers  

---

📌 Sample Receipt Output

================== RECEIPT ==================  
Transaction ID : 1  
Buyer Name     : Juan  
--------------------------------------------  
| Size   | Tray   | Indiv  | Total  |  
--------------------------------------------  
| Small  | 1      | 5      | 35     |  
| Medium | 0      | 10     | 10     |  
--------------------------------------------  
Total Amount   : 345.00  
Cash           : 500.00  
Change         : 155.00  
Date           : September 04, 2025  
Thank you! Come Again!  
============================================  

👤 Author

Christian Jade Z. Gases  
Student – Object Oriented Programming  
Philippines 🇵🇭  


📜 License

This project is created for educational purposes only.  
You are free to modify and improve it for learning.
