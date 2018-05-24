/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import uvsoftgroup.restfulapipostgresql.model.UserRole;

@RepositoryRestResource(collectionResourceRel = "userRole", path = "userRoles")
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {

}
