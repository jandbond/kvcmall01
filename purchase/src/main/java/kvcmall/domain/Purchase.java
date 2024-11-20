package kvcmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import kvcmall.PurchaseApplication;
import kvcmall.domain.CancellationRequested;
import kvcmall.domain.PaymentCanceled;
import kvcmall.domain.PaymentCompleted;
import kvcmall.domain.PurchaseRequested;
import lombok.Data;

@Entity
@Table(name = "Purchase_table")
@Data
//<<< DDD / Aggregate Root
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long customerId;

    private Long voucherId;

    private Long amount;

    private Date date;

    private String status;

    @PostPersist
    public void onPostPersist() {
        PurchaseRequested purchaseRequested = new PurchaseRequested(this);
        purchaseRequested.publishAfterCommit();

        PaymentCompleted paymentCompleted = new PaymentCompleted(this);
        paymentCompleted.publishAfterCommit();

        PaymentCanceled paymentCanceled = new PaymentCanceled(this);
        paymentCanceled.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        CancellationRequested cancellationRequested = new CancellationRequested(
            this
        );
        cancellationRequested.publishAfterCommit();
    }

    public static PurchaseRepository repository() {
        PurchaseRepository purchaseRepository = PurchaseApplication.applicationContext.getBean(
            PurchaseRepository.class
        );
        return purchaseRepository;
    }

    //<<< Clean Arch / Port Method
    public static void completePayment(PaymentApproved paymentApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        Purchase purchase = new Purchase();
        repository().save(purchase);

        PaymentCompleted paymentCompleted = new PaymentCompleted(purchase);
        paymentCompleted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(purchase->{
            
            purchase // do something
            repository().save(purchase);

            PaymentCompleted paymentCompleted = new PaymentCompleted(purchase);
            paymentCompleted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelPayment(PaymentCancled paymentCancled) {
        //implement business logic here:

        /** Example 1:  new item 
        Purchase purchase = new Purchase();
        repository().save(purchase);

        PaymentCanceled paymentCanceled = new PaymentCanceled(purchase);
        paymentCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCancled.get???()).ifPresent(purchase->{
            
            purchase // do something
            repository().save(purchase);

            PaymentCanceled paymentCanceled = new PaymentCanceled(purchase);
            paymentCanceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
