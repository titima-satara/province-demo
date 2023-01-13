package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Data
public class ProvincesToJson {
    public int id;
    public String name_th;
    public String name_en;
    public int geography_id;
    public String created_at;
    public String updated_at;
    public String deleted_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_th() {
		return name_th;
	}
	public void setName_th(String name_th) {
		this.name_th = name_th;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public int getGeography_id() {
		return geography_id;
	}
	public void setGeography_id(int geography_id) {
		this.geography_id = geography_id;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
}
