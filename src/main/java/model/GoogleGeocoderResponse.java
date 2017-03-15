package model;


public class GoogleGeocoderResponse extends GeocoderResponse {
	private static final long serialVersionUID = 1L;

	private Double northeastLatitude = null;
	private Double northeastLongitude = null;
	private Double southwestLatitude = null;
	private Double southwestLongitude = null;

	public GoogleGeocoderResponse(String formattedAddress, Double latitude, Double longitude) {
		super(formattedAddress, latitude, longitude);

		// code courtesy StackOverflow: http://stackoverflow.com/questions/12448629/create-a-bounding-box-around-the-geo-point

		Double longitudeD = (Math.asin(1000 / (6378000 * Math.cos(Math.PI*latitude/180))))*180/Math.PI;
		Double latitudeD = (Math.asin((double)1000 / (double)6378000))*180/Math.PI;

		this.northeastLatitude = latitude+(latitudeD);
		this.northeastLongitude = longitude+(longitudeD);

		this.southwestLatitude = latitude-(latitudeD);
		this.southwestLongitude= longitude-(longitudeD);
	}

	public Double getNortheastLatitude() {
		return northeastLatitude;
	}

	public void setNortheastLatitude(Double northeastLatitude) {
		this.northeastLatitude = northeastLatitude;
	}

	public Double getNortheastLongitude() {
		return northeastLongitude;
	}

	public void setNortheastLongitude(Double northeastLongitude) {
		this.northeastLongitude = northeastLongitude;
	}

	public Double getSouthwestLatitude() {
		return southwestLatitude;
	}

	public void setSouthwestLatitude(Double southwestLatitude) {
		this.southwestLatitude = southwestLatitude;
	}

	public Double getSouthwestLongitude() {
		return southwestLongitude;
	}

	public void setSouthwestLongitude(Double southwestLongitude) {
		this.southwestLongitude = southwestLongitude;
	}

    @Override
    public String toString() {
    	return "GoogleGeocoderResponse{" +
    			"formattedAddress='" + formattedAddress + '\'' +
    			", latitude='" + latitude + '\'' +
    			", longitude='" + longitude + '\'' +
    			", northeastLatitude='" + northeastLatitude + '\'' +
    			", northeastLongitude='" + northeastLongitude + '\'' +
    			", southwestLatitude='" + southwestLatitude + '\'' +
    			", southwestLongitude='" + southwestLongitude + '\'' +
    			'}';
    }
    
    @Override
    public boolean equals(Object obj) {
    	GoogleGeocoderResponse response = (GoogleGeocoderResponse) obj;
    	boolean status = false;
    	if(this.formattedAddress.equalsIgnoreCase(response.formattedAddress)) {
    		status = true;
    	}
    	return status;
    }

}
