package kvcmall.domain;

import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class PurchaseRequested extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long voucherId;
    private Long amount;
    private Date date;
    private String status;
}
