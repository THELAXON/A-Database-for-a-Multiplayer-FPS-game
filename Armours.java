import java.sql.*;
import java.util.ArrayList;

public class Armours  
{

    private Statement s;
    private Connection c;

    public Armours(Statement s, Connection c)
    {
        this.s = s;
        this.c = c;
    }


    public void createtable() throws SQLException
    {
        s = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS Armour " +
                    "(Item TEXT PRIMARY KEY NOT NULL," +
                    " Character_Name TEXT NOT NULL, "+
                    " Item_Type TEXT NOT NULL, " +
                    " Price INT NOT NULL, " +
                    " Quantity INT NOT NULL, " +
                    " DefendScore INT, " +
                    " Wearable INT, " +
                    " Worn INT, " +
                    " BodyPart INT, " +
                    " Equiped INT, " +
                    " FOREIGN KEY (Character_Name) REFERENCES Character(Character_Name) ON DELETE CASCADE)";
        s.executeUpdate(sql);
        System.out.println("Player Table Created");
    }

    public void insertArmourData(Connection c, ArrayList<String[]> itemsread) throws SQLException 
    {
        String sql = "INSERT INTO Armour VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = c.prepareStatement(sql);
        for (int i = 1; i < itemsread.size(); i++) 
        {
            String itemType = itemsread.get(i)[2];
            if (itemType.equalsIgnoreCase("Armour") || itemType.equalsIgnoreCase("Clothing")) {
                try{
                    pstmt.setString(1, itemsread.get(i)[1]);
                    pstmt.setString(2, itemsread.get(i)[0]);
                    pstmt.setString(3, itemType);
                    pstmt.setString(4, itemsread.get(i)[5]);
                    pstmt.setString(5, itemsread.get(i)[6]);
                    pstmt.setString(6, itemsread.get(i)[7]);
                    pstmt.setString(7, itemsread.get(i)[12]);
                    pstmt.setString(8, itemsread.get(i)[13]);
                    pstmt.setString(9, itemsread.get(i)[14]);
                    pstmt.setString(9, itemsread.get(i)[15]);
                    pstmt.executeUpdate();
                }
                catch ( SQLException e ) 
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                } 
            } else {
                System.out.println("Ignoring non-Armour item: " + itemsread.get(i)[1]);
            }
        }
    }
}
