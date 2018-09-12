package com.societe.mapper;

import com.societe.dto.OperationDto;
import com.societe.model.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for bank operation
 */
@Component
public class OperationMapper {

    /**
     * Map an operation entity to  an operation dto
     *
     * @param operation
     * @return a operation dto
     */
    public OperationDto entityToDto(final Operation operation) {
        return OperationDto.of(operation.getOperationType(), operation.getBalance(), operation.getAmount(), operation.getDate());
    }

    /**
     * Map a list of operations entity to a list of operations dto
     *
     * @param operations
     * @return a list of operations dto
     */
    public List<OperationDto> entitiesToDtos(final List<Operation> operations) {
        return operations.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

}
