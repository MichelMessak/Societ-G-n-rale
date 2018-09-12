package com.societe.service;

import com.societe.dto.OperationDto;
import com.societe.mapper.OperationMapper;
import com.societe.model.entity.Operation;
import com.societe.model.enumeration.OperationType;
import com.societe.repository.OperationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for operations
 */
@Service
@AllArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;

    private final OperationMapper operationMapper;

    /**
     * Create and save a new bank operation
     *
     * @param accountId
     * @param amount
     * @param balance
     * @param operationType
     */
    @Transactional
    public void createOperation(final long accountId, final Double amount, final Double balance, final OperationType operationType) {

        Operation operation = new Operation();
        operation.setAmount(amount);
        operation.setBalance(balance);
        operation.setOperationType(operationType);
        operation.setAccountId(accountId);

        operationRepository.save(operation);
    }

    /**
     * Get all operation for a specific bank account
     *
     * @param accountId
     * @return
     */
    @Transactional(readOnly = true)
    public List<OperationDto> getAllByAccountId(final long accountId) {

        final List<Operation> operations = operationRepository.findByAccountId(accountId);
        return operationMapper.entitiesToDtos(operations);
    }
}
