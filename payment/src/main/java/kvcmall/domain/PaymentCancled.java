package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCancled extends AbstractEvent {

    private Long id;
    private Long purchaseId;
    private String status;

    public PaymentCancled(Payment aggregate) {
        super(aggregate);
    }

    public PaymentCancled() {
        super();
    }
}
//>>> DDD / Domain Event
