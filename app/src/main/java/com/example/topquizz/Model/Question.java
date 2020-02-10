package com.example.topquizz.Model;

import java.util.List;

public class Question {
    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;

    public String getmQuestion() { return mQuestion; }

    public void setmQuestion(String mQuestion) { this.mQuestion = mQuestion; }

    public List<String> getmChoiceList() { return mChoiceList; }

    public void setChoiceList(List<String> choiceList) {
        if (choiceList == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        mChoiceList = choiceList;


        public int getmAnswerIndex() { return mAnswerIndex; }


        public void setAnswerIndex( int answerIndex){
            if (answerIndex < 0 || answerIndex >= mChoiceList.size()) {
                throw new IllegalArgumentException("Answer index is out of bound");
            }

            mAnswerIndex = answerIndex;
        }


    }