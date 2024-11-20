package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.infra.AbstractEvent;
import lombok.Data;

@Data
public class PaymentCanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String voucherId;
    private Long amount;
    private Date date;
    private String status;
}
