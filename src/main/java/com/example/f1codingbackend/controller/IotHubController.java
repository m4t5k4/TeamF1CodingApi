package com.example.f1codingbackend.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microsoft.azure.sdk.iot.service.*;
import java.io.IOException;
import java.net.URISyntaxException;

//mogelijkheid om id te pushen naar rfid path = /rfid/id ( id => userid)

@RestController
public class IotHubController {
    private static final String connectionString = "HostName=Project40.azure-devices.net;SharedAccessKeyName=service;SharedAccessKey=8JPey/Gfh44/+0rQFJNlKew/adn+SGRkXPLbq1t01uU=";
    private static final String deviceId = "RPIRFID";
    private static final IotHubServiceClientProtocol protocol = IotHubServiceClientProtocol.AMQPS;

    @PostMapping("/rfid/{id}")
    public static void main(String[] args, @PathVariable Long id) throws IOException,
                            URISyntaxException, Exception {
        ServiceClient serviceClient = ServiceClient.createFromConnectionString(
                connectionString, protocol);
        if (serviceClient != null) {
            serviceClient.open();
            FeedbackReceiver feedbackReceiver = serviceClient
                    .getFeedbackReceiver();
            if (feedbackReceiver != null) feedbackReceiver.open();

            Message messageToSend = new Message("newCardID: " + String.valueOf(id));
            messageToSend.setDeliveryAcknowledgement(DeliveryAcknowledgement.Full);

            serviceClient.send(deviceId, messageToSend);
            System.out.println("Message sent to device");

            FeedbackBatch feedbackBatch = feedbackReceiver.receive(10000);
            if (feedbackBatch != null) {
                System.out.println("Message feedback received, feedback time: "
                        + feedbackBatch.getEnqueuedTimeUtc().toString());
            }

            if (feedbackReceiver != null) feedbackReceiver.close();
            serviceClient.close();
        }
    }
}
