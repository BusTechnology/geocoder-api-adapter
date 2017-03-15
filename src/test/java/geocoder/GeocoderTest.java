package geocoder;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import okhttp3.HttpUrl;
import okhttp3.Response;

public class GeocoderTest {

	private static NYCGeoclient nycGeoclient;
	
	@Before
	public void init() {
		nycGeoclient = new NYCGeoclient();
	}
	// Not mocked for Travis use
	//@Test
	public void shouldReceiveResponse() throws IOException {

		Response response = buildSearchRequest("input");
        assertTrue("response is successful", response.isSuccessful());
	}
	
	//@Test(expected=IOException.class)
	public void shouldThrowException() throws IOException {
		Response response = buildSearchRequest("aa");
        assertTrue("response is successful", response.isSuccessful());
	}
	
	public Response buildSearchRequest(String query) throws IOException {
		HttpUrl urlWithKey = null;
		try {
			urlWithKey = nycGeoclient.keyVerify();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Response response = Geocoder.search(urlWithKey, query, "123");
		return response;
	}
}
