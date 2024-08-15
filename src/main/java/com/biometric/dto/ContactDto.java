package com.biometric.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ContactDto {
    private String fullName;
    private String email;
    private String comments;
    private String subject;
}
