import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {

    public CsvReader() {
    }

    public ArrayList<String[]> customerreader() throws IOException {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Customers.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",",-1);
                data.add(fields);
            }
            //System.out.println(data.get(1)[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<String[]> itemsreader() throws IOException {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Items.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",",-1);
                data.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<String[]> combatreader() throws IOException {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Combat.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",",-1);
                data.add(fields);
            }
           //System.out.println(data.get(1)[1]);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}