package org.example.model;

public class Stats {
    Double open;
    Double hold;
    Double scheduled;
    Double closed;
    Percentage percentage;

    public Stats() {
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHold() {
        return hold;
    }

    public void setHold(Double hold) {
        this.hold = hold;
    }

    public Double getScheduled() {
        return scheduled;
    }

    public void setScheduled(Double scheduled) {
        this.scheduled = scheduled;
    }

    public Double getClosed() {
        return closed;
    }

    public void setClosed(Double closed) {
        this.closed = closed;
    }

    public Percentage getPercentage() {
        return percentage;
    }

    public void setPercentage(Percentage percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "open=" + open +
                ", hold=" + hold +
                ", scheduled=" + scheduled +
                ", closed=" + closed +
                ", percentage=" + percentage +
                '}';
    }
}