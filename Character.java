import java.sql.*;
import java.util.ArrayList;

public class Character  {

    private Statement s;
    private Connection c;

    public Character(Statement s, Connection c){
        this.s = s;
        this.c = c;
    }

    public void createtable() throws SQLException
    {
        s = c.createStatement();
        String sql = "CREATE TABLE Character " +
                    "(Character_Name TEXT PRIMARY KEY NOT NULL," +
                    " Account_Number TEXT NOT NULL, " +
                    " Character_Type TEXT NOT NULL, " +
                    " Level INT NOT NULL, " +
                    " ExperiencePoints INT NOT NULL," +
                    " Max_Health INT NOT NULL," +
                    " Health INT NOT NULL, " +
                    " AttackinScore INT NOT NULL," +
                    " DefenceScore INT NOT NULL," +
                    " StealthScore INT NOT NULL," +
                    " ManaScore INT," +
                    " Money_bank INT NOT NULL," +
                    " Money_wallet INT NOT NULL," +
                    " FOREIGN KEY (Account_Number) REFERENCES Player(Account_Number) ON DELETE CASCADE)";
        s.executeUpdate(sql);
        System.out.println("Character Table Created");
    }

    public void insertcharacterData(Connection c, ArrayList<String[]> combatread, ArrayList<String[]> customerread) throws SQLException {
        String sql = "INSERT INTO Character VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = c.prepareStatement(sql);
        for (int i = 0; i < customerread.size(); i++) {
            pstmt.setString(1, customerread.get(i)[6]);
            pstmt.setString(2, customerread.get(i)[0]);
            pstmt.setString(3, customerread.get(i)[7]);
            pstmt.setString(4, customerread.get(i)[8]);
            pstmt.setString(5, customerread.get(i)[9]);
            pstmt.setString(6, customerread.get(i)[10]);
            pstmt.setString(7, customerread.get(i)[11]);
            pstmt.setString(8, customerread.get(i)[12]);
            pstmt.setString(9, customerread.get(i)[13]);
            pstmt.setString(10, customerread.get(i)[14]);
            pstmt.setString(11, customerread.get(i)[15]);
            pstmt.setString(12, customerread.get(i)[16]);
            pstmt.setString(13, customerread.get(i)[17]);
            pstmt.executeUpdate();
        }
    }
}
