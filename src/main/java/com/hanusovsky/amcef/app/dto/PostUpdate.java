package com.hanusovsky.amcef.app.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostUpdate {
    @NotNull
    private String title;

    @NotNull
    private String body;
}
