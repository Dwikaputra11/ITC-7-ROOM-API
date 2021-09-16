package com.example.itc_databaseapiproject.model;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("abbr")
	private String abbr;

	@SerializedName("logos")
	private Logos logos;

	@SerializedName("slug")
	private String slug;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAbbr(String abbr){
		this.abbr = abbr;
	}

	public String getAbbr(){
		return abbr;
	}

	public void setLogos(Logos logos){
		this.logos = logos;
	}

	public Logos getLogos(){
		return logos;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	@Override
 	public String toString(){
		return
			"DataItem{" +
			"name = '" + name + '\'' +
			",id = '" + id + '\'' +
			",abbr = '" + abbr + '\'' +
			",logos = '" + logos + '\'' +
			",slug = '" + slug + '\'' +
			"}";
		}
}