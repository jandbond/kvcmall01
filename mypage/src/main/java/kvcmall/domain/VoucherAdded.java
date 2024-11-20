package kvcmall.domain;

import java.time.LocalDate;
import java.util.*;
import kvcmall.infra.AbstractEvent;
import lombok.Data;

@Data
public class VoucherAdded extends AbstractEvent {

    private Long id;
    private String name;
    private Long totalIssuedAmount;
    private Long currentIssuedAmount;
    private String status;
}
