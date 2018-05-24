/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import uvsoftgroup.restfulapipostgresql.model.UserRegistration;


@Transactional
public interface UserRegistrationJPAService {
	
	public List<UserRegistration> listAllUserRegistration();
	public UserRegistration saveUserRegistration(UserRegistration userRegistration);
	public boolean userRegistartionExists(Long urId);
	public void deleteUserRegistartion(Long urId);
	public UserRegistration findByUserRegistartionId(Long userRegistartionId);
	public void updateUserRegistartion(Long urId,UserRegistration userRegistration);
		
	
	
	

}
