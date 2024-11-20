package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class VoucherAdded extends AbstractEvent {

    private Long id;
    private String name;
    private Long totalIssuedAmount;
    private Long currentIssuedAmount;
    private String status;

    public VoucherAdded(Voucher aggregate) {
        super(aggregate);
    }

    public VoucherAdded() {
        super();
    }
}
//>>> DDD / Domain Event
