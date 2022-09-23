import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    public static Connection getConnection () throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/informacion",  "root", "");
    }

    public static void main(String[] args) {
        try {
            Connection con = ConnectionMySQL.getConnection();
            System.out.println("Conexion exitosa");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

