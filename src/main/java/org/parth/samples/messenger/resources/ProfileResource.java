package org.parth.samples.messenger.resources;

import java.util.List;

import org.parth.samples.messenger.model.Message;
import org.parth.samples.messenger.model.Profile;
import org.parth.samples.messenger.service.ProfileService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON) 

public class ProfileResource {

	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllProfile();
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName){
		profileService.removeProfile(profileName);
	}
	 
	@GET
	@Path("/{profileName}")
	  
	public Profile test(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}
	
}
