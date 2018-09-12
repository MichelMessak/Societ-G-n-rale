package com.societe.model.entity;

import com.societe.model.enumeration.OperationType;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operation")
public class Operation extends AbstractEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "operation_type", nullable = false)
    private OperationType operationType;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "date", nullable = false)
    private ZonedDateTime date;

    @Column(name = "account_id", nullable = false)
    private long accountId;

}
