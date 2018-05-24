/**
 * 
 */
package uvsoftgroup.restfulapipostgresql.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uvsoftgroup.restfulapipostgresql.model.UserRegistration;
import uvsoftgroup.restfulapipostgresql.serviceimpl.UserRegistrationServiceImpl;

/**
 * @author A.Riaydh
 *
 */
@RestController
@RequestMapping("/userregistrationEntityManager")
public class UserRegistrationControllerEntityManager {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private UserRegistrationServiceImpl userRegistrationServiceImpl;
	
@Autowired
public UserRegistrationControllerEntityManager(UserRegistrationServiceImpl userRegistrationServiceImpl) {
		super();
		this.userRegistrationServiceImpl = userRegistrationServiceImpl;
	}
	
@RequestMapping(method = RequestMethod.GET)
public List<UserRegistration> userRegistrationAll() {
		logger.info("/userregistrationEntityManager");
	    List<UserRegistration> urs =userRegistrationServiceImpl.listAllUserRegistration();
	    return urs;
	  }
	
@RequestMapping(value="/{userRegistartionId}", method = RequestMethod.GET)
public UserRegistration findByUserRegistartionId(@PathVariable("userRegistartionId") Long userRegistartionId) {
		logger.info("/userregistrationEntityManager/"+userRegistartionId);
	    return userRegistrationServiceImpl.findByUserRegistartionId(userRegistartionId);
	  }
	

@RequestMapping(method = RequestMethod.POST)
public Map<String, Object> createUserRegistration(@RequestBody @Valid UserRegistration userRegistration){
userRegistrationServiceImpl.addUserRegistartion(userRegistration);
Map<String, Object> dataMap = new HashMap<String, Object>();
dataMap.put("message", "UserRegistration created successfully");
dataMap.put("status", HttpStatus.CREATED);
dataMap.put("userRegistration", userRegistration);
return dataMap;
}
	

@RequestMapping(value="/{urId}", method = RequestMethod.PUT)
public ResponseEntity<UserRegistration> updateUserRegistartion(@RequestBody @Valid UserRegistration userRegistration,@PathVariable("urId") Long urId) {
	userRegistrationServiceImpl.updateUserRegistartion(urId,userRegistration);
	return ResponseEntity.accepted().body(userRegistration);
	
}

@RequestMapping(value="/{urId}", method = RequestMethod.DELETE)
public ResponseEntity<UserRegistration> deleteUserRegistartion(@PathVariable Long urId){
		userRegistrationServiceImpl.deleteUserRegistartion(urId);
		return new ResponseEntity<UserRegistration>(HttpStatus.NO_CONTENT);
	}
}
	

