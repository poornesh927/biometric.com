package com.biometric.controller;

import com.biometric.dto.ContactDto;
import com.biometric.dto.CustomerDto;
import com.biometric.entity.Contact;
import com.biometric.entity.Customer;
import com.biometric.service.BiometricService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class BiometricController {

    private final BiometricService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/shoppage")
    public String shopPage() {
        return "shop";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
    @PostMapping("/savecustomerdetails")
    public String saveCustomerDetails(@ModelAttribute CustomerDto customer) {
        Customer customer1 = service.saveCustomer(customer);
        if (Objects.nonNull(customer1)) {
            return "index";
        } else {
            return "shop";
        }
    }
    @PostMapping("/contactdetails")
    public String contactDetailsSave(@ModelAttribute ContactDto contactDto) {
        Contact customer1 = service.saveContactDetails(contactDto);
        if (Objects.nonNull(customer1)) {
            return "index";
        } else {
            return "shop";
        }
    }
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
    @PostMapping("/searchPages")
    public String searchPages(@ModelAttribute("search") String searchKeyword) {
        return switch (searchKeyword) {
            case "Biometric Attendance Device" -> "searchpages/Biometric Attendance Device";
            case "Biometric Attendance Machine" -> "searchpages/Biometric Attendance Machine";
            case "Biometric System Machine" -> "searchpages/Biometric System Machine";
            case "Face Attendance Device" -> "searchpages/Face Attendance Device";
            case "obbless realtime" -> "searchpages/obbless realtime";
            default -> "searchpages/not_found";
        };
    }
}
