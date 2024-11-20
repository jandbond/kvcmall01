package kvcmall.domain;

import kvcmall.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "customerVouchers",
    path = "customerVouchers"
)
public interface CustomerVoucherRepository
    extends PagingAndSortingRepository<CustomerVoucher, Long> {}
