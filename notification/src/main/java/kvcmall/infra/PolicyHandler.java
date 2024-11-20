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

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VoucherIssued'"
    )
    public void wheneverVoucherIssued_Notify(
        @Payload VoucherIssued voucherIssued
    ) {
        VoucherIssued event = voucherIssued;
        System.out.println(
            "\n\n##### listener Notify : " + voucherIssued + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VoucherCanceled'"
    )
    public void wheneverVoucherCanceled_Notify(
        @Payload VoucherCanceled voucherCanceled
    ) {
        VoucherCanceled event = voucherCanceled;
        System.out.println(
            "\n\n##### listener Notify : " + voucherCanceled + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
