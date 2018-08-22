package com.lonewolf.together;

import java.util.ArrayList;

public class PollData {

    String pollQuestion;
    ArrayList<String> options = new ArrayList();

    public String getPollQuestion() {
        return pollQuestion;
    }

    public void setPollQuestion(String pollQuestion) {
        this.pollQuestion = pollQuestion;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options.add(options);
    }
}
