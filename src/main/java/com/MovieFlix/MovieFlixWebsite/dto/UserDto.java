package com.MovieFlix.MovieFlixWebsite.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Size(min=3,max=20,message="Invalid username!!(5-20 character)")
    private String username;

    @Size(min=3,max=20,message="Invalid username!!(5-20 character)")
    private String password;

    private String repeatpassword;
}
