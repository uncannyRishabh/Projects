package com.cg.Services;

import com.cg.Entities.Questions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

public class TestService {
    private BigInteger testId;
    private String testTitle;
    private LocalTime testDuration;
    private Set<Questions> testQuestions;
    private BigDecimal testTotalMarks;
    private Questions testMarksScored;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TestService(){}

    public TestService(BigInteger testId, String testTitle, LocalTime testDuration, Set<Questions> testQuestions, BigDecimal testTotalMarks, Questions testMarksScored, LocalDateTime startTime, LocalDateTime endTime) {
        this.testId = testId;
        this.testTitle = testTitle;
        this.testDuration = testDuration;
        this.testQuestions = testQuestions;
        this.testTotalMarks = testTotalMarks;
        this.testMarksScored = testMarksScored;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public LocalTime getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(LocalTime testDuration) {
        this.testDuration = testDuration;
    }

    public Set<Questions> getTestQuestions() {
        return testQuestions;
    }

    public void setTestQuestions(Set<Questions> testQuestions) {
        this.testQuestions = testQuestions;
    }

    public BigDecimal getTestTotalMarks() {
        return testTotalMarks;
    }

    public void setTestTotalMarks(BigDecimal testTotalMarks) {
        this.testTotalMarks = testTotalMarks;
    }

    public Questions getTestMarksScored() {
        return testMarksScored;
    }

    public void setTestMarksScored(Questions testMarksScored) {
        this.testMarksScored = testMarksScored;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
