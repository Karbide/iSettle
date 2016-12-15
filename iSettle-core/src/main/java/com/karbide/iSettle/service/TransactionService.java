package com.karbide.iSettle.service;

import com.karbide.iSettle.dto.UserAccountDto;
import com.karbide.iSettle.model.TransactionIni;

/**
 * Created by deepeshuniyal on 04/12/16.
 */
public interface TransactionService {
    public void transaction(TransactionIni transactionIni);
}
