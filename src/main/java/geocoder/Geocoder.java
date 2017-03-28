package geocoder;

import java.io.IOException;

import model.GoogleGeocoderResponse;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class Geocoder {
	
	public abstract HttpUrl keyVerify() throws Exception;
	/*
	 * @urlWithKey - string of URL with API key(s) already present in get request
	 * @paramName - name of GET parameter to add to get request (e.g. input, text)
	 * @paramValue - value of the parameter added to get request (e.g. "123 main st") 
	 */
	public static Response search(HttpUrl urlWithKey, String paramName, String paramValue) throws IOException {
		OkHttpClient client = new OkHttpClient();
		HttpUrl	url = urlWithKey.newBuilder()
				.addQueryParameter(paramName, paramValue)
				.build();
//		System.out.println(url.toString());

		Request request = new Request.Builder()
				.url(url)
				.build(); 
		
		Response response = client.newCall(request).execute();
		
		if (!response.isSuccessful()) {
			throw new IOException("Cannot parse response: " + response);
		}

		return response;
	}
	
	public abstract GoogleGeocoderResponse run(String input);

}
