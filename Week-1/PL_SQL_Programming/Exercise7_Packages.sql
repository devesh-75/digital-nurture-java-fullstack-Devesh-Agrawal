-- Scenario 1: CustomerManagement package
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer (
        p_customerid IN NUMBER,
        p_name       IN VARCHAR2,
        p_dob        IN DATE,
        p_balance    IN NUMBER
    );

    PROCEDURE UpdateCustomerDetails (
        p_customerid IN NUMBER,
        p_name       IN VARCHAR2,
        p_balance    IN NUMBER
    );

    FUNCTION GetCustomerBalance (
        p_customerid IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer (
        p_customerid IN NUMBER,
        p_name       IN VARCHAR2,
        p_dob        IN DATE,
        p_balance    IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customerid, p_name, p_dob, p_balance, SYSDATE);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error: Customer already exists');
    END AddCustomer;

    PROCEDURE UpdateCustomerDetails (
        p_customerid IN NUMBER,
        p_name       IN VARCHAR2,
        p_balance    IN NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name, Balance = p_balance
        WHERE CustomerID = p_customerid;
        COMMIT;
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance (
        p_customerid IN NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customerid;

        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END GetCustomerBalance;
END CustomerManagement;
/

-- Scenario 2: EmployeeManagement package
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee (
        p_employeeid IN NUMBER,
        p_name       IN VARCHAR2,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2
    );

    PROCEDURE UpdateEmployeeDetails (
        p_employeeid IN NUMBER,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2
    );

    FUNCTION CalculateAnnualSalary (
        p_employeeid IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee (
        p_employeeid IN NUMBER,
        p_name       IN VARCHAR2,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employeeid, p_name, p_position, p_salary, p_department, SYSDATE);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error: Employee already exists');
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails (
        p_employeeid IN NUMBER,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Position = p_position, Salary = p_salary, Department = p_department
        WHERE EmployeeID = p_employeeid;
        COMMIT;
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary (
        p_employeeid IN NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employeeid;

        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END CalculateAnnualSalary;
END EmployeeManagement;
/

-- Scenario 3: AccountOperations package
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount (
        p_accountid   IN NUMBER,
        p_customerid  IN NUMBER,
        p_accounttype IN VARCHAR2,
        p_balance     IN NUMBER
    );

    PROCEDURE CloseAccount (
        p_accountid IN NUMBER
    );

    FUNCTION GetTotalBalance (
        p_customerid IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount (
        p_accountid   IN NUMBER,
        p_customerid  IN NUMBER,
        p_accounttype IN VARCHAR2,
        p_balance     IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_accountid, p_customerid, p_accounttype, p_balance, SYSDATE);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error: Account already exists');
    END OpenAccount;

    PROCEDURE CloseAccount (
        p_accountid IN NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_accountid;
        COMMIT;
    END CloseAccount;

    FUNCTION GetTotalBalance (
        p_customerid IN NUMBER
    ) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0) INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customerid;

        RETURN v_total;
    END GetTotalBalance;
END AccountOperations;
/
