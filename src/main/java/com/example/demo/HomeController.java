package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String home(Model model){
        Person person = new Person();
        person.setName("Ermias G");
        person.setSsn("555-333-2222");

        Passport passport = new Passport();
        passport.setPassportNumber(444344434);
        passport.setExpirationDate("10-23-2022");

        person.setPassport(passport);
        personRepository.save(person);

        model.addAttribute("persons",personRepository.findAll());

        return "App";
    }
}
