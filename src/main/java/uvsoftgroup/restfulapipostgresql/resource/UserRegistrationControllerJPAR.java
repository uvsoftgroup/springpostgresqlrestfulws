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
import uvsoftgroup.restfulapipostgresql.serviceimpl.UserRegistrationJPAServiceImpl;




/**
 * @author A.Riaydh
 *
 */
@RestController
@RequestMapping("/userregistrationJPA")
public class UserRegistrationControllerJPAR {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private UserRegistrationJPAServiceImpl userRegistrationJPAServiceImpl;
	
	@Autowired
	public UserRegistrationControllerJPAR(UserRegistrationJPAServiceImpl userRegistrationJPAServiceImpl) {
		super();
		this.userRegistrationJPAServiceImpl=userRegistrationJPAServiceImpl;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserRegistration> userRegistrationAll() {
			logger.info("/userregistrationJPA");
		    List<UserRegistration> urs =userRegistrationJPAServiceImpl.listAllUserRegistration();
		    
		    for (final UserRegistration ur : urs) {
	           // final Link selfLink =linkTo(UserRegistration.class).slash(ur.getUserRegistrationId()).withSelfRel();
	           // ur.add(selfLink);
	            if (ur.getUserRoles().size() > 0) {
	               // List<UserRole> methodLinkBuilder =methodOn(UserRegistration.class).getUserRoles();
	               // final Link userRolesLink = linkTo(methodLinkBuilder).withRel("allOrders");
	               // ur.add(userRolesLink);
	             }
	          
	        }
		   return urs;
		  }
	
	@RequestMapping(value="/{userRegistartionId}", method = RequestMethod.GET)
	public UserRegistration findByUserRegistartionId(@PathVariable("userRegistartionId") Long userRegistartionId) {
			logger.info("/userregistrationEntityManager/"+userRegistartionId);
		    return userRegistrationJPAServiceImpl.findByUserRegistartionId(userRegistartionId);  
		  }
	
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createUserRegistration(@RequestBody @Valid UserRegistration userRegistration){
		
		//Link link = linkTo(UserRegistration.class).slash(userRegistration.getUserRegistrationId()).withSelfRel();
		userRegistrationJPAServiceImpl.saveUserRegistration(userRegistration);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("message", "UserRegistration created successfully");
	dataMap.put("status", HttpStatus.CREATED);
	dataMap.put("userRegistration", userRegistration);
	//dataMap.put("links", link);
	return dataMap;
	}
	

	@RequestMapping(value="/{urId}", method = RequestMethod.DELETE)
	public ResponseEntity<UserRegistration> deleteUserRegistartion(@PathVariable Long urId){
		    userRegistrationJPAServiceImpl.deleteUserRegistartion(urId);
			return new ResponseEntity<UserRegistration>(HttpStatus.NO_CONTENT);
			
			
		}

   @RequestMapping(value="/{urId}", method = RequestMethod.PUT)
	public ResponseEntity<UserRegistration> updateUserRegistartion(@PathVariable("urId") Long urId, @RequestBody @Valid UserRegistration userRegistration) {
		userRegistrationJPAServiceImpl.updateUserRegistartion(urId,userRegistration);
		return ResponseEntity.accepted().body(userRegistration);
	}
	
}
