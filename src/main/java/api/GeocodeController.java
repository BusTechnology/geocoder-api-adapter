package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import geocoder.MapzenAutocomplete;
import geocoder.NYCGeoclient;
import geocoder.NYCMapzen;
import model.GoogleGeocoderResponse;

@RestController
public class GeocodeController 
{

	@RequestMapping(value = "/geocode",  method = RequestMethod.GET)
	public GoogleGeocoderResponse geocode(@RequestParam(value="address") String address) throws Exception{
		GoogleGeocoderResponse r = null;
		
		address = address.replace("&", " and ");
		
		if (address.toLowerCase().contains("and")) {
			NYCGeoclient nycGeoclient = new NYCGeoclient();
			r = nycGeoclient.run(address);
		} else {
			NYCMapzen nycMapzen = new NYCMapzen();
			r = nycMapzen.run(address);
		}
		return r;
	}
	
	@RequestMapping(value = "/autocomplete",  method = RequestMethod.GET)
	public ArrayList<GoogleGeocoderResponse> autocomplete(@RequestParam(value="address") String address) throws Exception{
		ArrayList<GoogleGeocoderResponse> r = new ArrayList<GoogleGeocoderResponse>();
		
		MapzenAutocomplete mapzenAutocomplete = new MapzenAutocomplete();
		r = mapzenAutocomplete.autocomplete(address);

		return r;
	}
}
