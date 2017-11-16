package in.net.bookkeeper.messaging.example;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * Created by krganeshrajhan on 13/11/17.
 */
public class Example {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACb58d12540bc659b58ca5638a226b4463";
    public static final String AUTH_TOKEN = "c03e2e3d91962c14cba3e91a01091c76";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+6598254760"),
                new PhoneNumber("+15189418049"),
                "This is the sample message using Java program.").create();

        System.out.println(message.getSid());
    }
}