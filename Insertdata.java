
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ARCHITHA
 */
public class Insertdata {
      public static void main(String[] args)   {
        try {
            // TODO code application logic here
           DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@omega:1521:CSE1", "axh7433", "Apple123");
            
            BufferedReader in=new BufferedReader( new FileReader("EMPLOYEE.txt"));
            BufferedReader in1=new BufferedReader( new FileReader("DEPARTMENT.txt"));
            BufferedReader in2=new BufferedReader( new FileReader("DEPT_LOCATIONS.txt"));
            BufferedReader in3=new BufferedReader( new FileReader("PROJECT.txt"));
            BufferedReader in4=new BufferedReader( new FileReader("WORKS_ON.txt"));
            BufferedReader in5=new BufferedReader( new FileReader("DEPENDENT.txt"));
            
            String line="",line1="",line2="",line3="",line4="",line5="";
            
           //employee table
            while( (line=in.readLine())!=null)
            {
                //'James', 'E', 'Jordan', '888665151', '10-NOV-1927', '450 Stone,Houston,TX', 'M', 55000, null, 1
                
                line=line.replace("'","");
                String[] temp=line.split( ", ");
                String query="insert into EMPLOYEE1 values('"+temp[0]+"','"+temp[1]+"','"+temp[2]+"','"+Integer.parseInt(temp[3])+"','"+temp[4]+"','"+temp[5]+"','"+temp[6]+"','"+Integer.parseInt(temp[7])+"','"+temp[8]+"','"+Integer.parseInt(temp[9])+"')";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.executeUpdate(query);
                stmt.close();
           
            }
            
            //department table
             while( (line1=in1.readLine())!=null)
            {
                
                //'Research', 5, '333445555', '22-MAY-1978'
                
                line1=line1.replace("'","");
                String[] temp=line1.split( ", ");
                String query="insert into DEPARTMENT1 values('"+temp[0]+"','"+Integer.parseInt(temp[1])+"','"+temp[2]+"','"+temp[3]+"')";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.executeUpdate(query);
                stmt.close();
            }
            
            //department location
            while( (line2=in2.readLine())!=null)
            {
                //1, 'Houston'
                
                line2=line2.replace("'","");
                String[] temp=line2.split( ", ");
                String query="insert into DEPT_LOCATIONS1 values('"+Integer.parseInt(temp[0])+"','"+temp[1]+"')";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.executeUpdate(query);
                stmt.close();
          
            }
            
            //project
            while( (line3=in3.readLine())!=null)
            {
                //'EntityAnnot', 4, 'Houston', 5
                
                line3=line3.replace("'","");
                String[] temp=line3.split( ", ");
                String query="insert into PROJECT1 values('"+temp[0]+"','"+Integer.parseInt(temp[1])+"','"+temp[2]+"','"+Integer.parseInt(temp[3])+"')";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.executeUpdate(query);
                stmt.close();
           
               
            }
            
            //workson
            while( (line4=in4.readLine())!=null)
            {
                //'123456789', 5, 32.5
                
                line4=line4.replace("'","");
                String[] temp=line4.split( ", ");
                String query="insert into WORKS_ON1 values('"+temp[0]+"','"+Integer.parseInt(temp[1])+"','"+Float.parseFloat(temp[2])+"')";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.executeUpdate(query);
                stmt.close();
           
                
            }
            
            //dependent
            while( (line5=in5.readLine())!=null)
            {
                //'888665151', 'Mary Alice', 'F', '10-NOV-1924', 'Spouse'
                
                line5=line5.replace("'","");
                String[] temp=line5.split( ", ");
                String query="insert into DEPENDENT1 values('"+temp[0]+"','"+temp[1]+"','"+temp[2]+"','"+temp[3]+"','"+temp[4]+"')";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.executeUpdate(query);
                stmt.close();
           
               
            }
            in5.close();
            in1.close();
            in2.close();
            in3.close();
            in4.close();
            conn.close();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
