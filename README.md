# Library Management System

In this project, I'll create a library management system applying the SOLID principles. This project will allow me to apply these principles in practical scenarios and understand how they enhance code structure and maintainability.

## Description:

Create a software system that manages a library's collection of books, allows users to borrow and return books, calculates fines for overdue books, and generates reports about the library's activities.

## Functional Requirements:

1.Book Management:

- Add new books to the library, including details like title, author, and number of pages.
- Remove books from the library.
- Update book details.

2.User Management:

- Maintain a record of library users (borrowers).
- Register new users.
- Update user information.
- Deactivate user accounts.

3.Loan Management:

- Allow users to borrow books.
- Keep track of borrowed books, due dates, and return dates.
- Calculate fines for overdue books.
- Allow users to return books.

4.Report Generation:

- Generate reports showing available books.
- Generate reports showing registered users.
- Generate reports showing borrowed books and their due dates.
- Generate reports showing users with overdue books and fines.

## Application of SOLID Principles:

1.SRP (Single Responsibility Principle):

Separate classes for book management, user management, loan management, and report generation to ensure each class has a single responsibility.

2.OCP (Open/Closed Principle):

Design classes in a way that new features (e.g., report types) can be added without modifying existing code.

3.LSP (Liskov Substitution Principle):

Ensure derived classes (e.g., specific loan types) can be substituted for base classes (e.g., loan interface) without breaking the system's behavior.

4.ISP (Interface Segregation Principle):

Create cohesive interfaces that expose only relevant methods to implementing classes.

5.DIP (Dependency Inversion Principle):

Design classes to depend on abstractions (e.g., interfaces) rather than concrete implementations.
Use dependency injection to provide implementations to classes.

Note: These are high-level requirements and principles. The actual implementation details will involve creating classes, methods, and data structures that adhere to these principles. You'll also need to decide whether to use data structures, databases, or other storage mechanisms to store book, user, and loan data.

Remember, this project is a learning opportunity, and you can adapt and expand it based on your goals and interests. As you work on it, you'll gain a deeper understanding of software design, SOLID principles, and the complexities of real-world software systems.


## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
