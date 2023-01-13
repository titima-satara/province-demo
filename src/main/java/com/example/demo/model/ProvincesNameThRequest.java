package com.example.demo.model;

import lombok.Data;

@Data
public class ProvincesNameThRequest {
    public String name_th;

	public String getName_th() {
		return name_th;
	}

	public void setName_th(String name_th) {
		this.name_th = name_th;
	}
}
