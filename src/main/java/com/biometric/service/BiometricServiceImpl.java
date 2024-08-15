package com.biometric.service;

import com.biometric.dto.ContactDto;
import com.biometric.dto.CustomerDto;
import com.biometric.entity.Contact;
import com.biometric.entity.Customer;
import com.biometric.repository.ContactRepository;
import com.biometric.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BiometricServiceImpl implements BiometricService{

    private final CustomerRepository customerRepository;
    private final ContactRepository contactRepository;
    @Override
    public Customer saveCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .email(customerDto.getEmail())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .mobileNumber(customerDto.getMobileNumber())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public Contact saveContactDetails(ContactDto contactDto) {
        Contact contact = Contact.builder()
                .fullName(contactDto.getFullName())
                .email(contactDto.getEmail())
                .subject(contactDto.getSubject())
                .comments(contactDto.getComments())
                .build();
        return contactRepository.save(contact);
    }
}
