package com.hanusovsky.amcef.external.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalPost {
    private int userId;
    private int id;
    private String body;
    private String title;
}
