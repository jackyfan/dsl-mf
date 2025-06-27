package com.jackyfan.dsl.builder.computer;

import com.jackyfan.dsl.builder.computer.enums.Type;

public class Processor {
    int cores;
    int speed;
    Type type;

    public Processor(int cores, int speed, Type type) {
        this.cores = cores;
        this.speed = speed;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "cores=" + cores +
                ", speed=" + speed +
                ", type=" + type +
                '}';
    }
}
