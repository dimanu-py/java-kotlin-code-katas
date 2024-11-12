package srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceShould {

    private final int POSITIVE_AMOUNT = 100;
    private final int NEGATIVE_AMOUNT = -POSITIVE_AMOUNT;
    private final List<Transaction> TRANSACTIONS = List.of(
            new Transaction(LocalDate.of(2023, 11, 5), 1000),
            new Transaction(LocalDate.of(2023, 11, 6), -200)
    );
    private static final LocalDate TODAY = LocalDate.of(2023, 11, 6);

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private Clock clock;

    @Mock
    private Console console;

    @InjectMocks
    private AccountService accountService;

    @Test
    void deposit_amount_into_account() {
        when(clock.today()).thenReturn(TODAY);

        accountService.deposit(POSITIVE_AMOUNT);

        verify(transactionRepository).add(refEq(new Transaction(TODAY, POSITIVE_AMOUNT)));
    }

    @Test
    void withdraw_amount_from_account() {
        when(clock.today()).thenReturn(TODAY);

        accountService.withdraw(POSITIVE_AMOUNT);

        verify(transactionRepository).add(refEq(new Transaction(TODAY, NEGATIVE_AMOUNT)));
    }

    @Test
    void printStatement_shouldPrintTransactionsInReverseOrder() {
        when(transactionRepository.all()).thenReturn(TRANSACTIONS);

        accountService.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("06/11/2023 | -200.00 | 800.00");
        inOrder.verify(console).printLine("05/11/2023 | 1000.00 | 1000.00");
    }
}
