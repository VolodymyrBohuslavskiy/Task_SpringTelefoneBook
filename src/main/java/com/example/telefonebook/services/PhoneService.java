package com.example.telefonebook.services;

import com.example.telefonebook.dao.PhoneDAO;
import com.example.telefonebook.models.Phone;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {
    private PhoneDAO phoneDAO;

    public PhoneService(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    public void save(Phone phone) {
        phoneDAO.save(phone);
    }

    public Phone findById(int id) {
        return phoneDAO.findById(id);
    }

    public void deleteById(int id) {
        phoneDAO.deleteById(id);
    }
}
