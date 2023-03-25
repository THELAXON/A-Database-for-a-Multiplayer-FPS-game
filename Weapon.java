import java.sql.*;
import java.util.ArrayList;

public class Weapon  
{

    private Statement s;
    private Connection c;

    public Weapon(Statement s, Connection c)
    {
        this.s = s;
        this.c = c;
    }


    public void createtable() throws SQLException
    {
        s = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS Weapon " +
                    "(Item TEXT NOT NULL," +
                    " Character_Name TEXT NOT NULL, "+
                    " Item_Type TEXT NOT NULL, " +
                    " WeaponType TEXT NOT NULL, " +
                    " Range INT, " +
                    " Price INT NOT NULL, " +
                    " Quantity INT NOT NULL, " +
                    " AttackScore INT NOT NULL, " +
                    " Equipped INT NOT NULL, " +
                    " PRIMARY KEY(Item,Character_Name), "+
                    " FOREIGN KEY (Character_Name) REFERENCES Character(Character_Name) ON DELETE CASCADE)";
        s.executeUpdate(sql);
        System.out.println("Weapon Table Created");
    }

    public void insertWeaponData(Connection c, ArrayList<String[]> itemsread) throws SQLException 
    {
        String sql = "INSERT INTO Weapon VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = c.prepareStatement(sql);
        for (int i = 1; i < itemsread.size(); i++) 
        {
            String itemType = itemsread.get(i)[2];
            if (itemType.equalsIgnoreCase("Weapon")) {
                try{
                    pstmt.setString(1, itemsread.get(i)[1]);
                    pstmt.setString(2, itemsread.get(i)[0]);
                    pstmt.setString(3, itemType);
                    pstmt.setString(4, itemsread.get(i)[3]);
                    pstmt.setString(5, itemsread.get(i)[4]);
                    pstmt.setString(6, itemsread.get(i)[5]);
                    pstmt.setString(7, itemsread.get(i)[6]);
                    pstmt.setString(8, itemsread.get(i)[7]);
                    pstmt.setString(9, itemsread.get(i)[15]);
                    pstmt.executeUpdate();
                }
                catch ( SQLException e ) 
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                } 
            }
        }
    }
}
