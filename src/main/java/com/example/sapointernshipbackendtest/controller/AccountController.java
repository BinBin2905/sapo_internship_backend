package com.example.sapointernshipbackendtest.controller;

import com.example.sapointernshipbackendtest.dto.accountDTO.AccountRequestDTO;
import com.example.sapointernshipbackendtest.model.Account;
import com.example.sapointernshipbackendtest.service.serviceImpl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private  final AccountServiceImpl accountService;

    @PostMapping
    public ResponseEntity<Account> login (@RequestBody AccountRequestDTO account){
        return ResponseEntity.ok(accountService.login(account));
    }

}
