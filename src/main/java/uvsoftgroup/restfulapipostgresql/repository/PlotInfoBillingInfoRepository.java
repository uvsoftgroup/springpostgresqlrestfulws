/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import uvsoftgroup.restfulapipostgresql.model.PlotInfoBillingInfo;


@RepositoryRestResource(collectionResourceRel="plotInfoBillingInfo",path="plotInfoBillingInfo")
public interface PlotInfoBillingInfoRepository extends PagingAndSortingRepository<PlotInfoBillingInfo, Long> {

}
