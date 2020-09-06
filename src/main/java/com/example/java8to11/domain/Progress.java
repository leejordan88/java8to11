package com.example.java8to11.domain;

import java.time.Duration;

public class Progress {

    private Duration studyDuration;
    private boolean finished;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "studyDuration=" + studyDuration +
                ", finished=" + finished +
                '}';
    }
}
