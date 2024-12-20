package kvcmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import kvcmall.PaymentApplication;
import kvcmall.domain.PaymentApproved;
import kvcmall.domain.PaymentCancled;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long purchaseId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();

        PaymentCancled paymentCancled = new PaymentCancled(this);
        paymentCancled.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    //<<< Clean Arch / Port Method
    public static void cancelPayment(
        CancellationRequested cancellationRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        PaymentCancled paymentCancled = new PaymentCancled(payment);
        paymentCancled.publishAfterCommit();
        PaymentCancled paymentCancled = new PaymentCancled(payment);
        paymentCancled.publishAfterCommit();
        PaymentCancled paymentCancled = new PaymentCancled(payment);
        paymentCancled.publishAfterCommit();
        */

        Payment payment = new Payment();
        payment.setPurchaseId(cancellationRequested.getId());
        payment.setStatus("결제취소");
        repository().save(payment);

        PaymentCancled paymentCancled = new PaymentCancled(payment);
        paymentCancled.publishAfterCommit();
        
        /** Example 2:  finding and process
        
        repository().findById(cancellationRequested.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);

            PaymentCancled paymentCancled = new PaymentCancled(payment);
            paymentCancled.publishAfterCommit();
            PaymentCancled paymentCancled = new PaymentCancled(payment);
            paymentCancled.publishAfterCommit();
            PaymentCancled paymentCancled = new PaymentCancled(payment);
            paymentCancled.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void approvePayment(PurchaseRequested purchaseRequested) {
        //implement business logic here:
        // 결제 승인 요청 추가
        Payment payment = new Payment();
        payment.setPurchaseId(purchaseRequested.getId());
        payment.setStatus("결제승인");
        repository().save(payment);

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(purchaseRequested.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
