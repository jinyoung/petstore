package petshop.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petshop.domain.*;

@RepositoryRestResource(collectionResourceRel = "petids", path = "petids")
public interface PetIdRepository
    extends PagingAndSortingRepository<PetId, Long> {}
