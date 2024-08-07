import java.sql.*;
import java.util.ArrayList;

public class Player  
{

    private Statement s;
    private Connection c;

    public Player(Statement s, Connection c)
    {
        this.s = s;
        this.c = c;
    }


    public void createtable() throws SQLException
    {
        s = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS Player " +
                    "(Account_Number INT PRIMARY KEY NOT NULL," +
                    " forename TEXT NOT NULL, " +
                    " surname TEXT NOT NULL, " +
                    " email_address TEXT NOT NULL, " +
                    " Character_Name TEXT NOT NULL, " +
                    " FOREIGN KEY(Character_Name) REFERENCES Character(Character_Name))";
        s.executeUpdate(sql);
        System.out.println("Player Table Created");
    }

    public void insertplayerData(Connection c, ArrayList<String[]> combatread, ArrayList<String[]> customerread) throws SQLException 
    {
        String sql = "INSERT INTO Player VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = c.prepareStatement(sql);
        for (int i = 1; i < customerread.size(); i++) 
        {
            try{
            pstmt.setString(1, customerread.get(i)[0]);
            pstmt.setString(2, customerread.get(i)[1]);
            pstmt.setString(3, customerread.get(i)[2]);
            pstmt.setString(4, customerread.get(i)[3]);
            pstmt.setString(5, customerread.get(i)[6]);
            pstmt.executeUpdate();
            }catch ( SQLException e ) 
                {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                } 
        }
    }

}
