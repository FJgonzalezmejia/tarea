package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Loan;
import com.example.librarymanagement.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LoanServiceTest {

    @InjectMocks
    private LoanService loanService;

    @Mock
    private LoanRepository loanRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllLoans() {
        Loan loan1 = new Loan();
        loan1.setId(1L);

        Loan loan2 = new Loan();
        loan2.setId(2L);

        List<Loan> loans = Arrays.asList(loan1, loan2);

        when(loanRepository.findAll()).thenReturn(loans);

        List<Loan> result = loanService.getAllLoans();
        assertEquals(2, result.size());
        verify(loanRepository, times(1)).findAll();
    }

    @Test
    public void testCreateLoan() {
        Loan loan = new Loan();

        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        Loan result = loanService.createLoan(loan);
        verify(loanRepository, times(1)).save(loan);
    }

    @Test
    public void testGetLoanById() {
        Loan loan = new Loan();
        loan.setId(1L);

        when(loanRepository.findById(1L)).thenReturn(Optional.of(loan));

        Loan result = loanService.getLoanById(1L);
        assertEquals(1L, result.getId());
        verify(loanRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetLoanByIdNotFound() {
        when(loanRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> loanService.getLoanById(1L));
        verify(loanRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdateLoan() {
        Loan existingLoan = new Loan();
        existingLoan.setId(1L);

        Loan updatedLoan = new Loan();

        when(loanRepository.findById(1L)).thenReturn(Optional.of(existingLoan));
        when(loanRepository.save(any(Loan.class))).thenReturn(existingLoan);

        Loan result = loanService.updateLoan(1L, updatedLoan);
        verify(loanRepository, times(1)).findById(1L);
        verify(loanRepository, times(1)).save(existingLoan);
    }

    @Test
    public void testDeleteLoan() {
        Loan loan = new Loan();
        loan.setId(1L);

        when(loanRepository.findById(1L)).thenReturn(Optional.of(loan));
        doNothing().when(loanRepository).delete(loan);

        loanService.deleteLoan(1L);
        verify(loanRepository, times(1)).findById(1L);
        verify(loanRepository, times(1)).delete(loan);
    }
}
