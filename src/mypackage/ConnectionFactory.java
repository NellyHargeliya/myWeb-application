package mypackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    // JDBC URL, username and password of MySQL server
    private  static ConnectionFactory instance=new ConnectionFactory();
    String url="jdbc:mysql://localhost:3306/mydbtest";
    String user= "root";
    String password= "root";
    String driverClass="com.mysql.jdbc.Driver";
    private ConnectionFactory(){
        try{
            Class.forName(driverClass);
        }catch(ClassNotFoundException ex){
            ex.getLocalizedMessage();
        }
    }
    public static ConnectionFactory getInstance(){
        return instance;
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Connection connection=DriverManager.getConnection(url, user, password);
        return connection;
    }


}
