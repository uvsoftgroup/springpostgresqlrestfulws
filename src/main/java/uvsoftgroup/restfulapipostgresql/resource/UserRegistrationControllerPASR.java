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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import uvsoftgroup.restfulapipostgresql.model.UserRegistration;
import uvsoftgroup.restfulapipostgresql.repository.UserRegistrationRepositoryJPA;
import uvsoftgroup.restfulapipostgresql.repository.UserRegistrationRepositoryPSR;
import uvsoftgroup.restfulapipostgresql.serviceimpl.UserRegistrationServiceImpl;


@RestController
@RequestMapping("/userregistration")
public class UserRegistrationControllerPASR {
	 private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private UserRegistrationRepositoryPSR userRegistrationRepositoryPSR;
	private UserRegistrationServiceImpl userRegistrationServiceImpl;
	private UserRegistrationRepositoryJPA userRegistrationRepositoryJPA;
	@Autowired
	public UserRegistrationControllerPASR(UserRegistrationRepositoryPSR userRegistrationRepositoryPSR,
			UserRegistrationServiceImpl userRegistrationServiceImpl,UserRegistrationRepositoryJPA userRegistrationRepositoryJPA) {
		super();
		this.userRegistrationRepositoryPSR= userRegistrationRepositoryPSR;
		this.userRegistrationServiceImpl=userRegistrationServiceImpl;
		this.userRegistrationRepositoryJPA=userRegistrationRepositoryJPA;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	 public Map<String, Object> createUserRegistration(@RequestBody @Valid UserRegistration userRegistration) {
		userRegistrationRepositoryPSR.save(userRegistration);
	  Map<String, Object> dataMap = new HashMap<String, Object>();
	  dataMap.put("message", "PlotInfo created successfully");
	  dataMap.put("status", HttpStatus.CREATED);
	  dataMap.put("userRegistration", userRegistration);
	  return dataMap;
	 }
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<UserRegistration> getAllUserRegistration(Pageable pageable){
		Page<UserRegistration> list=userRegistrationServiceImpl.listAllUserRegistrationByPage(pageable);
		return list;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public Page<UserRegistration> searchUserRegistration(@RequestParam("userRegistrationName") String userRegistrationName, Pageable pageable) {
        Page<UserRegistration> urList =userRegistrationRepositoryPSR.findByUserRegistrationName(userRegistrationName, pageable);
        return urList;
    }
	
	
	@RequestMapping(value = "/userLastNameOrUserName", method = RequestMethod.GET)
    @ResponseBody
    public Page<UserRegistration> searchUserNameLastName(
    		@RequestParam("userRegistrationLName") String userRegistrationLName,
    		@RequestParam("userRegistrationName") String userRegistrationName, 
    		Pageable pageable) {
        Page<UserRegistration> urList =userRegistrationRepositoryJPA.findByUserRegistrationLNameOrUserRegistrationName(userRegistrationLName, userRegistrationName,pageable);
        return urList;
    }
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	  List<UserRegistration> userRegistrationAll() {
	    List<UserRegistration> urs =userRegistrationServiceImpl.listAllUserRegistration();
	    return urs;
	  }
	
	@RequestMapping(value = "/userRegistrations", method = RequestMethod.GET)
	  HttpEntity<PagedResources<UserRegistration>> userRegistrations(Pageable pageable,PagedResourcesAssembler assembler) {

	    Page<UserRegistration> urs =userRegistrationRepositoryPSR.findAll(pageable);
	    return new ResponseEntity<>(assembler.toResource(urs), HttpStatus.OK);
	  }
	
	
	@RequestMapping(value = "/{urId}", method=RequestMethod.GET)
	public UserRegistration getUserRegistration(@PathVariable("urId") Long urId) {
		if(userRegistrationRepositoryPSR.exists(urId)){
		   return userRegistrationRepositoryPSR.findOne(urId);
		}
		else{
			 Map<String, Object> dataMap = new HashMap<String, Object>();
			  dataMap.put("message", "User registration Id is not exist!");
			  dataMap.put("status", HttpStatus.FOUND);
			  dataMap.put("User registration id", urId);
			 
		}
		return userRegistrationRepositoryPSR.findOne(urId);
	}
	
	@RequestMapping(value = "/counter", method=RequestMethod.GET)
	public Long getCounter() {
    	return userRegistrationRepositoryPSR.count();
	}
	
	@RequestMapping(value="/{urId}", method = RequestMethod.DELETE)
	 public void deleteUserRegistartion(@PathVariable Long urId){
		
		if(userRegistrationRepositoryPSR.exists(urId)){
			     userRegistrationRepositoryPSR.delete(urId);
			}
			else{
				new Throwable("User registration Id is not exist!");
				new UserRegistration();
			}
	 }
	
	@RequestMapping(value="/{urId}", method = RequestMethod.PUT)
	public ResponseEntity<UserRegistration> saveResource(@RequestBody @Valid UserRegistration userRegistration,@PathVariable("urId") Long urId) {
		if(userRegistrationRepositoryPSR.exists(urId)){
			userRegistration.setUserRegistrationId(urId);
			userRegistrationRepositoryPSR.save(userRegistration);
		    return ResponseEntity.accepted().body(userRegistration);
		}
			else{
				 Map<String, Object> dataMap = new HashMap<String, Object>();
				  dataMap.put("message", "User registration Id is not exist!");
				  dataMap.put("status", HttpStatus.FOUND);
				  dataMap.put("User registration id", urId); 
				  new HashMap<String, Object>(dataMap); 
		}
		return ResponseEntity.accepted().body(userRegistration);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	 public void deletePlotInfo(@RequestBody @Valid UserRegistration userRegistration){
		if(userRegistration!=null){
		     userRegistrationRepositoryPSR.delete(userRegistration);
		}
		else{
			new Throwable("User registration Id is not exist!");
			new UserRegistration();
		}
		
	 }

}
