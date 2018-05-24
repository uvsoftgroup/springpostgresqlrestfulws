/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uvsoftgroup.restfulapipostgresql.model.UserRegistration;
import uvsoftgroup.restfulapipostgresql.repository.UserRegistrationRepositoryPSR;
import uvsoftgroup.restfulapipostgresql.service.UserRegistrationService;


@Service
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {
	 private final Logger logger = LoggerFactory.getLogger(getClass());
	 
	@PersistenceContext
	private EntityManager entityManager;
	
		private UserRegistrationRepositoryPSR userRegistrationRepositoryPSR;
		@Autowired
		public UserRegistrationServiceImpl(UserRegistrationRepositoryPSR userRegistrationRepositoryPSR) {
			super();
			this.userRegistrationRepositoryPSR= userRegistrationRepositoryPSR;
		}
		
	

	@Override
	public Page<UserRegistration> listAllUserRegistrationByPage(Pageable pageable) {
		Page<UserRegistration> list=userRegistrationRepositoryPSR.findAll(pageable);
		return list;
	}

	@Override
	public Page<UserRegistration> findByUserRegistrationNameOrderByUserRegistrationIdAsc(String userRegistrationName, Pageable pageable) {
		Page<UserRegistration> list=userRegistrationRepositoryPSR.findAll(pageable);
		return list;
	}
	
	
    // EntityManager based implementations
	@SuppressWarnings("unchecked")
	@Override
	public List<UserRegistration> listAllUserRegistration() {
		String hql = "FROM UserRegistration as atcl ORDER BY atcl.userRegistrationId";
		return  entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public UserRegistration findByUserRegistartionId(Long userRegistartionId) {
		return entityManager.find(UserRegistration.class, userRegistartionId);
	
	}

	@Override
	public void addUserRegistartion(UserRegistration userRegistration) {
		entityManager.persist(userRegistration);
	}

	@Override
	public void updateUserRegistartion(Long urId,UserRegistration userRegistration) {
			if(userRegistartionExists(urId)){
				UserRegistration newUR=findByUserRegistartionId(urId);
				newUR.setUserAddressId(userRegistration.getUserAddressId());
				newUR.setUserRegistrationName(userRegistration.getUserRegistrationName());
				entityManager.flush();
			}
			else{
				logger.info("User registartion id is not exist!");
				new UserRegistration();
			}
			
	}
	
	
	@Override
	public void deleteUserRegistartion(Long urId) {
		if(userRegistartionExists(urId)){
			logger.info(String.format("User registartion id is exist:%s", urId));
			entityManager.remove(findByUserRegistartionId(urId));
		}
		else{
			logger.info("User registartion id is not exist!");
			new UserRegistration();
		}
		
	}
	
	@Override
	public boolean userRegistartionExists(Long urId) {
		String hql = " FROM UserRegistration as atcl WHERE atcl.userRegistrationId= ?";
		int count = entityManager.createQuery(hql).setParameter(1,urId).getResultList().size();
		return count > 0 ? true : false;
	}
	
	
}
