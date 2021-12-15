package pl.klasicki.domain;


import pl.klasicki.visits.Visit;

import javax.persistence.*;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "prescription")
    private Visit visit;

    public Prescription() {
    }

    public Prescription(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                '}';
    }
}
