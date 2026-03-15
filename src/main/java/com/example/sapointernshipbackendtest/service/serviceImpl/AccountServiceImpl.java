package com.example.sapointernshipbackendtest.service.serviceImpl;

import com.example.sapointernshipbackendtest.dto.accountDTO.AccountRequestDTO;
import com.example.sapointernshipbackendtest.model.Account;
import com.example.sapointernshipbackendtest.repository.AccountRepository;
import com.example.sapointernshipbackendtest.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public Account login(AccountRequestDTO account) {
        Account acc = new Account();

        acc.setName(account.name);
        return repository.save(acc);
    }
}
