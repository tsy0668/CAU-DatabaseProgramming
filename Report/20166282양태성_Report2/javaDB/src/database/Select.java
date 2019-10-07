package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 
public class Select
{
    public static void main(String args[])
    {
        Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;
        
        
        try {
            
            String quary = "SELECT movie.name, watch.watch_time FROM movie,watch WHERE id = ? AND movie.iden_num = watch.iden_num";
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/opentutorials?serverTimezone=UTC", "root","didxotjd0");
            pstm = conn.prepareStatement(quary);
            
            pstm.setInt(1, 100);

            rs = pstm.executeQuery();

            while(rs.next()){
                String name = rs.getString(1);
                int watch_time = rs.getInt(2);

                System.out.println(name + " " + watch_time);
            }
         
        }
         catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}