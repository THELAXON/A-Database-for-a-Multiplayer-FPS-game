import java.sql.*;
import java.util.ArrayList;

public class Player  {

    private Statement s;
    private Connection c;

    public Player(Statement s, Connection c){
        this.s = s;
        this.c = c;
    }


    public void createtable() throws SQLException
    {
        s = c.createStatement();
        String sql = "CREATE TABLE Player " +
                    "(Account_Number INT PRIMARY KEY NOT NULL," +
                    " forename TEXT NOT NULL, " +
                    " surname TEXT NOT NULL, " +
                    " email_address TEXT NOT NULL," +
                    " Character_CreationDate TEXT NOT NULL, " +
                    " Character_Expiry_Date TEXT)";
        s.executeUpdate(sql);
        System.out.println("Player Table Created");
    }

    public void insertplayerData(Connection c, ArrayList<String[]> combatread, ArrayList<String[]> customerread) throws SQLException {
    String sql = "INSERT INTO Player VALUES (?,?,?,?,?,?)";
    PreparedStatement pstmt = c.prepareStatement(sql);
    for (int i = 0; i < customerread.size(); i++) 
    {
        pstmt.setString(1, customerread.get(i)[0]);
        pstmt.setString(2, customerread.get(i)[1]);
        pstmt.setString(3, customerread.get(i)[2]);
        pstmt.setString(4, customerread.get(i)[3]);
        pstmt.setString(5, customerread.get(i)[4]);
        pstmt.setString(6, customerread.get(i)[5]);
        pstmt.executeUpdate();
    }
    }

}
