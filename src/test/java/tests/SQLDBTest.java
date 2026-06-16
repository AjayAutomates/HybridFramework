package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SQLDBTest {

    @Test
    public void validateTransaction() {

        String url = "jdbc:h2:mem:testdb";
        String username = "sa";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();

            // Create table//In real time table will be already present ignore this line
            stmt.execute(
                "CREATE TABLE transactions (" +
                "transaction_id VARCHAR(20), status VARCHAR(20), amount INT)"
            );

            // Insert data//In real time data will be already present ignore this line
            stmt.execute(
                "INSERT INTO transactions VALUES ('TXN1','SUCCESS',5000)"
            );

            // Fetch data
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM transactions WHERE transaction_id='TXN1'"
            );

            if (rs.next()) {

                String txnId = rs.getString("transaction_id");
                String status = rs.getString("status");
                int amount = rs.getInt("amount");

                //Validation 1: Transaction ID
                Assert.assertEquals(txnId, "TXN1", "Transaction ID mismatch");

                // Validation 2: Status
                Assert.assertEquals(status, "SUCCESS", "Status mismatch");

                // Validation 3: Amount
                Assert.assertEquals(amount, 5000, "Amount mismatch");

                System.out.println("All field validations passed");

            } else {
                Assert.fail("No data found");
            }

            //Validation 4: Only one record exists
            ResultSet countRs = stmt.executeQuery(
                "SELECT COUNT(*) AS total FROM transactions"
            );
            countRs.next();
            int count = countRs.getInt("total");

            Assert.assertEquals(count, 1, "Record count mismatch");

            System.out.println("Record count validation passed");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test Failed");
        }
    }
}