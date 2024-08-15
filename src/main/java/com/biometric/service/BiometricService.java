package com.biometric.service;

import com.biometric.dto.ContactDto;
import com.biometric.dto.CustomerDto;
import com.biometric.entity.Contact;
import com.biometric.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface BiometricService {
    Customer saveCustomer(CustomerDto customerDto);
    Contact saveContactDetails(ContactDto contactDto);
}
