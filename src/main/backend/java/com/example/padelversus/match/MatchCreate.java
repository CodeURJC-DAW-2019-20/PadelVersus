package com.example.padelversus.match;

import java.time.LocalDate;

public class MatchCreate {
    public String t1;
    public String t2;
    public LocalDate date;

    public MatchCreate(String t1, String t2, LocalDate date) {
        this.t1 = t1;
        this.t2 = t2;
        this.date = date;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
