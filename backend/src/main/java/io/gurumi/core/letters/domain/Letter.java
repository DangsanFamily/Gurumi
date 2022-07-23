package io.gurumi.core.letters.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected Letter() {
    }

    public Letter(Long id) {
        this.id = id;
    }
}
