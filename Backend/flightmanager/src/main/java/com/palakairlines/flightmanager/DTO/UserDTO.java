package com.palakairlines.flightmanager.DTO;





import com.palakairlines.flightmanager.CustomValidation.TenDigitNonZeroStartPhoneNumber;
import com.palakairlines.flightmanager.CustomValidation.UniqueUsername;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Component
public class UserDTO {

    private BigInteger userId;
    @NotEmpty(message = "User Name not valid")
    @UniqueUsername(message = "User Name already exists")
    private String userName;
    @NotEmpty(message = "Password not valid")
    private String userPassword;
    @NotNull(message = "Phone number is required")
    @TenDigitNonZeroStartPhoneNumber(message = "Phone number should have exactly 10 digits and should not start with zero")
    private BigInteger userPhone;
    @Email(message = "Email address is not valid")
    private String userEmail;

    private Set<RoleDTO> roles = new HashSet<>();


}
