package com.cg.Repositories;

import com.cg.Entities.Questions;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface QuestionRepo {
    Questions addQuestions(BigInteger TestId, Questions questions);
    Questions updateQuestions(BigInteger TestId,Questions questions);
    Questions deleteQuestions(BigInteger TestId,Questions questions);
    BigDecimal calculateTotalMarks();
}
