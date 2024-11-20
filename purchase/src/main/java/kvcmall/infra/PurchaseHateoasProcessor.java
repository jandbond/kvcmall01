package kvcmall.infra;

import kvcmall.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class PurchaseHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Purchase>> {

    @Override
    public EntityModel<Purchase> process(EntityModel<Purchase> model) {
        return model;
    }
}
