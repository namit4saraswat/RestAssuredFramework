package resources;

public enum APIResources {
	
	//Place Validation API's
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json"),
	
	//ReqRes API's
	listUsers("/api/users"),
	createuser("/api/users");
	
	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

}


