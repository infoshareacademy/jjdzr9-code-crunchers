package com.isa.jjdzr.deserializer;
public class Percentage {
    Double open;
    Double hold;
    Double scheduled;
    Double closed;
    public Percentage() {
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

    @Override
    public String toString() {
        return "Percentage{" +
                "open=" + open +
                ", hold=" + hold +
                ", scheduled=" + scheduled +
                ", closed=" + closed +
                '}';
    }
}
