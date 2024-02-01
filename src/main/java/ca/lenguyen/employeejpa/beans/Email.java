package ca.lenguyen.employeejpa.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EMAILID")
    private Long emailId;
    @Column(name="EMAIL")
    private String email;
    @JoinColumn(name = "ID")
    private Long id;
}
