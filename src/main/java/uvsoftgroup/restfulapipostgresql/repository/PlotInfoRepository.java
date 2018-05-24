package uvsoftgroup.restfulapipostgresql.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import uvsoftgroup.restfulapipostgresql.model.PlotInfo;
/*
 * Annotate a org.springframework.data.repository.Repository with this to customize export mapping and rels.
 * Extension of CrudRepository to provide additional methods to retrieve entities using the pagination and sorting abstraction.
 * Interface for generic CRUD operations on a repository for a specific type.CrudRepository extends Repository Interfaces
 */
@RepositoryRestResource(collectionResourceRel = "plotInfo", path = "plotInfos")
public interface PlotInfoRepository extends PagingAndSortingRepository<PlotInfo, Long>{

}
