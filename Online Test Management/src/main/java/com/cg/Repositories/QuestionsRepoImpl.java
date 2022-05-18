package com.cg.Repositories;

import com.cg.Entities.Questions;
import com.cg.Entities.User;
import com.cg.Services.TestService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class QuestionsRepoImpl implements QuestionRepo{

    User user = new User();
    List<TestService> tList;
    List<Questions> qList;

    public QuestionsRepoImpl() {
        tList = new ArrayList<>();
        qList = new ArrayList<>();
    }

    @Override
    public Questions addQuestions(BigInteger TestId, Questions questions) {
        if(!user.isAdmin()) return null;

        for (TestService testService : tList) {
            if (Objects.equals(TestId, testService.getTestId())) {
                qList.add(questions);
            }
        }

        return questions;
    }

    @Override
    public Questions updateQuestions(BigInteger TestId, Questions questions) {
        if(!user.isAdmin()) return null;

        for(int i=0;i<tList.size();i++) {
            if(Objects.equals(TestId, tList.get(i).getTestId())) {
                qList.set(i, questions);
            }
        }

        return questions;
    }

    @Override
    public Questions deleteQuestions(BigInteger TestId, Questions questions) {
        if(!user.isAdmin()) return null;

        for(int i=0;i<tList.size();i++) {
            if(Objects.equals(TestId, tList.get(i).getTestId())) {
                try {
                    qList.remove(i);
                }
                catch(Exception ignore) {

                }
            }
        }

        return questions;
    }

    @Override
    public BigDecimal calculateTotalMarks() {
        if(!user.isAdmin()) return null;
        return qList.stream().map(Questions::getMarksScored).reduce(BigDecimal::add).get();
    }
}
