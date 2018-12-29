package com.example.telefonebook.dao;

import com.example.telefonebook.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ContactDao extends JpaRepository<Contact, Integer> {

    List<Contact> findAllByNameAndId(String name, int id);

    List<Contact> findAllByName(String name);

    Contact findById(int id);

    Contact findBySurname(String surname);

    @Query("select c from Contact c where c.surname=:surname")
    Contact customSurchBySurname(String surname);

    @Query("select c from Contact c where c.name=:name")
    Contact customSurchByName(String name);

    void deleteById(int id);



}
