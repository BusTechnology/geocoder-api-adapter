package model;

import java.io.Serializable;

public class GeocoderResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String formattedAddress;
	Double latitude;
	Double longitude;
	
	public GeocoderResponse(String formattedAddress, Double latitude, Double longitude) {
		super();
		this.formattedAddress = formattedAddress;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public GoogleGeocoderResponse toGoogle(){
		return new GoogleGeocoderResponse(formattedAddress, latitude, longitude);
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

    @Override
    public String toString() {
    	return "GeocoderResponse{" +
    			"formattedAddress='" + formattedAddress + '\'' +
    			", latitude='" + latitude + '\'' +
    			", longitude='" + longitude + '\'' +
    			'}';
    }
}
