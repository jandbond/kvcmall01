package kvcmall.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import kvcmall.config.kafka.KafkaProcessor;
import kvcmall.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPurchaseRequested_then_CREATE_1(
        @Payload PurchaseRequested purchaseRequested
    ) {
        try {
            if (!purchaseRequested.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setId(purchaseRequested.getId());
            myPage.setCustomerId(purchaseRequested.getCustomerId());
            myPage.setVoucherId(purchaseRequested.getVoucherId());
            myPage.setVoucherAmount(
                String.valueOf(purchaseRequested.getAmount())
            );
            myPage.setVoucherDate(purchaseRequested.getDate());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCompleted_then_UPDATE_1(
        @Payload PaymentCompleted paymentCompleted
    ) {
        try {
            if (!paymentCompleted.validate()) return;
            // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(
                paymentCompleted.getId()
            );

            if (myPageOptional.isPresent()) {
                MyPage myPage = myPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setVoucherStatus(paymentCompleted.getStatus());
                myPage.setVoucherDate(paymentCompleted.getDate());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_2(
        @Payload PaymentCanceled paymentCanceled
    ) {
        try {
            if (!paymentCanceled.validate()) return;
            // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(
                paymentCanceled.getId()
            );

            if (myPageOptional.isPresent()) {
                MyPage myPage = myPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setVoucherStatus(paymentCanceled.getStatus());
                myPage.setVoucherDate(paymentCanceled.getDate());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCompleted_then_UPDATE_3(
        @Payload PaymentCompleted paymentCompleted
    ) {
        try {
            if (!paymentCompleted.validate()) return;
            // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(
                paymentCompleted.getId()
            );

            if (myPageOptional.isPresent()) {
                MyPage myPage = myPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setVoucherStatus(paymentCompleted.getStatus());
                myPage.setVoucherDate(paymentCompleted.getDate());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVoucherAdded_then_UPDATE_4(
        @Payload VoucherAdded voucherAdded
    ) {
        try {
            if (!voucherAdded.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByVoucherId(
                String.valueOf(voucherAdded.getId())
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setVoucherName(voucherAdded.getName());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
