package aplication;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null; //grab all departments in database
        ResultSet resultSet = null;

        try {
            conn = DB.getConnection(); //do the bridge between the code and the database
            st = conn.createStatement(); // uses the bridge to creat a statement
            resultSet = st.executeQuery("select * from department"); //resultSet just apply all the information the statement catch
            while(resultSet.next()){
                System.out.println(resultSet.getInt("Id") + ", " + resultSet.getString("Name")); //just shows up in terminal the filtered result
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}