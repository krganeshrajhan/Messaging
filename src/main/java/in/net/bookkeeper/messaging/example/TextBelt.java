package in.net.bookkeeper.messaging.example;

import net.minidev.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by krganeshrajhan on 15/11/17.
 */
public class TextBelt {

    public static void main(String[] args) throws IOException {

        final NameValuePair[] data = {
                new BasicNameValuePair("phone", "+6598254760"),
                new BasicNameValuePair("message", "Hello world"),
                new BasicNameValuePair("key", "b24ece9f11a5cba1fa6e93ce33d968ceeda329dbJIOODjfcmIkJUYQO6QXyVDW8L")
        };
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://textbelt.com/text");
        httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(data)));
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        String responseString = EntityUtils.toString(httpResponse.getEntity());
//        JSONObject response = new JSONObject(responseString);
        httpResponse.close();
    }
}

