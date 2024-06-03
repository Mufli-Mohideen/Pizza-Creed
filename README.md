# Pizza Creed

Pizza Creed is a Java Spring Boot application for managing pizza orders, tested using Postman. The database used is MySQL.

## Getting Started

Follow these instructions to set up and run the Pizza Creed application on your local machine.

### Prerequisites

1. [Download WampServer](https://www.wampserver.com/en/).
2. Java JDK installed.
3. Maven installed.
4. Postman installed.

### Installation

1. **Download the Project:**

    - Download the ZIP file of the project from the repository.
    - Extract the ZIP file to a desired location on your computer.

2. **Run WampServer:**

    - Download and install WampServer from [WampServer](https://www.wampserver.com/en/).
    - Start WampServer.

3. **Create Database:**

    - Open phpMyAdmin from the WampServer dashboard.
    - Create a new database named `pizzacreed`.

4. **Configure the Application:**

    - Open the project in your favorite IDE.
    - Navigate to `src/main/resources/application.properties`.
    - Configure the database connection properties:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/pizzacreed
    spring.datasource.username=root
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

    Replace `your_password` with the actual password for your MySQL root user.

5. **Run the Application:**

    - Open a terminal in the project directory.
    - Run the following command to start the Spring Boot application:

    ```sh
    mvn spring-boot:run
    ```

6. **Access the Application:**

    - Open your web browser and navigate to:

    ```
    http://localhost:8080
    ```

### Testing with Postman

1. **Postman Collection:**

    - Open Postman.
    - Import the following Postman collection to test the APIs:

    [Postman Collection for Pizza Creed](https://www.postman.com/martian-zodiac-853057/workspace/pizzacreedglobal/request/31839030-2eff7ec4-4ebd-4e65-a3fe-f5a31d0c4381)

2. **Run the Requests:**

    - Use the imported collection to send requests to the endpoints defined in the Pizza Creed application.

## Contributing

If you want to contribute to this project, please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License.

---

Developed by Mufli-Mohideen.
