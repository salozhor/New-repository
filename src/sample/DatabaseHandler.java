package sample;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
    public Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?verifyServerCertificate=false" + "&useSSL=false" +
                "&requireSSL=false" + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(connectionString);
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void siginUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_LOGIN + "," + Const.USER_PASSWORD
                + "," + Const.USER_AUTO + "," + Const.USER_TIME + ")" + "VALUES(?,?,?,?)";
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            prSt.setInt(3,0);
            prSt.setInt(4, 0);

            prSt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";

         try {
             PreparedStatement prSt = getDbConnection().prepareStatement(select);
             prSt.setString(1, user.getLogin());
             prSt.setString(2, user.getPassword());

             resSet = prSt.executeQuery(); //получить
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }

         return  resSet;
    }




}
