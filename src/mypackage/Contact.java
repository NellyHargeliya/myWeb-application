package mypackage;

/**
 * Created by Nelly on 12.06.2016.
 */

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Contact implements DBWrite {
    final String csvSplit = ";";
    private String name;
    private String surname;
    private String login;
    private String email;
    private String phoneNumber;
    List<String> listName = new LinkedList<>();
    List<String> listSurname = new LinkedList<>();
    List<String> listLogin = new LinkedList<>();
    List<String> listEmail = new LinkedList<>();
    List<String> listPhoneNumber = new LinkedList<>();

    public synchronized void addContact(String line) {

        String[] arr = line.split(csvSplit);
        setName(arr[0]);
        listName.add(arr[0]);
        setSurname(arr[1]);
        listSurname.add(arr[1]);
        setLogin(arr[2]);
        listLogin.add(arr[2]);
        setEmail(arr[3]);
        listEmail.add(arr[3]);
        setPhoneNumber(arr[4]);
        listPhoneNumber.add(arr[4]);

        writeDB();
    }

    public Contact() {
    }

    public Contact(String name, String surname, String login, String eMail, String phoneNumber) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public synchronized void writeDB() {

        Connection conn = null;
        ResultSet r = null;
        PreparedStatement stmt = null;
        try {
            System.out.println("connect!!!");
            Contact c = new Contact();

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "root");

            stmt = conn.prepareStatement("INSERT INTO Contact(NAME,SURNAME,"
                    + "LOGIN,EMAIL,PHONENUMBER) VALUES(?,?,?,?,?)");

            stmt.setString(1, getName());
            stmt.setString(2, getSurname());
            stmt.setString(3, getLogin());
            stmt.setString(4, getEmail());
            stmt.setString(5, getPhoneNumber());

            stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.getLocalizedMessage();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.getLocalizedMessage();
                }

            }
        }
    }


}
