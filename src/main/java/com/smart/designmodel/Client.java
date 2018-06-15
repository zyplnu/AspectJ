package com.smart.designmodel;

import java.sql.*;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        CarModel wcar = new WCar();
        wcar.excet();

        CarModel ocar = new OCar();
        ocar.excet();
    }

    public void testTransaction() throws SQLException {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            Statement statement = conn.createStatement();

            int rows = statement.executeUpdate("insert into t_user values(1,'tom')");

            Savepoint svpt = conn.setSavepoint("svpt1");

            rows = statement.executeUpdate("update t_user set topic_nums = topic_nums + 1" + "where user_id = 1");

            conn.commit();
        } catch (Exception e){
            conn.rollback();
        } finally {
        }
    }

}
