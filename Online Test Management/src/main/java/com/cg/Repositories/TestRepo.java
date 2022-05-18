package com.cg.Repositories;

import com.cg.Services.TestService;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface TestRepo {
    TestService addTest(TestService testService);
    TestService updateTest(BigInteger testId, TestService testService);
    TestService deleteTest(BigInteger TestId);
    boolean assignTest(Long userId, BigInteger TestId);
    BigDecimal getResult(TestService testService);
}
