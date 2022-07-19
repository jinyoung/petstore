package petshop.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petshop.domain.*;

@RepositoryRestResource(collectionResourceRel = "addresses", path = "addresses")
public interface AddressRepository
    extends PagingAndSortingRepository<Address, Long> {}
