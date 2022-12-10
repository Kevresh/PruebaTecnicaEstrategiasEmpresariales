package com.crud.pruebatecnica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class PruebaTecnicaApplication{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaApplication.class, args);
    }

    /*@Override
    public void run(String... args) {
        String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       int result = jdbcTemplate.update(sql, "1193534149","Kevin", "Alexis", "Gallego", "Albarracin", "password", "kevin@gmail.com","123456789", 1, 1);

        if (result > 0){
            System.out.println("A new row has been inserted");
        }
    }*/
}
