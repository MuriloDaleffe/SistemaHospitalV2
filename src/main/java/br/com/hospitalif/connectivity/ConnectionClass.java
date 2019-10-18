package br.com.hospitalif.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    public String status = "Não conectado!";
    Connection conn = null;
    String user = "root";
    String pwd = "";
    String server = "localhost";
    String bdName = "lp2_sistemahospital";
    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://" + server + ":3306/" + bdName;

    public Connection getConnection(){
        try {
            Class.forName(this.driverName);
            this.conn = DriverManager.getConnection(url, user, pwd);
            if (conn != null){
                this.status = "STATUS --> Conectado com Sucesso";
            }else{
                this.status = "STATUS --> Ainda não conectado!";
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.conn;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void resetConnection(){
        this.closeConnection();
        this.getConnection();
    }



}
