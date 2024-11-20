package kvcmall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import kvcmall.config.kafka.KafkaProcessor;
import kvcmall.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CancellationRequested'"
    )
    public void wheneverCancellationRequested_CancelPayment(
        @Payload CancellationRequested cancellationRequested
    ) {
        CancellationRequested event = cancellationRequested;
        System.out.println(
            "\n\n##### listener CancelPayment : " +
            cancellationRequested +
            "\n\n"
        );

        // Sample Logic //
        Payment.cancelPayment(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
