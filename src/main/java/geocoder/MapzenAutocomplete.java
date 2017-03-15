package geocoder;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.GoogleGeocoderResponse;
import okhttp3.HttpUrl;

public class MapzenAutocomplete extends NYCMapzen {
	// TODO: factor bounding box into configuration
	protected static String BASE_URL = "https://search.mapzen.com/v1/autocomplete?&boundary.rect.min_lat=40.477480&boundary.rect.min_lon=-74.259060&boundary.rect.max_lat=40.910970&boundary.rect.max_lon=-73.700152";

	public ArrayList<GoogleGeocoderResponse> autocomplete(String input) {
		HttpUrl urlWithKey = null;
		try {
			urlWithKey = keyVerify();
//			System.out.println(urlWithKey);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String response = null;
		try {
			response = search(urlWithKey, "text", input).body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList<GoogleGeocoderResponse> googleGeocoderResponse = getAutocompleteResponsesFromString(response);

		return googleGeocoderResponse;
	}

	ArrayList<GoogleGeocoderResponse> getAutocompleteResponsesFromString(String response) {
		String formatted_address;
		Double latitude;
		Double longitude;
		JSONObject jsnobject;
		ArrayList<GoogleGeocoderResponse> googleGeocoderResponse = new ArrayList<GoogleGeocoderResponse>();

		try {
			jsnobject = new JSONObject(response);
			JSONArray results = jsnobject.getJSONArray("features");
			for(int i=0; i<results.length(); i++){
				JSONObject sfs = (JSONObject) results.get(i);
				JSONObject geometry = (JSONObject) sfs.get("geometry");
				JSONArray coordinates = geometry.getJSONArray("coordinates");
				latitude = Double.parseDouble(String.valueOf(coordinates.get(1)));
				longitude = Double.parseDouble(String.valueOf(coordinates.get(0)));
	
				JSONObject properties = (JSONObject) sfs.get("properties");
				formatted_address = (String) properties.get("label");
				googleGeocoderResponse.add(new GoogleGeocoderResponse(formatted_address.toString(), latitude, longitude));
			}

		} catch (JSONException e) {
			System.err.println("Could not decode response from " + response);
		}
		return googleGeocoderResponse;
	}
}
