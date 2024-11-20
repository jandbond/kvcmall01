package kvcmall.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import kvcmall.CustomervoucherApplication;
import kvcmall.domain.VoucherCanceled;
import kvcmall.domain.VoucherIssued;
import lombok.Data;

@Entity
@Table(name = "CustomerVoucher_table")
@Data
//<<< DDD / Aggregate Root
public class CustomerVoucher {

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
        VoucherIssued voucherIssued = new VoucherIssued(this);
        voucherIssued.publishAfterCommit();

        VoucherCanceled voucherCanceled = new VoucherCanceled(this);
        voucherCanceled.publishAfterCommit();
    }

    public static CustomerVoucherRepository repository() {
        CustomerVoucherRepository customerVoucherRepository = CustomervoucherApplication.applicationContext.getBean(
            CustomerVoucherRepository.class
        );
        return customerVoucherRepository;
    }

    //<<< Clean Arch / Port Method
    public static void issueVoucher(PaymentCompleted paymentCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        CustomerVoucher customerVoucher = new CustomerVoucher();
        repository().save(customerVoucher);

        VoucherIssued voucherIssued = new VoucherIssued(customerVoucher);
        voucherIssued.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCompleted.get???()).ifPresent(customerVoucher->{
            
            customerVoucher // do something
            repository().save(customerVoucher);

            VoucherIssued voucherIssued = new VoucherIssued(customerVoucher);
            voucherIssued.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelVoucher(PaymentCanceled paymentCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        CustomerVoucher customerVoucher = new CustomerVoucher();
        repository().save(customerVoucher);

        VoucherCanceled voucherCanceled = new VoucherCanceled(customerVoucher);
        voucherCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCanceled.get???()).ifPresent(customerVoucher->{
            
            customerVoucher // do something
            repository().save(customerVoucher);

            VoucherCanceled voucherCanceled = new VoucherCanceled(customerVoucher);
            voucherCanceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
