package org.parth.samples.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.parth.samples.messenger.database.DatabaseClass;
import org.parth.samples.messenger.model.Profile;

public class ProfileService {
	

	private Map<String, Profile> profiles = DatabaseClass.getProfiles(); // get the static instance of the Profile Map and do different operations on it
	
	public ProfileService(){
		profiles.put("Parth Patel ", new Profile(1L,"Parth Patel", "Parth", "Patel"));
	}
	public List<Profile> getAllProfile(){
		return new ArrayList<Profile>(profiles.values());
		
	}
	
	public Profile getProfile(String profileName){
		return (profiles.get(profileName));
	}
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile){
		
		if(profile.getId()<=0){
			return null;
		}
		else{
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
	

}
