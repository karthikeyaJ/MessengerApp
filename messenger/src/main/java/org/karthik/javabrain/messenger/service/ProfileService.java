package org.karthik.javabrain.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.karthik.javabrain.messenger.database.DatabaseClass;
import org.karthik.javabrain.messenger.model.Profile;


@SuppressWarnings("unused")
public class ProfileService {

private static Map<String,Profile> profiles=DatabaseClass.getProfiles(); 
	public ProfileService()
	{
	profiles.put("Karthikeya",new Profile(1L, "Karthikeya", "Venkata Karthikeya", "Jangal"));
	profiles.put("Vyna",new Profile(2L, "Vynatheya", "Venkata Vynatheya", "Jangal"));
	}
	
	
	public Profile getProfile(String profileName)
	{		
		return profiles.get(profileName);
	}
	
	public List<Profile> getProfiles()
	{
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public void deleteProfile(String profileName)
	{
		profiles.remove(profileName);
		
	}
	public Profile updateProfile(Profile profile)
	{
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}
	
	
	
}
