package com.example;

import org.testng.annotations.Test;

public class AccountTests {
    @Test
    public void testWithdraw() {
        Account account = new Account();
        account.withdraw(100);
    }
}
