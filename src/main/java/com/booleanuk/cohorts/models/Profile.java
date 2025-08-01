package com.booleanuk.cohorts.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("users")
    private User user;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String bio;

    @Column
    private String githubUrl;

    public Profile(int id) {
        this.id = id;
    }

    public Profile(User user, String firstName, String lastName, String bio, String githubUrl) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.githubUrl = githubUrl;
    }
}
