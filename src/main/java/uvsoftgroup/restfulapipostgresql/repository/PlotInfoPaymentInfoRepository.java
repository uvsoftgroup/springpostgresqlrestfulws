/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import uvsoftgroup.restfulapipostgresql.model.PlotInfoPaymentInfo;


@RepositoryRestResource(collectionResourceRel="plotInfoPaymentInfo",path="plotInfoPaymentInfos")
public interface PlotInfoPaymentInfoRepository extends PagingAndSortingRepository<PlotInfoPaymentInfo, Long> {

}
