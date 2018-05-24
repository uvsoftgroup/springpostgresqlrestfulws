/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uvsoftgroup.restfulapipostgresql.model.UserRegistration;
import uvsoftgroup.restfulapipostgresql.repository.UserRegistrationRepositoryJPA;
import uvsoftgroup.restfulapipostgresql.service.UserRegistrationJPAService;


@Service
@Transactional
public class UserRegistrationJPAServiceImpl implements UserRegistrationJPAService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private UserRegistrationRepositoryJPA userRegistrationRepositoryJPA;
	@Autowired
	public UserRegistrationJPAServiceImpl(UserRegistrationRepositoryJPA userRegistrationRepositoryJPA) {
		super();
		this.userRegistrationRepositoryJPA= userRegistrationRepositoryJPA;
	}
	
	 @Transactional(readOnly=true)
	  public List<UserRegistration> listAllUserRegistration() {
		 List<UserRegistration> list=userRegistrationRepositoryJPA.findAll();
		 
	  return list;
	 
}

	@Override
	@Transactional
	public UserRegistration saveUserRegistration(UserRegistration userRegistration) {
		 if ( userRegistration != null ) {
			 userRegistration = userRegistrationRepositoryJPA.saveAndFlush(userRegistration);
			 }
			  return userRegistration;
	}
	
	
	@Override
	public void deleteUserRegistartion(Long urId) {
		if(userRegistartionExists(urId)){
			logger.info(String.format("User registartion id is exist:%s", urId));
			userRegistrationRepositoryJPA.delete(urId);
		}
		else{
			logger.info("User registartion id is not exist!");
			new UserRegistration();
		}
		
	}
	
	@Override
	public UserRegistration findByUserRegistartionId(Long urId) {
		
		if(userRegistartionExists(urId)){
			logger.info(String.format("User registartion id is exist:%s", urId));
			return userRegistrationRepositoryJPA.getOne(urId);
		}
		else{
			logger.info("User registartion id is not exist!");
			new UserRegistration();
		}
		return userRegistrationRepositoryJPA.getOne(urId);
	}
	
	@Override
	public boolean userRegistartionExists(Long urId) {
		UserRegistration ur =userRegistrationRepositoryJPA.getOne(urId);
		return (ur.getUserRegistrationId()>0 && ur.getUserRegistrationId()!=null)? true : false;
	}

	@Override
	public void updateUserRegistartion(Long urId,UserRegistration userRegistration) {

		if(userRegistartionExists(urId)){
			logger.info(String.format("User registartion id is exist:%s", urId));
			userRegistration.setUserRegistrationId(urId);
			 userRegistrationRepositoryJPA.saveAndFlush(userRegistration);
		}
		else{
			logger.info("User registartion id is not exist!");
			new UserRegistration();
		}
	
	}
	
}
