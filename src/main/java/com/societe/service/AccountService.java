package com.societe.service;

import com.societe.dto.OperationDto;
import com.societe.exception.AccountNotExistException;
import com.societe.model.entity.Account;
import com.societe.model.enumeration.OperationType;
import com.societe.repository.AccoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for accounts
 */
@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccoutRepository accoutRepository;

    private final OperationService operationService;

    /**
     * Deposit amount
     *
     * @param id
     * @param amount
     * @throws AccountNotExistException
     */
    @Transactional
    public void depositMoney(final Long id, final Double amount) throws AccountNotExistException {

        Account account = retrieveAccountById(id);
        account = addMoney(account, amount);
        accoutRepository.save(account);
        operationService.createOperation(id, amount, account.getBalance(), OperationType.DEPOSIT_MONEY);
    }

    private Account addMoney(Account account, final Double money) {
        account.setBalance(account.getBalance() + money.doubleValue());
        return account;
    }

    /**
     * Retrieve amount
     *
     * @param id
     * @param amount
     * @throws AccountNotExistException
     */
    @Transactional
    public void retrieveMoney(final long id, final Double amount) throws AccountNotExistException {
        Account account = retrieveAccountById(id);
        account = retriveMoney(account, amount);
        accoutRepository.save(account);
        operationService.createOperation(id, amount, account.getBalance(), OperationType.RETRIEVE_MONEY);
    }

    private Account retriveMoney(Account account, final Double money) {
        account = account.setBalance(account.getBalance() - money.doubleValue());
        return account;
    }

    private Account retrieveAccountById(final long accountId) throws AccountNotExistException {
        return accoutRepository.findById(accountId).orElseThrow(() -> new AccountNotExistException("Account does not exist whith #id : " + accountId));
    }

    /**
     * Check all operations for a specific account
     *
     * @param accountId
     * @return a list of operations dto
     */
    @Transactional(readOnly = true)
    public List<OperationDto> checkOperations(final long accountId) {
        return operationService.getAllByAccountId(accountId);
    }
}

