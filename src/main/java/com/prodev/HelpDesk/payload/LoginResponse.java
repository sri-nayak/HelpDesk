package com.prodev.HelpDesk.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class LoginResponse {
    public  String respMessage;
    public Boolean Auth;
    public Integer status;
    public String token;
}
