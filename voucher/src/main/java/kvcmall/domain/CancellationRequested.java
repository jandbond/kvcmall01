package kvcmall.domain;

import java.util.*;
import kvcmall.domain.*;
import kvcmall.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class CancellationRequested extends AbstractEvent {

    private Long id;
    private String customerId;
    private String voucherId;
    private Long amount;
    private Date date;
    private String status;
}
