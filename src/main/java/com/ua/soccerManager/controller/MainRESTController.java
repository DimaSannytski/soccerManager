package com.ua.soccerManager.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ua.soccerManager.entity.enums.Country;
import com.ua.soccerManager.entity.enums.PlayerStyle;

@RestController
public class MainRESTController {
	@RequestMapping(value = "/getcountrys", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Country> getCountrys() {
		return Arrays.asList(Country.values());
	}

	@RequestMapping(value = "/getplayerstyles", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<PlayerStyle> getPlayerStyles() {
		return Arrays.asList(PlayerStyle.values());
	}
}
