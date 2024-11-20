package kvcmall.infra;

import kvcmall.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerVoucherHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CustomerVoucher>> {

    @Override
    public EntityModel<CustomerVoucher> process(
        EntityModel<CustomerVoucher> model
    ) {
        return model;
    }
}
