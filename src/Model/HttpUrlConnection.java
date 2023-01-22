package Model;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpUrlConnection {
    private HttpUrlConnection() {}

    public static String downloadFromURL(String link) throws IOException {
        try {
            StringBuilder informationString = new StringBuilder();
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                //throw new RuntimeException("Error: " + responseCode);
                return "Error";
            } else {
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
            }
            return informationString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error";
    }
}

