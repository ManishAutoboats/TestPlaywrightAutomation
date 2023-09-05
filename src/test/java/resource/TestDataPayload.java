package resource;

import java.util.ArrayList;

import com.github.javafaker.Faker;

import requestPojo.LocationChildData;
import requestPojo.RequestPlaceData;

public class TestDataPayload {

	RequestPlaceData r = new RequestPlaceData();
	LocationChildData l = new LocationChildData();
    Faker f= new Faker();
	public RequestPlaceData dataPayload() {

		l.setLat(-38.383494);
		l.setLng(33.427362);
		r.setLocation(l);
		r.setAccuracy(50);
		r.setName(f.name().firstName());
		r.setPhone_number("9865678");
		r.setAddress(f.address().city());

		ArrayList<String> list = new ArrayList<>();
		list.add("shoepark");
		list.add("shoe");

		r.setTypes(list);
		r.setWebsite("https://google.com");
		r.setLanguage("English");
		return r;

	}

}
