package application;

import db.DB;
import model.entities.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Program {
    public static void main(String[] args) {

        Department obj = new Department(1, "Books");
        System.out.println(obj);
    }

}

