package com.societe.service;

import com.societe.exception.AccountNotExistException;
import com.societe.model.entity.Account;
import com.societe.model.enumeration.OperationType;
import com.societe.repository.AccoutRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Optional;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @Autowired
    public AccountService accountService;

    @MockBean
    private AccoutRepository accoutRepository;

    @MockBean
    private OperationService operationService;

    private static final ZonedDateTime DEFAULT_DATE = ZonedDateTime.now();

    @Test(expected = AccountNotExistException.class)
    public void depositMoneyAccountNotExistExceptionTest() throws AccountNotExistException {

        Mockito.when(accoutRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        accountService.depositMoney(1L, Double.valueOf(0.2));
    }

    @Test(expected = AccountNotExistException.class)
    public void depositMoneyTest() throws AccountNotExistException {

        Mockito.when(accoutRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(Mockito.mock(Account.class)));
        Mockito.doNothing().when(accoutRepository.save(Mockito.any(Account.class)));
        Mockito.doNothing().when(operationService).createOperation(Mockito.anyLong(), Mockito.anyDouble(), Mockito.anyDouble(), Mockito.any(OperationType.class));
        accountService.depositMoney(1L, Double.valueOf(0.2));
    }

    @Test(expected = AccountNotExistException.class)
    public void retrieveMoneyAccountNotExistExceptionTest() throws AccountNotExistException {

        Mockito.when(accoutRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        accountService.retrieveMoney(1L, Double.valueOf(0.2));
    }

    @Test(expected = AccountNotExistException.class)
    public void retrieveMoneyTest() throws AccountNotExistException {

        Mockito.when(accoutRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(Mockito.mock(Account.class)));
        Mockito.doNothing().when(accoutRepository.save(Mockito.any(Account.class)));
        Mockito.doNothing().when(operationService).createOperation(Mockito.anyLong(), Mockito.anyDouble(), Mockito.anyDouble(), Mockito.any(OperationType.class));
        accountService.retrieveMoney(1L, Double.valueOf(0.2));
    }

}
