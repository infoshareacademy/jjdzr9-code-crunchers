package com.isa.jjdzr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"status"})

public class Lifts {
    Status status;
    Stats stats;

    public Lifts() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Lifts{" +
                "status=" + status +
                ", stats=" + stats +
                '}';
    }
}