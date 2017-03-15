package model;

public class GeoClientResponse {
    
public class Results
{
private Response response;

private String level;

private String status;

private String request;

public Response getResponse ()
{
return response;
}

public void setResponse (Response response)
{
this.response = response;
}

@Override
public String toString()
{
return "ClassPojo [response = "+response+", level = "+level+", status = "+status+", request = "+request+"]";
}
}

	class Response
	{
	    private String longitude;
		private String latitude;
	    private String firstStreetNameNormalized;
	    private String secondStreetNameNormalized;
	    private String firstBoroughName;

		public Response(String longitude, String latitude, String firstStreetNameNormalized,
				String secondStreetNameNormalized, String firstBoroughName) {
			super();
			this.longitude = longitude;
			this.latitude = latitude;
			this.firstStreetNameNormalized = firstStreetNameNormalized;
			this.secondStreetNameNormalized = secondStreetNameNormalized;
			this.firstBoroughName = firstBoroughName;
		}
		
	    public String getLongitude() {
			return longitude;
		}

		public String getLatitude() {
			return latitude;
		}

		public String getFirstStreetNameNormalized() {
			return firstStreetNameNormalized;
		}

		public String getSecondStreetNameNormalized() {
			return secondStreetNameNormalized;
		}

		public String getFirstBoroughName() {
			return firstBoroughName;
		}
}
}
