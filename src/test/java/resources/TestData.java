package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.CreateUser;
import pojo.Location;

public class TestData {

	public AddPlace addPlacePayload(String name, String language, String address) {
		
		AddPlace place = new AddPlace();
		place.setAccuracy(50);
		place.setAddress(address);
		place.setLanguage(language);
		Location l = new Location();
		l.setLat(3123.123);
		l.setLng(2342.133);
		place.setLocation(l);
		place.setName(name);
		place.setPhone_number("(+91)-328462782");
		List<String> list = new ArrayList<String>();
		list.add("Tea Shop");
		list.add("Clothes Shop");
		place.setTypes(list);
		place.setWebsite("https://jsdgxhh.com");
		
		return place;
	}
	
	public CreateUser createUserPayload(String name, String job) {
		CreateUser user = new CreateUser(name, job);
		user.setName(name);
		user.setJob(job);
		return user;
	}
	
}
