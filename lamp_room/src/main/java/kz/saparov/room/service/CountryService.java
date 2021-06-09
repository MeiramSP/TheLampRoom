package kz.saparov.room.service;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import kz.saparov.room.entity.Country;
import kz.saparov.room.repository.CountryRepository;

@Service
public class CountryService {
	
	private RestTemplate restTemplate;
	private CountryRepository countryRepository;

	@Autowired
	public CountryService(CountryRepository countryRepository, RestTemplate restTemplate) {
		this.countryRepository = countryRepository;
		this.restTemplate = restTemplate;
	}
	
	public List<Country> showAll() {
		return countryRepository.findAll();
	}
	
	
	public Country getClientCountryByIp(String clientIp) {
		
		String uri = "http://ipwhois.app/json/" + clientIp + "?/objects=country_code, country";
		
		// get county code from external rest api
		Country clientCountry = restTemplate.getForObject(uri, Country.class);
		
		return clientCountry;
	}
	
	
	
}
