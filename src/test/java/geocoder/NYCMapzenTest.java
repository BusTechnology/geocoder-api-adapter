package geocoder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import model.GoogleGeocoderResponse;


public class NYCMapzenTest {

	//@Test
	public void urlShouldContainKey() throws Exception {

		NYCMapzen nycMapzen = new NYCMapzen();
		String httpUrl = nycMapzen.keyVerify().toString();
		
		assertThat("url should contain app_key", httpUrl.contains("app_key"));		
	}
	
	@Test
	public void responseShouldHaveCorrectFormat() {

		String response = new NYCMapzen().getGeocoderResposeFromString(getGeoderResponse()).toString();
		assertThat("response should contain formattedAddress", response.contains("formattedAddress"));
		assertThat("response should contain latitude", response.contains("latitude"));
		assertThat("response should contain longitude", response.contains("longitude"));
	}

	@Test 
	public void responseIsNull() {
		GoogleGeocoderResponse response = new NYCMapzen().getGeocoderResposeFromString(getEmptyGeocoderResponse());
		assertNull(response);
	}
	
	private String getGeoderResponse(){
		return "{\"geocoding\":{\"version\":\"0.2\",\"attribution\":\"https://search.mapzen.com/v1/attribution\",\"query\":{\"text\":\"empire state\",\"tokens\":[\"empire\",\"state\"],\"size\":10,\"private\":false,\"boundary.rect.min_lat\":40.47748,\"boundary.rect.max_lat\":40.91097,\"boundary.rect.min_lon\":-74.25906,\"boundary.rect.max_lon\":-73.700152},\"engine\":{\"name\":\"Pelias\",\"author\":\"Mapzen\",\"version\":\"1.0\"},\"timestamp\":1489549868441},\"type\":\"FeatureCollection\",\"features\":[{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[-73.986027,40.748517]},\"properties\":{\"id\":\"way:34633854\",\"gid\":\"openstreetmap:venue:way:34633854\",\"layer\":\"venue\",\"source\":\"openstreetmap\",\"source_id\":\"way:34633854\",\"name\":\"Empire State Building\",\"housenumber\":\"350\",\"street\":\"5th Avenue\",\"postalcode\":\"10018\",\"accuracy\":\"point\",\"country\":\"United States\",\"country_gid\":\"whosonfirst:country:85633793\",\"country_a\":\"USA\",\"region\":\"New York\",\"region_gid\":\"whosonfirst:region:85688543\",\"region_a\":\"NY\",\"county\":\"New York County\",\"county_gid\":\"whosonfirst:county:102081863\",\"locality\":\"New York\",\"locality_gid\":\"whosonfirst:locality:85977539\",\"borough\":\"Manhattan\",\"borough_gid\":\"whosonfirst:borough:421205771\",\"neighbourhood\":\"Koreatown\",\"neighbourhood_gid\":\"whosonfirst:neighbourhood:85869391\",\"label\":\"Empire State Building, Manhattan, New York, NY, USA\"},\"bbox\":[-73.986486,40.747923,-73.984826,40.748942]},{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[-73.98597,40.74871]},\"properties\":{\"id\":\"5116597\",\"gid\":\"geonames:venue:5116597\",\"layer\":\"venue\",\"source\":\"geonames\",\"source_id\":\"5116597\",\"name\":\"Empire State Building\",\"accuracy\":\"point\",\"country\":\"United States\",\"country_gid\":\"whosonfirst:country:85633793\",\"country_a\":\"USA\",\"region\":\"New York\",\"region_gid\":\"whosonfirst:region:85688543\",\"region_a\":\"NY\",\"county\":\"New York County\",\"county_gid\":\"whosonfirst:county:102081863\",\"locality\":\"New York\",\"locality_gid\":\"whosonfirst:locality:85977539\",\"borough\":\"Manhattan\",\"borough_gid\":\"whosonfirst:borough:421205771\",\"neighbourhood\":\"Koreatown\",\"neighbourhood_gid\":\"whosonfirst:neighbourhood:85869391\",\"label\":\"Empire State Building, Manhattan, New York, NY, USA\"}},{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[-73.986,40.75]},\"properties\":{\"id\":\"9796033\",\"gid\":\"geonames:venue:9796033\",\"layer\":\"venue\",\"source\":\"geonames\",\"source_id\":\"9796033\",\"name\":\"Hampton Inn Empire State Build\",\"accuracy\":\"point\",\"country\":\"United States\",\"country_gid\":\"whosonfirst:country:85633793\",\"country_a\":\"USA\",\"region\":\"New York\",\"region_gid\":\"whosonfirst:region:85688543\",\"region_a\":\"NY\",\"county\":\"New York County\",\"county_gid\":\"whosonfirst:county:102081863\",\"locality\":\"New York\",\"locality_gid\":\"whosonfirst:locality:85977539\",\"borough\":\"Manhattan\",\"borough_gid\":\"whosonfirst:borough:421205771\",\"neighbourhood\":\"Koreatown\",\"neighbourhood_gid\":\"whosonfirst:neighbourhood:85869391\",\"label\":\"Hampton Inn Empire State Build, Manhattan, New York, NY, USA\"}},{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[-73.99222,40.70417]},\"properties\":{\"id\":\"6348414\",\"gid\":\"geonames:venue:6348414\",\"layer\":\"venue\",\"source\":\"geonames\",\"source_id\":\"6348414\",\"name\":\"Empire - Fulton Ferry State Park\",\"accuracy\":\"point\",\"country\":\"United States\",\"country_gid\":\"whosonfirst:country:85633793\",\"country_a\":\"USA\",\"region\":\"New York\",\"region_gid\":\"whosonfirst:region:85688543\",\"region_a\":\"NY\",\"county\":\"Kings County\",\"county_gid\":\"whosonfirst:county:102082361\",\"locality\":\"New York\",\"locality_gid\":\"whosonfirst:locality:85977539\",\"borough\":\"Brooklyn\",\"borough_gid\":\"whosonfirst:borough:421205765\",\"neighbourhood\":\"DUMBO\",\"neighbourhood_gid\":\"whosonfirst:neighbourhood:85869197\",\"label\":\"Empire - Fulton Ferry State Park, Brooklyn, New York, NY, USA\"}},{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[-73.986,40.7499]},\"properties\":{\"id\":\"9794863\",\"gid\":\"geonames:venue:9794863\",\"layer\":\"venue\",\"source\":\"geonames\",\"source_id\":\"9794863\",\"name\":\"Hampton Inn Manhattan-35Th St Empire State Bldg\",\"accuracy\":\"point\",\"country\":\"United States\",\"country_gid\":\"whosonfirst:country:85633793\",\"country_a\":\"USA\",\"region\":\"New York\",\"region_gid\":\"whosonfirst:region:85688543\",\"region_a\":\"NY\",\"county\":\"New York County\",\"county_gid\":\"whosonfirst:county:102081863\",\"locality\":\"New York\",\"locality_gid\":\"whosonfirst:locality:85977539\",\"borough\":\"Manhattan\",\"borough_gid\":\"whosonfirst:borough:421205771\",\"neighbourhood\":\"Koreatown\",\"neighbourhood_gid\":\"whosonfirst:neighbourhood:85869391\",\"label\":\"Hampton Inn Manhattan-35Th St Empire State Bldg, Manhattan, New York, NY, USA\"}},{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[-73.986,40.7499]},\"properties\":{\"id\":\"9854699\",\"gid\":\"geonames:venue:9854699\",\"layer\":\"venue\",\"source\":\"geonames\",\"source_id\":\"9854699\",\"name\":\"Hampton Inn 35Th Street Empire State Building\",\"accuracy\":\"point\",\"country\":\"United States\",\"country_gid\":\"whosonfirst:country:85633793\",\"country_a\":\"USA\",\"region\":\"New York\",\"region_gid\":\"whosonfirst:region:85688543\",\"region_a\":\"NY\",\"county\":\"New York County\",\"county_gid\":\"whosonfirst:county:102081863\",\"locality\":\"New York\",\"locality_gid\":\"whosonfirst:locality:85977539\",\"borough\":\"Manhattan\",\"borough_gid\":\"whosonfirst:borough:421205771\",\"neighbourhood\":\"Koreatown\",\"neighbourhood_gid\":\"whosonfirst:neighbourhood:85869391\",\"label\":\"Hampton Inn 35Th Street Empire State Building, Manhattan, New York, NY, USA\"}},{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[-73.98495,40.74813]},\"properties\":{\"id\":\"8133995\",\"gid\":\"geonames:venue:8133995\",\"layer\":\"venue\",\"source\":\"geonames\",\"source_id\":\"8133995\",\"name\":\"NY SKYRIDE at the Empire State Building\",\"accuracy\":\"point\",\"country\":\"United States\",\"country_gid\":\"whosonfirst:country:85633793\",\"country_a\":\"USA\",\"region\":\"New York\",\"region_gid\":\"whosonfirst:region:85688543\",\"region_a\":\"NY\",\"county\":\"New York County\",\"county_gid\":\"whosonfirst:county:102081863\",\"locality\":\"New York\",\"locality_gid\":\"whosonfirst:locality:85977539\",\"borough\":\"Manhattan\",\"borough_gid\":\"whosonfirst:borough:421205771\",\"neighbourhood\":\"Koreatown\",\"neighbourhood_gid\":\"whosonfirst:neighbourhood:85869391\",\"label\":\"NY SKYRIDE at the Empire State Building, Manhattan, New York, NY, USA\"}}],\"bbox\":[-73.99222,40.70417,-73.984826,40.75]}";
	}
	
	private String getEmptyGeocoderResponse(){
		return "{\"geocoding\":{\"version\":\"0.2\",\"attribution\":\"https://search.mapzen.com/v1/attribution\",\"query\":{\"text\":\"abcd\",\"size\":10,\"private\":false,\"boundary.rect.min_lat\":40.47748,\"boundary.rect.max_lat\":40.91097,\"boundary.rect.min_lon\":-74.25906,\"boundary.rect.max_lon\":-73.700152,\"querySize\":20},\"engine\":{\"name\":\"Pelias\",\"author\":\"Mapzen\",\"version\":\"1.0\"},\"timestamp\":1489605706276},\"type\":\"FeatureCollection\",\"features\":[]}";
	}
}
