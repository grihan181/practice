package com.opencode.practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String text;

/*    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;*/

    @ManyToMany(mappedBy = "answers")
    private Set<AppUser> appUsers = new HashSet<>();
}
