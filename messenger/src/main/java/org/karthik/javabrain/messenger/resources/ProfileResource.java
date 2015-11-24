package org.karthik.javabrain.messenger.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.karthik.javabrain.messenger.model.Profile;
import org.karthik.javabrain.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {

	ProfileService profileservices=new ProfileService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getProfiles()
	{
		return profileservices.getProfiles();
	}
	

	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_XML)
	public Profile getProfileByName(@PathParam("profileName") String profile)
	{
		return profileservices.getProfile(profile);
	}
	
	
	@POST
	public Profile addProfile(Profile profile)
	{
		return profileservices.addProfile(profile);
	}
	
	
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam ("profileName") String profileName ,Profile profile)
	{
		profile.setProfileName(profileName);
		return profileservices.updateProfile(profile);	
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam ("profileName") String profileName)
	{
		profileservices.deleteProfile(profileName);	
	}
	
     
}

