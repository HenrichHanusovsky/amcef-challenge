package com.hanusovsky.amcef.external.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalUser {

    private int id;
    private String name;
    private String email;
    private ExternalAddress address;
    private String phone;
    private String website;
    private ExternalCompany company;
}
