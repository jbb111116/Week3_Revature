package com.revature.services;

import java.util.HashMap;
import java.util.Map;

public class DisneyService {
	private Map<String, String> disneyCharacterMap = new HashMap<>();
	
	
	{
		disneyCharacterMap.put("Mulan","Mulan");
		disneyCharacterMap.put("TheLionKing", "Simba");
		disneyCharacterMap.put("Lilo&Stitch", "Stitch");
		
	}
	// Hold a main character as a value mapped by a key of the movie name
	public String getCharacter(String movie) {
		return disneyCharacterMap.getOrDefault(movie, "Unknown");
	}
	
	public void setCharacter(String movie, String character) {
		disneyCharacterMap.put(movie,character);
	}
	
}
