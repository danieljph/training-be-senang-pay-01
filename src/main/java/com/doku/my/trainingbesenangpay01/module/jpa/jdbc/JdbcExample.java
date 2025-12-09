package com.doku.my.trainingbesenangpay01.module.jpa.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@SuppressWarnings("SqlNoDataSourceInspection")
public class JdbcExample
{
    static final String DB_URL = "jdbc:postgresql://localhost:5432/training_senang_pay";
    static final String USER = "postgres";
    static final String PASS = "postgres";

    public static void loadData()
    {
        var sql = "SELECT * FROM merchant WHERE client_id LIKE ? AND status = ?::MERCHANT_STATUS";

        try
        (
            var conn = DriverManager.getConnection(DB_URL, USER, PASS);
            var stmt = conn.prepareStatement(sql);
        )
        {
            stmt.setString(1, "%merchant%");
            stmt.setString(2, "ACTIVE");

            var rs = stmt.executeQuery();

            while(rs.next())
            {
                System.out.println("==============================");
                System.out.println("id            : " + rs.getInt("id"));
                System.out.println("name          : " + rs.getString("name"));
                System.out.println("client_id     : " + rs.getString("client_id"));
                System.out.println("client_secret : " + rs.getString("client_secret"));
                System.out.println("status        : " + rs.getString("status"));
                System.out.println("created_date  : " + rs.getTimestamp("created_date"));
                System.out.println("updated_date  : " + rs.getTimestamp("updated_date"));
                System.out.println("------------------------------");
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace(System.err);
        }
    }

    public static void insertData()
    {
        var sql = "INSERT INTO merchant (name, client_id, client_secret, status) VALUES (?, ?, ?, ?::MERCHANT_STATUS)";

        try(var conn = DriverManager.getConnection(DB_URL, USER, PASS))
        {
            conn.setAutoCommit(false);

            try(var stmt = conn.prepareStatement(sql))
            {
                stmt.setString(1, "Merchant " + System.currentTimeMillis());
                stmt.setString(2, "merchant-" + System.currentTimeMillis());
                stmt.setString(3, "merchant-" + System.currentTimeMillis() + "-secret");
                stmt.setString(4, "ACTIVE");

                var affectedRows = stmt.executeUpdate();
                System.out.println("Affected Rows: " + affectedRows);

                if(true)
                {
                    throw new RuntimeException("dummy-exception-to-avoid-commit");
                }

                conn.commit();
            }
            catch(SQLException ex)
            {
                conn.rollback();
                ex.printStackTrace(System.err);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace(System.err);
        }
    }

    public static void main(String[] args)
    {
        insertData();
        loadData();
    }
}
