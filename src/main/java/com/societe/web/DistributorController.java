package com.societe.web;

import com.societe.dto.OperationDto;
import com.societe.exception.AccountNotExistException;
import com.societe.model.cmd.DistributorAmountCmd;
import com.societe.service.DistributorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for distributors
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/distributor")
public class DistributorController {

    private final DistributorService distributorService;

    /**
     * Deposit money into a specific account
     *
     * @param distributorAmountCmd
     * @throws AccountNotExistException
     */
    @PutMapping(value = "/deposit")
    @ResponseStatus(HttpStatus.OK)
    public void depositMoney(@RequestBody final DistributorAmountCmd distributorAmountCmd) throws AccountNotExistException {
        distributorService.depositMoney(distributorAmountCmd);
    }

    /**
     * Retrieve money from a specific account
     *
     * @param distributorAmountCmd
     * @throws AccountNotExistException
     */
    @PutMapping(value = "/retrieve")
    @ResponseStatus(HttpStatus.OK)
    public void retrieveMoney(@RequestBody final DistributorAmountCmd distributorAmountCmd) throws AccountNotExistException {
        distributorService.retrieveMoney(distributorAmountCmd);
    }

    /**
     * Retrieve operations from a specific account
     *
     * @param accountId
     * @return an operations dto
     */
    @GetMapping(value = "/checkOperations/{accountId}")
    public OperationDto.OperationsDto checkOperations(@PathVariable("accountId") final long accountId) {
        return OperationDto.OperationsDto.of(distributorService.checkOperation(accountId));
    }
}
