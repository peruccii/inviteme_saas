package com.Invitemee.Invitemee.infra.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import java.util.regex.Pattern;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_invite")
@Entity
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String invited_name;
    private String name;
    private String invite_name;
    private String text;
    private String urlMusic;
    private LocalDate duration_invite = LocalDate.now().plusMonths(1);
    @ElementCollection
    @Column(name = "image_url")
    private List<String> imageUrls;
    private LocalDateTime occurs_in;
    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private InviteType invite_type;

    @Enumerated(EnumType.STRING)
    private InvitePlan invitePlan;


    public boolean isUrlMusicCorrect(String urlMusic) {
        return Pattern.matches("^(https?://)?(www\\.)?(youtube\\.com/watch\\?v=|youtu\\.be/)([a-zA-Z0-9_-]{11})(\\S*)?$", urlMusic);
    }
}
