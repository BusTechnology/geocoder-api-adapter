package api;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.util.ArrayList;

import org.junit.Test;

import model.GoogleGeocoderResponse;

public class GeocodeControllerTest {
	
	//not mocked for Travis
	//@Test
	public void shouldRungeocode() throws Exception {
		GoogleGeocoderResponse response = new GoogleGeocoderResponse("UNION TURNPIKE & CHEVY CHASE STREET,QUEENS,NY,11366", 40.72841260386642, -73.78359977498464);
		String address = "union turnpike and chevy chase";
		
		GoogleGeocoderResponse googleGeocoderResponse = new GeocodeController().geocode(address);
		assertEquals(googleGeocoderResponse, response);
	}
	
	//@Test
	public void shouldRunautocomplete() throws Exception {
		String address = "empire state";
		ArrayList<GoogleGeocoderResponse> googleGeocoderResponse = new GeocodeController().autocomplete(address);
		
		assertThat(googleGeocoderResponse.size(), is(greaterThanOrEqualTo(2)));
	}
}
