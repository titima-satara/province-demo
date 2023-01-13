package com.example.demo.repository;

import com.example.demo.model.ProvincesData;
import com.example.demo.model.ProvincesIDRequest;
import com.example.demo.model.ProvincesNameEnRequest;
import com.example.demo.model.ProvincesNameThRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class ProvincesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProvincesData> getAllProvinces(){
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT * FROM thai_provinces  \r\n");
        List<ProvincesData> result = jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper<>(ProvincesData.class));
        return result;
    }

    public List<ProvincesData> getProvincesById(ProvincesIDRequest request){
        List<Object> params = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT * FROM thai_provinces  \r\n");
        sql.append("  WHERE id = ?  \r\n");
        params.add(request.getId());

        List<ProvincesData> result = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper() {
            @Override
            public ProvincesData mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProvincesData item = new ProvincesData();
                item.setId(rs.getString("id"));
                item.setName_th(rs.getString("name_th"));
                item.setName_en(rs.getString("name_en"));
                return item;
            }
        });
        return result;
    }

    public List<ProvincesData> getProvincesByNameTh(ProvincesNameThRequest request){
        List<Object> params = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT * FROM thai_provinces  \r\n");
        sql.append("  WHERE name_th = ?  \r\n");
        params.add(request.getName_th());
        List<ProvincesData> result = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper() {
            @Override
            public ProvincesData mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProvincesData item = new ProvincesData();
                item.setId(rs.getString("id"));
                item.setName_th(rs.getString("name_th"));
                item.setName_en(rs.getString("name_en"));
                return item;
            }
        });
        return result;
    }

    public List<ProvincesData> getProvincesByNameEn(ProvincesNameEnRequest request){
        List<Object> params = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT * FROM thai_provinces  \r\n");
        sql.append("  WHERE name_en = ?  \r\n");
        params.add(request.getName_en());
        List<ProvincesData> result = jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper() {
            @Override
            public ProvincesData mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProvincesData item = new ProvincesData();
                item.setId(rs.getString("id"));
                item.setName_th(rs.getString("name_th"));
                item.setName_en(rs.getString("name_en"));
                return item;
            }
        });
        return result;
    }

    public int insertToJson(List<ProvincesData> request){
        int i = 0;
        for(ProvincesData provincesData : request){
            List<Object> params = new ArrayList<Object>();
            StringBuilder sql = new StringBuilder();
            sql.append("  INSERT INTO thai_provinces  \r\n");
            sql.append("              (id, name_th, name_en)  \r\n");
            sql.append("  VALUES (?, ?, ?)  \r\n");
            params.add(request.get(i).getId());
            params.add(request.get(i).getName_th());
            params.add(request.get(i).getName_en());

            i++;
            jdbcTemplate.update(sql.toString(), params.toArray());
        }
        return i;
    }

    public String insertProvinces(ProvincesData request){

            List<Object> params = new ArrayList<Object>();
            StringBuilder sql = new StringBuilder();
            sql.append("  INSERT INTO thai_provinces  \r\n");
            sql.append("              (id, name_th, name_en)  \r\n");
            sql.append("  VALUES (?, ?, ?)  \r\n");
            params.add(request.getId());
            params.add(request.getName_th());
            params.add(request.getName_en());

            jdbcTemplate.update(sql.toString(), params.toArray());
        return "เพิ่มข้อมูลสำเร็จ";
    }

    public String updateProvinces(ProvincesData request){

        List<Object> params = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        sql.append("  UPDATE thai_provinces  \r\n");
        sql.append("  SET name_th = ?, name_en = ?  \r\n");
        params.add(request.getName_th());
        params.add(request.getName_en());
        sql.append("  WHERE id = ?  \r\n");
        params.add(request.getId());

        jdbcTemplate.update(sql.toString(), params.toArray());
        return "แก้ไขข้อมูลสำเร็จ";
    }

    public String deleteProvincesById(ProvincesIDRequest request){

        List<Object> params = new ArrayList<Object>();
        StringBuilder sql = new StringBuilder();
        sql.append("  DELETE FROM thai_provinces  \r\n");
        sql.append("  WHERE id = ?  \r\n");
        params.add(request.getId());

        jdbcTemplate.update(sql.toString(), params.toArray());
        return "ลบข้อมูลสำเร็จ";
    }
}
