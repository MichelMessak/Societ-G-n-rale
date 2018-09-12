package com.societe.service;

import com.societe.dto.OperationDto;
import com.societe.exception.AccountNotExistException;
import com.societe.model.cmd.DistributorAmountCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for distributors
 */
@RequiredArgsConstructor
@Service
public class DistributorService {

    private final AccountService accountService;

    /**
     * Deposit amount from a specific account
     *
     * @param distributorAmountCmd
     * @throws AccountNotExistException
     */
    @Transactional
    public void depositMoney(final DistributorAmountCmd distributorAmountCmd) throws AccountNotExistException {
        accountService.depositMoney(distributorAmountCmd.getAccountId(), distributorAmountCmd.getAmount());
    }

    /**
     * Retrieve amount from a specific account
     *
     * @param distributorAmountCmd
     * @throws AccountNotExistException
     */
    @Transactional
    public void retrieveMoney(final DistributorAmountCmd distributorAmountCmd) throws AccountNotExistException {
        accountService.retrieveMoney(distributorAmountCmd.getAccountId(), distributorAmountCmd.getAmount());
    }

    /**
     * Check operations from a specific account
     *
     * @param accountId
     * @return operations from a specific account
     */
    @Transactional(readOnly = true)
    public List<OperationDto> checkOperation(final long accountId) {
        return accountService.checkOperations(accountId);
    }
}
