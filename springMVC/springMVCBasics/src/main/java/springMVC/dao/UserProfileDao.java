package springMVC.dao;

import java.util.List;

import springMVC.model.UserProfile;



public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
