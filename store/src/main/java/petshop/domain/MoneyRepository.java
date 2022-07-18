package petshop.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petshop.domain.*;

@RepositoryRestResource(collectionResourceRel = "", path = "")
public interface MoneyRepository
    extends PagingAndSortingRepository<Money, Long> {}
