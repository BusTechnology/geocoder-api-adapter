# geocoder-api-adapter

[![Build Status](https://travis-ci.org/BusTechnology/geocoder-api-adapter.svg?branch=master)](https://travis-ci.org/BusTechnology/geocoder-api-adapter)

Adapter (shim) microservice that :

  a. accepts geocode or autocomplete input based upon the parameters of mega-corp's geocoder
  
  b. redirects geocoding responses to either Mapzen's Pelias or NYCGeoclient based upon input
  
  c. returns a response in the format of mega-corp's geocoder
  
## Setup:

  Set environment variables GEOCLIENT_ID , GEOCLIENT_KEY, and MAPZEN_KEY . 
  
## Run quickly:

  mvn spring-boot:run
  
