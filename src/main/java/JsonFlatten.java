import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsonFlatten {

    public static void main (String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try{
           line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println ("Input Json String");
        System.out.println(line);
        System.out.println ("Flattened Json String");
        System.out.println(JsonFlattener.flatten(line));

    }


}
