package home.hw;

import lombok.Data;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Data
public class HttpRequestCat {
    public static final String PATH_SITE = "https://http.cat";
    private int responseCode = 404;
    private byte[] responceStream = null;

    public HttpRequestCat(String path) {
        try {

            URL url = new URL(path);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            responseCode = connection.getResponseCode();

            BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream());
            responceStream = bufferedInputStream.readAllBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
