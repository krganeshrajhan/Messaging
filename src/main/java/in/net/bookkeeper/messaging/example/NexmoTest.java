package in.net.bookkeeper.messaging.example;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;

import java.io.IOException;

/**
 * Created by krganeshrajhan on 14/11/17.
 */
public class NexmoTest {

    public static void main(String[] args) throws IOException, NexmoClientException {

        AuthMethod auth = new TokenAuthMethod("f0293c3f", "365c9d51a56a8209");
        NexmoClient client = new NexmoClient(auth);
        System.out.println("+6598254760");

        SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(new TextMessage(
                "+6581719752",
                "+6598254760",
                "This message is sent from Java Program"));
        for (SmsSubmissionResult response : responses) {
            System.out.println(response);
        }
    }
}
