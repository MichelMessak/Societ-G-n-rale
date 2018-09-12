package com.societe.model.cmd;

import lombok.NonNull;
import lombok.Value;

@Value(staticConstructor = "of")
public class DistributorAmountCmd {

    @NonNull
    private Long accountId;

    @NonNull
    private Double amount;

}


