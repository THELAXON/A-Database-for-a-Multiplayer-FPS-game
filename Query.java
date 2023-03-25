import java.sql.*;

public class Query{
    public Query(){
        
    }
    public void query1(Statement stmt,Connection c) throws SQLException 
    {
        System.out.println("List the top 5 characters with the highest number of successful combats attacks.\n");
        try {
            stmt = c.createStatement();
            String sql = "SELECT Attacker, COUNT(*) AS Successful_Attacks FROM Combat WHERE Result='Hit' OR Result = 'Victory' GROUP BY Attacker ORDER BY Successful_Attacks DESC LIMIT 5;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String attacker = rs.getString("Attacker");
                int successfulAttacks = rs.getInt("Successful_Attacks");
                System.out.println("Attacker: " + attacker + ", Successful Attacks:" + successfulAttacks + "\n");
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        
    }
    public void query2(Statement stmt,Connection c) throws SQLException 
    {
        System.out.println("Print the name and total number of attacks per character having more than 5 attacks.\n");
        try {
            stmt = c.createStatement();
            String sql = "SELECT Character_Name, COUNT(*) AS Total_Attacks FROM Combat INNER JOIN Character ON Combat.Attacker = Character.Character_Name GROUP BY Character_Name HAVING Total_Attacks > 5;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String characterName = rs.getString("Character_Name");
                int totalAttacks = rs.getInt("Total_Attacks");
                System.out.println("Character Name: " + characterName + ", Total Attacks: " + totalAttacks + "\n");
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void query3(Statement stmt,Connection c) throws SQLException 
    {
        System.out.println("Order the names of characters from highest to lowest number of attacks.\n");
        try {
            stmt = c.createStatement();
            String sql = "SELECT Character_Name, COUNT(*) AS Total_Attacks FROM Combat INNER JOIN Character ON Combat.Attacker = Character.Character_Name GROUP BY Character_Name ORDER BY Total_Attacks DESC;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String characterName = rs.getString("Character_Name");
                int totalAttacks = rs.getInt("Total_Attacks");
                System.out.println("Character Name: " + characterName + ", Total Attacks: " + totalAttacks + "\n");
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    public void query4(Statement stmt,Connection c) throws SQLException 
    {
        System.out.println("List the name of Players with at least 5 characters\n");
        try {
            stmt = c.createStatement();
            String sql = "SELECT Account_Number, forename, surname FROM Player WHERE Account_Number IN (SELECT Account_Number FROM Character GROUP BY Account_Number HAVING COUNT(*) >= 5);";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int accountNumber = rs.getInt("Account_Number");
                String forename = rs.getString("forename");
                String surname = rs.getString("surname");
                System.out.println("Account Number: " + accountNumber + ", Name: " + forename + " " + surname + "\n");
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    public void query5(Statement stmt, Connection c) throws SQLException {
        System.out.println("List the name of weapons that is used by at least 10 Players.\n");
        try {
            stmt = c.createStatement();
            String sql = "SELECT Item, COUNT(DISTINCT Character_Name) AS Num_Players FROM Weapon GROUP BY Item HAVING COUNT(DISTINCT Character_Name) >= 10";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String weaponName = rs.getString("Item");
                int numPlayers = rs.getInt("Num_Players");
                System.out.println("Weapon Name: " + weaponName + ", Num Players: " + numPlayers + "\n");
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    
}