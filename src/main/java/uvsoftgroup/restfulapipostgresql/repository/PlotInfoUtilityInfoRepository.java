/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import uvsoftgroup.restfulapipostgresql.model.PlotInfoUtilityInfo;

/**
 * @author A.Riaydh
 *
 */
@RepositoryRestResource(collectionResourceRel="plotInfoUtilityInfo",path="plotInfoUtilityInfos")
public interface PlotInfoUtilityInfoRepository extends PagingAndSortingRepository<PlotInfoUtilityInfo, Long> {

}
