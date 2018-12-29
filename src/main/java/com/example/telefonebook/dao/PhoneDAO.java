package com.example.telefonebook.dao;

import com.example.telefonebook.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneDAO extends JpaRepository<Phone, Integer> {

    Phone findById(int id);

    void deleteById(int id);
}
