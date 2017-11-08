import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws Exception {

        String hisName;
        String herName;
        String emptyLabel = "";

        // From Oracle
        // JFrame frame = new JFrame("myFrame");

        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // frame.getContentPane();

        // frame.pack();

        // frame.setVisible(true);

        Scanner input = new Scanner(System.in);
        System.out.println("What is his name? ");
        hisName = input.next();

        System.out.println("What is her name? ");
        herName = input.next();

// These code snippets use an open-source library. http://unirest.io/java
        HttpResponse<JsonNode> response = Unirest.get(String.format("https://love-calculator.p.mashape.com/getPercentage?fname=%s&sname=%s", hisName, herName))
                .header("X-Mashape-Key", "aKavsnaT9BmshmnSeVvrEfBLmGKGp109ZhzjsnKiINiiKqko2Y")
                .header("Accept", "application/json")
                .asJson();

        System.out.println(response.getBody().getObject().getString("result"));

    }

}
