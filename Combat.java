import java.sql.*;
import java.util.ArrayList;

public class Combat  {

    private Statement s;
    private Connection c;

    public Combat(Statement s, Connection c){
        this.s = s;
        this.c = c;
    }


    public void createtable() throws SQLException
    {
        s = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS Combat " +
                    "(BattleNo INT NOT NULL," +
                    " BattleDate INT NOT NULL, " +
                    " Attacker TEXT NOT NULL, " +
                    " Defender TEXT NOT NULL," +
                    " Weapon TEXT NOT NULL, " +
                    " Result TEXT NOT NULL, " +
                    " Damage INT NOT NULL, " +
                    " PRIMARY KEY (BattleNo, Attacker, Defender, Weapon, Result, Damage))";
        s.executeUpdate(sql);
        System.out.println("Player Table Created");
    }


    public void insertcombatData(Connection c, ArrayList<String[]> combatread) throws SQLException {
        String sql = "INSERT OR IGNORE INTO Combat VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pstmt = c.prepareStatement(sql);
        for (int i = 1; i < combatread.size(); i++) {
            pstmt.setString(1, combatread.get(i)[1]);
            pstmt.setString(2, combatread.get(i)[0]);
            pstmt.setString(3, combatread.get(i)[2]);
            pstmt.setString(4, combatread.get(i)[3]);
            pstmt.setString(5, combatread.get(i)[4]);
            pstmt.setString(6, combatread.get(i)[5]);
            pstmt.setString(7, combatread.get(i)[6]);
            pstmt.executeUpdate();
        }
    }

}