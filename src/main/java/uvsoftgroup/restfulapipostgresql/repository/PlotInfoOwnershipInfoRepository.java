/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import uvsoftgroup.restfulapipostgresql.model.PlotInfoOwnershipInfo;


@RepositoryRestResource(collectionResourceRel="plotInfoOwnershipInfo",path="plotInfoOwnershipInfos")
public interface PlotInfoOwnershipInfoRepository extends PagingAndSortingRepository<PlotInfoOwnershipInfo, Long> {

}
