package com.example.telefonebook.services;

import com.example.telefonebook.dao.ContactDao;
import com.example.telefonebook.models.Contact;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private ContactDao contactDao;

    public ContactService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void save(Contact contact) {
        if (contact != null) contactDao.save(contact);
    }

    public List<Contact> findAll() {
        return contactDao.findAll();
    }

    public List<Contact> findAllByName(String name) {
        return contactDao.findAllByName(name);
    }


    public Contact findContactById(int id) {
        return contactDao.findById(id);
    }

    public void update(int id) {
        Contact contact = findContactById(id);
        save(contact);
    }

    public List<Contact> sortByName() {
        return contactDao.findAll(Sort.by("name"));
    }

    public void deleteById(int id){
        contactDao.deleteById(id);
    }
}
