package com.example.telefonebook.controllers;

import com.example.telefonebook.models.Contact;

import com.example.telefonebook.models.Phone;
import com.example.telefonebook.services.ContactService;
import com.example.telefonebook.services.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@AllArgsConstructor
public class mainController {
    private ContactService contactService;
    private PhoneService phoneService;

    @GetMapping("/")
    public String showAll(Model model) {
        List<Contact> contacts = contactService.sortByName();
        model.addAttribute("contacts", contacts);
        return "index";
    }

    @PostMapping("/reg")
    public String reg(Contact contact, String phone) {
        final Phone phone1 = new Phone(phone, contact);
        phoneService.save(phone1);
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(phone1);
        contact.setPhones(phones);
        contactService.save(contact);
        return "redirect:/";
    }

    @GetMapping("/contact{id}")
    public String seeContact(@PathVariable int id, Model model) {
        model.addAttribute("contact", contactService.findContactById(id));
        return "contact";
    }

    @PostMapping("/addphone-{id}")
    public String addphone(@PathVariable int id, @RequestParam String number) {
        Contact contact1 = contactService.findContactById(id);
        Phone phone = new Phone(number, contact1);
        List<Phone> phones = contact1.getPhones();
        phones.add(phone);
        contact1.setPhones(phones);
        phoneService.save(phone);
        return "redirect:/";
    }

    @PostMapping("/change")
    public String change(Contact contact) {
        contactService.save(contact);
        return "contact";
    }

    @PostMapping("/del{id}")
    public String deleteById(@PathVariable int id) {
        contactService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/phone-{id}")
    public String phone(@PathVariable int id, Model model){
        model.addAttribute(phoneService.findById(id));
        return "phone";
    }

    @PostMapping("/delphone-{id}")
    public String delphone(@PathVariable int id){
        Phone phone = phoneService.findById(id);
        phone.setContact(null);
        phoneService.deleteById(id);
        return "redirect:/";
    }


    @PostMapping("/updatephone-{id}")
    public String updatePhone(@PathVariable int id, String number){
        Phone phone = phoneService.findById(id);
        phone.setNumber(number);
        phoneService.save(phone);
        return "redirect:/";
    }
}
