package kvcmall.infra;

import kvcmall.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class VoucherHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Voucher>> {

    @Override
    public EntityModel<Voucher> process(EntityModel<Voucher> model) {
        return model;
    }
}
