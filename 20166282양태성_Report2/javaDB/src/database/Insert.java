package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

 
public class Insert
{
    public static void main(String args[])
    {
        Connection conn = null; 
        PreparedStatement pstm = null;  
        
        try {
            
            String quary = "INSERT INTO watch VALUES(?, ?, ?)";
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/opentutorials?serverTimezone=UTC", "root","didxotjd0");
            pstm = conn.prepareStatement(quary);
            
            pstm.setInt(1, 500);
            pstm.setInt(2, 4);
            pstm.setInt(3, 100);
            
            int success = pstm.executeUpdate();
            
            if(success > 0)
                System.out.println("데이터 입력 성공");
            else
                System.out.println("데이터 입력 실패");
         
        }
         catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
