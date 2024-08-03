package com.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.* ;

public class Table 
{
     public static void main(String[] args) 
     {
          try
          {
               // Load the driver :
               Class.forName("com.mysql.cj.jdbc.Driver");

               // creating a connection

               String url = "jdbc:mysql://localhost:3306/register" ;
               String username = "root" ;
               String password = "pratik" ; // YES

               Connection con = DriverManager.getConnection(url , username , password);

               /*
               // create query

               String q = "create table table1(tId int(20) primary key auto_increment , tName varchar(200) not null ,tCity varchar(400) ) " ;

               //create a statement 

               Statement stmt = con.createStatement();
               stmt.executeUpdate(q);         // if error is accured , directly jump into catch block 

                System.out.println("Table created in databases ");
                con.close();
                */
               
               
               
               //static data
               // create query
               String q = "insert into user(userName,userEmail,userPassword) values (?,?,?)" ;

               //get the PreparedStatement object 
               PreparedStatement prstmt = con.prepareStatement(q);

               // set the values to query
               prstmt.setString(1,"Pratik Vadaviya");
               prstmt.setString(2,"edfjnv");
               prstmt.setString(3,"rtyu");

               prstmt.executeUpdate();			// don't pass query here .

               System.out.println("inserted....");
               con.close();
               //
               
               

               /* Dynamic data
               // create query
               String q = "insert into table1(tName,tCity) values (?,?)" ;

               //get the PreparedStatement object 
               PreparedStatement prstmt = con.prepareStatement(q);

               // set the values to query
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               
               System.out.println("Enter Name : ");
               String name = br.readLine();

               System.out.println("Enter City : ");
               String city = br.readLine();

               prstmt.setString(1,name);
               prstmt.setString(2,city);

               prstmt.executeUpdate();

               System.out.println("inserted....");
               con.close();  
               */            
               
               
               /* update 
               // create query
               String q = "update table1 SET tName=? , tCity=? where tId=? " ;

               //get the PreparedStatement object 
               PreparedStatement prstmt = con.prepareStatement(q);

               // set the values to query
                
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
               System.out.println("Enter New Name : ");
               String name = br.readLine();

               System.out.println("Enter New City : ");
               String city = br.readLine();

               System.out.println("Enter student Id : ");
               int Id = Integer.parseInt(br.readLine());          //string to integer conversion



               prstmt.setString(1,name);
               prstmt.setString(2,city);
               prstmt.setInt(3, Id);

               prstmt.executeUpdate();

               System.out.println("Done....");
               con.close();
               */
               
               
               /* fetch the data
               // create query
               String q = "select * from table1  " ;

               //get the PreparedStatement object 
               PreparedStatement prstmt = con.prepareStatement(q);

               // create a statement
                Statement stmt = con.createStatement();
                ResultSet rset = stmt.executeQuery(q) ;
               
                while(rset.next())
                {
                     int id = rset.getInt(1);
                     String name = rset.getString(2);
                     String city = rset.getString(3);

                     System.out.println(id + " | " + name + " | " + city);
                }


               prstmt.executeUpdate();

               System.out.println("Done....");
               con.close();
               */
               
          }
          catch(Exception e)
          {
               e.printStackTrace();
          }
     }

     
}

