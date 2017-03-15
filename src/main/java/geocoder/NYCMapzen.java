package geocoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.GoogleGeocoderResponse;

import java.io.IOException;

import okhttp3.HttpUrl;

public class NYCMapzen extends Geocoder {

	protected static final String APP_KEY = System.getenv("MAPZEN_KEY");
	// TODO: factor bounding box into configuration
	protected static String BASE_URL = "https://search.mapzen.com/v1/search?&boundary.rect.min_lat=40.477480&boundary.rect.min_lon=-74.259060&boundary.rect.max_lat=40.910970&boundary.rect.max_lon=-73.700152";

	@Override
	public HttpUrl keyVerify() throws Exception {
		if (APP_KEY == null) {
			throw new Exception("Missing app_key");
		}

		HttpUrl	url = HttpUrl.parse(BASE_URL).newBuilder()
				.addQueryParameter("app_key", APP_KEY)
				.build();
		return url;
	}

	@Override
	public GoogleGeocoderResponse run(String input) {
		HttpUrl urlWithKey = null;
		try {
			urlWithKey = keyVerify();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String response = null;
		try {
			response = search(urlWithKey, "text", input).body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}

		GoogleGeocoderResponse googleGeocoderResponse = getGeocoderResposeFromString(response);

		return googleGeocoderResponse;
	}

	GoogleGeocoderResponse getGeocoderResposeFromString(String response) {
		String formatted_address;
		Double latitude;
		Double longitude;
		JSONObject jsnobject = null;
		GoogleGeocoderResponse googleGeocoderResponse = null;
		try {
			jsnobject = new JSONObject(response);
			JSONArray results = jsnobject.getJSONArray("features");
			JSONObject sfs = (JSONObject) results.get(0);
			JSONObject geometry = (JSONObject) sfs.get("geometry");
			JSONArray coordinates = geometry.getJSONArray("coordinates");
			latitude = Double.parseDouble(String.valueOf(coordinates.get(1)));
			longitude = Double.parseDouble(String.valueOf(coordinates.get(0)));

			JSONObject properties = (JSONObject) sfs.get("properties");
			formatted_address = (String) properties.get("label");
			googleGeocoderResponse = new GoogleGeocoderResponse(formatted_address.toString(), latitude, longitude);
		} catch (JSONException e) {
			System.err.println("Could not decode response from " + response);
		}
		return googleGeocoderResponse;
	}
}

