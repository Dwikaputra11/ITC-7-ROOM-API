package com.example.itc_databaseapiproject.model;

import com.google.gson.annotations.SerializedName;

public class Logos{

	@SerializedName("light")
	private String light;

	@SerializedName("dark")
	private String dark;

	public void setLight(String light){
		this.light = light;
	}

	public String getLight(){
		return light;
	}

	public void setDark(String dark){
		this.dark = dark;
	}

	public String getDark(){
		return dark;
	}

	@Override
 	public String toString(){
		return 
			"Logos{" + 
			"light = '" + light + '\'' + 
			",dark = '" + dark + '\'' + 
			"}";
		}
}