package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.infra.AbstractEvent;
import lombok.Data;

@Data
public class PurchaseRequested extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long voucherId;
    private Long amount;
    private Date date;
    private String status;
}
