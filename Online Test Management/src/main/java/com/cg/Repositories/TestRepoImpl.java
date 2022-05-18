package com.cg.Repositories;

import com.cg.Entities.User;
import com.cg.Services.TestService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

public class TestRepoImpl implements TestRepo{
    User user = new User();
    List<TestService> tList;
    List<User> uList;

    @Override
    public TestService addTest(TestService testService) {
        if(!user.isAdmin()) return null;
        tList.add(testService);
        return testService;
    }

    @Override
    public TestService updateTest(BigInteger testId, TestService testService) {
        if(!user.isAdmin()) return null;
        for(int i=0;i<tList.size();i++) {
            if(Objects.equals(testId, tList.get(i).getTestId())) {
                tList.set(i, testService);
            }
        }
        return null;
    }

    @Override
    public TestService deleteTest(BigInteger TestId) {
        if(!user.isAdmin()) return null;
        TestService id = null;
        for(int i=0;i<tList.size();i++) {
            if(Objects.equals(TestId, tList.get(i).getTestId())) {
                id=tList.get(i);
                try {
                    tList.remove(i);
                }
                catch(Exception ignore) {
                }
            }
        }
        return id;
    }

    @Override
    public boolean assignTest(Long userId, BigInteger TestId) {
        if(!user.isAdmin()) return false;
        for (TestService testService : tList) {
            if (Objects.equals(TestId, testService.getTestId())) {
                for (User value : uList) {
                    if (Objects.equals(userId, value.getUserID())) return true;
                }
            }
        }
        return false;
    }

    @Override
    public BigDecimal getResult(TestService testService) {
        if(!user.isAdmin()) return null;
        return testService.getTestTotalMarks();
    }
}
