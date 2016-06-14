package mypackage;

/**
 * Created by Nelly on 12.06.2016.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    Connection connection;
    Statement stmt;
    private int noOfRecords;

    public ContactDAO() {
    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con = ConnectionFactory.getInstance().getConnection();
        return con;
    }

    public List<Contact> viewAllContacts(int offset, int noOfRecords) {
        String query = "select SQL_CALC_FOUND_ROWS * from contact limit_" + offset + ", " + noOfRecords;
        List<Contact> list = new ArrayList<>();
        Contact contact = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                contact = new Contact();
                contact.setName(rs.getString("name"));
                contact.setSurname(rs.getString("surname"));
                contact.setLogin(rs.getString("login"));
                contact.setEmail(rs.getString("email"));
                contact.setPhoneNumber("phonenumber");
                list.add(contact);
            }
            rs.close();
            rs = stmt.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.getMessage();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
        return list;

    }

    public int getNoOfRecords() {
        return noOfRecords;
    }

}
