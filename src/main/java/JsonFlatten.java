import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsonFlatten {

    public static void main (String[] args) {

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try{
           line = f.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println ("Input Json String");
        System.out.println(line);
        System.out.println ("Flattened Json String");
        System.out.println(JsonFlattener.flatten(line));

    }


}
