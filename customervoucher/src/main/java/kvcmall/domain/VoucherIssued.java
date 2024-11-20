package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class VoucherIssued extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long voucherId;
    private Long amount;
    private Date issuedDate;
    private String status;
    private Date date;

    public VoucherIssued(CustomerVoucher aggregate) {
        super(aggregate);
    }

    public VoucherIssued() {
        super();
    }
}
//>>> DDD / Domain Event
