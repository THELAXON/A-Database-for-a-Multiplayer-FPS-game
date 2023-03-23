import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {

    public CsvReader() {
    }

    public ArrayList<String[]> customerreader() throws IOException {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("databases/src/main/java/com/scc201/Customers.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
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
        try (BufferedReader reader = new BufferedReader(new FileReader("databases/src/main/java/com/scc201/Items.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                data.add(fields);
            }
            //System.out.println(data.get(1)[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<String[]> combatreader() throws IOException {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("databases/src/main/java/com/scc201/Combat.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                data.add(fields);
            }
           //System.out.println(data.get(1)[1]);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}