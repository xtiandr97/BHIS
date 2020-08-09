/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DC;

import Core.SetUp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Christian
 */
public class DBConnection {
    private static Connection Myconnection;
    private static String line;
    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Myconnection = DriverManager.getConnection("jdbc:mysql://" + getSrvcHost() + ":3306/barangayhall", "root", "root");
        } catch (Exception e) {
        }
    }
    public static Connection getConnection() {
        return Myconnection;
    }
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void Destroy() {
        if (Myconnection != null) {
            try {
                Myconnection.close();
            } catch (Exception e) {
            }
        }
    }
    public static String getSrvcHost(){
        String FileName = (System.getProperty("user.dir") + "\\data\\config\\ipaddress.txt");
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(FileName);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                return line;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return line;
    }
    }

