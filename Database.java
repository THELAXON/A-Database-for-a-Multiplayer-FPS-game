import java.sql.*;
import java.util.ArrayList;

public class Database {

    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;

        try {
            c = DriverManager.getConnection("jdbc:sqlite:ZorkNemesis2.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            Player player = new Player(stmt, c);
            Character character = new Character(stmt, c);
            Items items = new Items(stmt, c);
            Combat combat = new Combat(stmt,c);
            player.createtable();
            character.createtable();
            items.createtable();
            combat.createtable();

            CsvReader csvreader = new CsvReader();
            ArrayList<String[]> customerread= csvreader.customerreader();
            ArrayList<String[]> itemsread = csvreader.itemsreader();
            ArrayList<String[]> combatread = csvreader.combatreader();
            //player.insertplayerData(c, combatread, customerread);
            //character.insertcharacterData(c, combatread, customerread);
            //combat.insertcombatData(c, combatread, customerread);
            //items.insertitemsData(c, itemsread, customerread);

            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

}
