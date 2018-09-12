package com.societe.dto;

import com.societe.model.enumeration.OperationType;
import lombok.NonNull;
import lombok.Value;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Dto for bank operation
 */
@Value(staticConstructor = "of")
public class OperationDto {

    @Value(staticConstructor = "of")
    public static class OperationsDto {

        @NonNull
        List<OperationDto> operationsDto;

    }

    @NonNull
    OperationType operationType;

    @NonNull
    Double balance;

    @NonNull
    Double amount;

    @NonNull
    ZonedDateTime date;
}
