package br.com.hospitalif.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    public String status = "Não conectado!";
    Connection conn = null;
    String user = "root";
    String pwd = "";
    String server = "localhost";
    String bdName = "hospitalFX";
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

    public boolean closeConnection() throws SQLException {
        this.conn.close();
        return false;
    }

    public void resetConnection(){
        try {
            this.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.getConnection();
    }

}
