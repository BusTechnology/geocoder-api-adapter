package geocoder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import model.GoogleGeocoderResponse;


public class NYCGeoclientTest {
	
	//@Test
	public void urlShouldContainIDAndKey() throws Exception {

		NYCGeoclient nycGeoclient = new NYCGeoclient();
		String httpUrl = nycGeoclient.keyVerify().toString();
		
		assertThat("url should contain app_id", httpUrl.contains("app_id"));
		assertThat("url should contain app_key", httpUrl.contains("app_key"));		
	}
	
	@Test
	public void responseShouldHaveCorrectFormat() {
		String response = new NYCGeoclient().responseStringToGeocoderResponse(getSampleGeoClientResponse()).toString();
		assertThat("response should contain formattedAddress", response.contains("formattedAddress"));
		assertThat("response should contain latitude", response.contains("latitude"));
		assertThat("response should contain longitude", response.contains("longitude"));
	}

	@Test 
	public void responseIsNull() {
		GoogleGeocoderResponse response = new NYCGeoclient().responseStringToGeocoderResponse(getEmptyGeoClientResponse());
		assertNull(response);
	}
	
	private String getSampleGeoClientResponse() {
		return "{\"input\":\"seneca and woodbine\",\"results\":[{\"level\":\"1\",\"status\":\"POSSIBLE_MATCH\",\"request\":\"intersection [crossStreetOne=seneca, crossStreetTwo=woodbine, borough=QUEENS, compassDirection=null]\",\"response\":{\"assemblyDistrict\":\"38\",\"boroughCode1In\":\"4\",\"censusTract1990\":\" 549  \",\"censusTract2000\":\" 549  \",\"censusTract2010\":\" 549  \",\"cityCouncilDistrict\":\"34\",\"civilCourtDistrict\":\"03\",\"communityDistrict\":\"405\",\"communityDistrictBoroughCode\":\"4\",\"communityDistrictNumber\":\"05\",\"communitySchoolDistrict\":\"24\",\"congressionalDistrict\":\"07\",\"crossStreetNamesFlagIn\":\"E\",\"dcpPreferredLgcForStreet1\":\"01\",\"dcpPreferredLgcForStreet2\":\"01\",\"dotStreetLightContractorArea\":\"4\",\"fireBattalion\":\"45\",\"fireCompanyNumber\":\"140\",\"fireCompanyType\":\"L\",\"fireDivision\":\"14\",\"firstBoroughName\":\"QUEENS\",\"firstStreetCode\":\"46189001010\",\"firstStreetNameNormalized\":\"SENECA AVENUE\",\"geosupportFunctionCode\":\"2\",\"geosupportReturnCode\":\"00\",\"healthArea\":\"2200\",\"healthCenterDistrict\":\"46\",\"instructionalRegion\":\"QN\",\"interimAssistanceEligibilityIndicator\":\"E\",\"intersectingStreet1\":\"461890\",\"intersectingStreet2\":\"467990\",\"latitude\":40.702371361769984,\"lionNodeNumber\":\"0029898\",\"listOfPairsOfLevelCodes\":\"MMMM\",\"longitude\":-73.90695021078082,\"numberOfIntersectingStreets\":\"2\",\"numberOfStreetCodesAndNamesInList\":\"02\",\"policePatrolBoroughCommand\":\"6\",\"policePrecinct\":\"104\",\"sanbornBoroughCode1\":\"4\",\"sanbornBoroughCode2\":\"4\",\"sanbornPageNumber1\":\"054\",\"sanbornPageNumber2\":\"053\",\"sanbornVolumeNumber1\":\"03\",\"sanbornVolumeNumber2\":\"03\",\"sanitationCollectionSchedulingSectionAndSubsection\":\"3C\",\"sanitationDistrict\":\"405\",\"secondStreetCode\":\"46799001010\",\"secondStreetNameNormalized\":\"WOODBINE STREET\",\"stateSenatorialDistrict\":\"12\",\"streetCode1\":\"46189001\",\"streetCode2\":\"46799001\",\"streetName1\":\"SENECA AVENUE\",\"streetName1In\":\"SENECA\",\"streetName2\":\"WOODBINE STREET\",\"streetName2In\":\"WOODBINE\",\"workAreaFormatIndicatorIn\":\"C\",\"xCoordinate\":\"1010050\",\"yCoordinate\":\"0195183\",\"zipCode\":\"11385\"}}],\"parseTree\":null,\"policy\":null}";
	}
	
	private String getEmptyGeoClientResponse(){
		return "{\"id\":\"ip-10-168-36-95-292850-1489607537691\",\"status\":\"REJECTED\",\"input\":\"broadway and 1400th street\",\"results\":[],\"parseTree\":null,\"policy\":null}";
	}
}
