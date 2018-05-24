/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import uvsoftgroup.restfulapipostgresql.model.UserRegistration;

/**
 * 
 * Extension of CrudRepository to provide additional methods to retrieve entities using the pagination and sorting abstraction.
 * Interface for generic CRUD operations on a repository for a specific type.CrudRepository extends Repository Interfaces
 * 
 *
 */
public interface UserRegistrationRepositoryPSR extends PagingAndSortingRepository<UserRegistration, Long>{
	 Page<UserRegistration> findByUserRegistrationName(String userRegistrationName, Pageable pageable);
	 Page<UserRegistration> findByUserRegistrationNameEndsWith(String userRegistrationName,Pageable pageable);

}
