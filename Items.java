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
        String sql = "CREATE TABLE Items " +
                    "(Item VARCHAR(20) PRIMARY KEY NOT NULL," +
                    " Account_Number TEXT NOT NULL, " +
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
                    " FOREIGN KEY (Account_Number) REFERENCES Player(Account_Number) ON DELETE CASCADE)";
        s.executeUpdate(sql);
        System.out.println("Items Table Created");
    }

        public void insertitemsData(Connection c, ArrayList<String[]> itemsread, ArrayList<String[]> customerread) throws SQLException {
        String sql = "INSERT OR IGNORE INTO Items VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = c.prepareStatement(sql);
        for (int i = 0; i < customerread.size(); i++) {
            pstmt.setString(1, itemsread.get(i)[1]);
            pstmt.setString(2, customerread.get(i)[0]);
            pstmt.setString(3, itemsread.get(i)[0]);
            pstmt.setString(4, itemsread.get(i)[2]);
            pstmt.setString(5, itemsread.get(i)[3]);
            pstmt.setString(6, itemsread.get(i)[4]);
            pstmt.setString(7, itemsread.get(i)[4]);
            pstmt.setString(8, itemsread.get(i)[5]);
            pstmt.executeUpdate();
        }
    }
}
