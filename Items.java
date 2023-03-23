import java.sql.*;
import java.util.ArrayList;

public class Items  {

    private Statement s;
    private Connection c;

    public Items(Statement s, Connection c){
        this.s = s;
        this.c = c;
    }

    public void createtable() throws SQLException
    {
        s = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS Items " +
                    "(Item VARCHAR(20) PRIMARY KEY NOT NULL," +
                    " Character TEXT NOT NULL, " +
                    " Item_Type TEXT NOT NULL, " +
                    " WeaponType TEXT NOT NULL," +
                    " Range INT, " +
                    " Price INT NOT NULL, " +
                    " Quantity INT NOT NULL, " +
                    " DefendScore INT, " +
                    " AttackScore INT, " +
                    " HealingScore INT, " +
                    " ManaScore INT, " +
                    " SingleUse INT, " +
                    " wearable INT, " +
                    " worn INT, " +
                    " BodyPart TEXT NOT NULL, " +
                    " Equipped INT, " +
                    " FOREIGN KEY (Character) REFERENCES Character(Character_Name) ON DELETE CASCADE)";
        s.executeUpdate(sql);
        System.out.println("Items Table Created");
    }

    public void insertitemsData(Connection c, ArrayList<String[]> itemsread, ArrayList<String[]> customerread) throws SQLException 
    {
        String sql = "INSERT OR IGNORE INTO Items VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = c.prepareStatement(sql);
            for (int i = 1; i < itemsread.size(); i++) 
            {
                pstmt.setString(1, itemsread.get(i)[1]);
                pstmt.setString(2, itemsread.get(i)[0]);
                pstmt.setString(3, itemsread.get(i)[2]);
                pstmt.setString(4, itemsread.get(i)[3]);
                pstmt.setString(5, itemsread.get(i)[4]);
                pstmt.setString(6, itemsread.get(i)[5]);
                pstmt.setString(7, itemsread.get(i)[6]);
                pstmt.setString(8, itemsread.get(i)[7]);
                pstmt.setString(9, itemsread.get(i)[8]);
                pstmt.setString(10, itemsread.get(i)[9]);
                pstmt.setString(11, itemsread.get(i)[10]);
                pstmt.setString(12, itemsread.get(i)[11]);
                pstmt.setString(13, itemsread.get(i)[12]);
                pstmt.setString(14, itemsread.get(i)[13]);
                pstmt.setString(15, itemsread.get(i)[14]);
                pstmt.setString(16, itemsread.get(i)[15]);
                pstmt.executeUpdate();
            }
        
        
    }
}
