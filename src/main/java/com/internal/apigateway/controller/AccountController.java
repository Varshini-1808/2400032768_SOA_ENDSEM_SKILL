package com.internal.apigateway.controller;

import com.internal.apigateway.model.Account;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    List<Account> accounts = new ArrayList<>(
        Arrays.asList(
            new Account(1001, "Varshini", 5000),
            new Account(1002, "Felix", 8000)
        )
    );

    @GetMapping
    public List<Account> getAllAccounts() {
        return accounts;
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id) {
        return accounts.stream()
            .filter(a -> a.getId() == id)
            .findFirst()
            .orElse(null);
    }

    @PostMapping
    public String addAccount(@RequestBody Account account) {
        accounts.add(account);
        return "Account added successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable int id) {
        accounts.removeIf(a -> a.getId() == id);
        return "Account deleted successfully";
    }
}