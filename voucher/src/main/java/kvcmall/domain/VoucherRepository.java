package kvcmall.domain;

import kvcmall.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "vouchers", path = "vouchers")
public interface VoucherRepository
    extends PagingAndSortingRepository<Voucher, Long> {}
