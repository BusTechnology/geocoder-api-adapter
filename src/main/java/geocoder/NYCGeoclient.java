package geocoder;

import org.apache.commons.lang3.text.WordUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.HttpUrl;

import model.GoogleGeocoderResponse;

public class NYCGeoclient extends Geocoder {

	private static final String APP_ID = System.getenv("GEOCLIENT_ID");
	private static final String APP_KEY = System.getenv("GEOCLIENT_KEY");
	private static final String BASE_URL = "https://api.cityofnewyork.us/geoclient/v1/search.json?";

	@Override
	public HttpUrl keyVerify() throws Exception {
		if (APP_ID == null) {
			throw new Exception("Missing app_id");
		}

		if (APP_KEY == null) {
			throw new Exception("Missing app_key");
		}

		HttpUrl	url = HttpUrl.parse(BASE_URL).newBuilder()
				.addQueryParameter("app_id", APP_ID)
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
			System.err.println("Key not present");
		}

		String response = null;
		try {
			response = search(urlWithKey, "input", input).body().string();
		} catch (IOException e) {
			System.err.println("Could not retreive response from " + urlWithKey);
		}

		GoogleGeocoderResponse googleGeocoderResponse = responseStringToGeocoderResponse(response);

		return googleGeocoderResponse;
	}

	GoogleGeocoderResponse responseStringToGeocoderResponse(String response) {
		StringBuilder formatted_address = new StringBuilder();
		Double latitude = null;
		Double longitude = null;

		JSONObject jsnobject = null;
		GoogleGeocoderResponse googleGeocoderResponse = null;
		try {
			jsnobject = new JSONObject(response);

			JSONArray results = jsnobject.getJSONArray("results");
			JSONObject sfs = (JSONObject) results.get(0);
			JSONObject address = (JSONObject) sfs.get("response");

			formatted_address.append(address.get("firstStreetNameNormalized"));
			formatted_address.append(" & ").append(address.get("secondStreetNameNormalized"));
			formatted_address.append(",").append(address.get("firstBoroughName"));
			formatted_address.append(",NY,").append(address.get("zipCode"));

			latitude = Double.parseDouble(String.valueOf(address.get("latitude")));
			longitude = Double.parseDouble(String.valueOf(address.get("longitude")));

			String formattedAddressString = WordUtils.capitalizeFully(formatted_address.toString());

			googleGeocoderResponse = new GoogleGeocoderResponse(formattedAddressString, latitude, longitude);
		} catch (JSONException e) {
			System.err.println("Could not decode response from " + response);
		}
		return googleGeocoderResponse;
	}
	
}

