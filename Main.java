import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main( String args[] ) 
    {
        Connection c = null;
        Statement stmt = null;

        try 
        {
            c = DriverManager.getConnection("jdbc:sqlite:ZorkNemesis2.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            Player player = new Player(stmt, c);
            Character character = new Character(stmt, c);
            Combat combat = new Combat(stmt,c);
            Weapon weapon = new Weapon(stmt, c);
            Armours armours = new Armours(stmt, c);
            Supplies supplies = new Supplies(stmt, c);
            player.createtable();
            character.createtable();
            combat.createtable();
            weapon.createtable();
            armours.createtable();
            supplies.createtable();

            CsvReader csvreader = new CsvReader();
            ArrayList<String[]> customerread= csvreader.customerreader();
            ArrayList<String[]> itemsread = csvreader.itemsreader();
            ArrayList<String[]> combatread = csvreader.combatreader();

            player.insertplayerData(c,combatread,customerread);
            character.insertcharacterData(c,customerread);
            combat.insertcombatData(c, combatread);
            weapon.insertWeaponData(c, itemsread);
            armours.insertArmourData(c, itemsread);
            supplies.insertSuppliesData(c, itemsread);

            Query query = new Query();
            query.query1(stmt,c);
            query.query2(stmt,c);
            query.query3(stmt,c);
            query.query4(stmt,c);
            query.query5(stmt,c);
            
            stmt.close();
            c.close();
        } catch ( Exception e ) 
            {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
            }
    

}

}
