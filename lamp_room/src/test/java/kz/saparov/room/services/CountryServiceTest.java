package kz.saparov.room.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import kz.saparov.room.entity.Country;
import kz.saparov.room.repository.CountryRepository;
import kz.saparov.room.service.CountryService;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceTest {
	
	@Mock
	CountryRepository countryRepository;
	
	@InjectMocks
	CountryService countryService;
	
	@Test
	public void getAllCountriesTest() {
		
		List<Country> list = new ArrayList<>();
		
		list.add(new Country("KZ", "Казахстан"));
		list.add(new Country("RU", "Россия"));
		list.add(new Country("AU", "Австралия"));
		
		when(countryRepository.findAll()).thenReturn(list);
		
		List<Country> countyList = countryService.showAll();
		
		assertEquals(3, countyList.size());
        verify(countryRepository, times(1)).findAll();
	}
	
	
	@Test
	public void shouldReturnJapanCountry() {
		
		String ip = "140.242.222.12";
		
		Country country = countryService.getClientCountryByIp(ip);
		System.out.println(country.getName());
		
		assertEquals("Japan", country.getName());
		
	}
}
