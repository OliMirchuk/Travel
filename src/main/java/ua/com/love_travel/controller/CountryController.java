package ua.com.love_travel.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.love_travel.dto.CountryDTO;
import ua.com.love_travel.dto.DtoUtilMapper;
import ua.com.love_travel.entity.Country;
import ua.com.love_travel.service.CountryService;


@Controller
public class CountryController {
	
	  @Autowired
	    private CountryService countryService;

	    @RequestMapping(value = "/newCountry", method = RequestMethod.GET)
	    public String saveCountry(){

	       return "views-admin-newCountry";
	    }

	    @RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	    public @ResponseBody List<CountryDTO> saveCountry(@RequestBody Country country){

	        countryService.save(country);

	        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

	    }

	    @RequestMapping(value = "/loadCountries", method = RequestMethod.POST)
	    public @ResponseBody List<CountryDTO> loadCountries(){


	        return DtoUtilMapper.countriesToCountriesDTOs(countryService.findAll());

	    }

	    @RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.GET)
	    public String loadCountries(@PathVariable String id){

	        countryService.delete(Integer.parseInt(id));

	        return "redirect:/newCountry";

	    }
}
