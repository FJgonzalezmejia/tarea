package model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private com.example.librarymanagement.model.Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private com.example.librarymanagement.model.User user;

    private LocalDate loanDate;
    private LocalDate returnDate;
}

