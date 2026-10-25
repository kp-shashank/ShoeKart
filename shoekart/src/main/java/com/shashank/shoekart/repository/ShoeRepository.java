package com.shashank.shoekart.repository;

import com.shashank.shoekart.model.Shoe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoeRepository {

    private final JdbcTemplate jdbcTemplate;

    public ShoeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Shoe> shoeRowMapper = (rs, rowNum) -> {
        Shoe shoe = new Shoe();
        shoe.setId(rs.getInt("id"));
        shoe.setName(rs.getString("name"));
        shoe.setBrand(rs.getString("brand"));
        shoe.setPrice(rs.getDouble("price"));
        shoe.setSize(rs.getInt("size"));
        shoe.setStock(rs.getInt("stock"));
        return shoe;
    };

    // CREATE
    public int save(Shoe shoe) {
        return jdbcTemplate.update(
            "INSERT INTO shoes (name, brand, price, size, stock) VALUES (?, ?, ?, ?, ?)",
            shoe.getName(), shoe.getBrand(), shoe.getPrice(), shoe.getSize(), shoe.getStock()
        );
    }

    // READ - all
    public List<Shoe> findAll() {
        return jdbcTemplate.query("SELECT * FROM shoes", shoeRowMapper);
    }

    // READ - by ID
    public Shoe findById(int id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM shoes WHERE id = ?",
            shoeRowMapper,
            id
        );
    }

    // UPDATE
    public int update(Shoe shoe) {
        return jdbcTemplate.update(
            "UPDATE shoes SET name = ?, brand = ?, price = ?, size = ?, stock = ? WHERE id = ?",
            shoe.getName(), shoe.getBrand(), shoe.getPrice(), shoe.getSize(), shoe.getStock(), shoe.getId()
        );
    }

    // DELETE
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM shoes WHERE id = ?", id);
    }
}
