package ru.netology.data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    private static final String DB_url = System.getProperty("DB_url");
    private static final String DB_user = System.getProperty("DB_user");
    private static final String DB_password = System.getProperty("DB_password");

    public static void clearTables() {
        val deletePaymentEntity = "DELETE FROM payment_entity";
        val deleteCreditEntity = "DELETE FROM credit_request_entity";

        val runner = new QueryRunner();
        try (val conn = DriverManager.getConnection(
                DB_url, DB_user, DB_password)
        ) {
            runner.update(conn, deletePaymentEntity);
            runner.update(conn, deleteCreditEntity);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public static String getPaymentStatus() throws SQLException {
        String statusSQL = "SELECT status FROM payment_entity";
        return getStatus(statusSQL);
    }

    public static String getCreditStatus() throws SQLException {
        String statusSQL = "SELECT status FROM payment_entity";
        return getStatus(statusSQL);
    }

    private static String getStatus(String query) throws SQLException {
        String status = "";
        val runner = new QueryRunner();
        try
                (val conn = DriverManager.getConnection(
                        DB_url, DB_user, DB_password)
                ) {

            val result = runner.query(conn, query, new ScalarHandler<String>());
            System.out.println(result);
            return result;
        }

    }
}

