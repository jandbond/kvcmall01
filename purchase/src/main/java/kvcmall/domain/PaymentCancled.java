package kvcmall.domain;

import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class PaymentCancled extends AbstractEvent {

    private Long id;
    private Long purchaseId;
    private String status;
}
