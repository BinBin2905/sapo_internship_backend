package com.example.sapointernshipbackendtest.service;

import com.example.sapointernshipbackendtest.dto.accountDTO.AccountRequestDTO;
import com.example.sapointernshipbackendtest.model.Account;

public interface AccountService {

    Account login(AccountRequestDTO account);

}
