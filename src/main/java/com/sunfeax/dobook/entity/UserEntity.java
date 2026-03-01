package com.sunfeax.dobook.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.sunfeax.dobook.enums.UserRole;
import com.sunfeax.dobook.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2, max = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Incorrect email format")
    @Size(min = 5, max = 100)
    private String email;

    @Column(name = "phone_number", length = 20, unique = true)
    @Size(min = 7, max = 20)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 100 characters")
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @Column(name = "user_type", nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.CLIENT;

    @Column(name = "created_at", nullable = false, updatable = false)
    @NotNull
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "owner")
    private List<BusinessEntity> ownedBusinesses;

    @OneToMany(mappedBy = "specialist")
    private List<OfferingEntity> offerings;

    @OneToMany(mappedBy = "client")
    private List<AppointmentEntity> clientAppointments;

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            this.phoneNumber = null;
            return;
        }

        String normalizedPhone = phoneNumber.trim();
        this.phoneNumber = normalizedPhone.isEmpty() ? null : normalizedPhone;
    }
}
