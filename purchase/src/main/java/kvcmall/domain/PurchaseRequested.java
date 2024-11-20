package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PurchaseRequested extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long voucherId;
    private Long amount;
    private Date date;
    private String status;

    public PurchaseRequested(Purchase aggregate) {
        super(aggregate);
    }

    public PurchaseRequested() {
        super();
    }
}
//>>> DDD / Domain Event
