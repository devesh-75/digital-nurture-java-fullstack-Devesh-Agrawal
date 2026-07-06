-- Scenario 1: GenerateMonthlyStatements
SET SERVEROUTPUT ON;

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID, c.Name, t.TransactionID, t.Amount, t.TransactionType, t.TransactionDate
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');
BEGIN
    FOR stmt_rec IN GenerateMonthlyStatements LOOP
        DBMS_OUTPUT.PUT_LINE('Statement - Customer: ' || stmt_rec.Name ||
                              ', Transaction: ' || stmt_rec.TransactionType ||
                              ', Amount: ' || stmt_rec.Amount ||
                              ', Date: ' || TO_CHAR(stmt_rec.TransactionDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/

-- Scenario 2: ApplyAnnualFee
DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance FROM Accounts FOR UPDATE OF Balance;

    v_fee CONSTANT NUMBER := 25;
BEGIN
    FOR acc_rec IN ApplyAnnualFee LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee, LastModified = SYSDATE
        WHERE CURRENT OF ApplyAnnualFee;

        DBMS_OUTPUT.PUT_LINE('Annual fee deducted from AccountID: ' || acc_rec.AccountID);
    END LOOP;

    COMMIT;
END;
/

-- Scenario 3: UpdateLoanInterestRates
DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate FROM Loans FOR UPDATE OF InterestRate;

    v_policy_increase CONSTANT NUMBER := 0.5;
BEGIN
    FOR loan_rec IN UpdateLoanInterestRates LOOP
        UPDATE Loans
        SET InterestRate = InterestRate + v_policy_increase
        WHERE CURRENT OF UpdateLoanInterestRates;

        DBMS_OUTPUT.PUT_LINE('Updated InterestRate for LoanID: ' || loan_rec.LoanID);
    END LOOP;

    COMMIT;
END;
/
