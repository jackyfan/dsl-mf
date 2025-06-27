package com.jackyfan.dsl.builder.computer;

import com.jackyfan.dsl.builder.computer.enums.Type;

public class ProcessorBuilder {
    private static final int DEFAULT_CORES = 1;
    private static final int DEFAULT_SPEED = -1;
    int cores = DEFAULT_CORES;
    int speed = DEFAULT_SPEED;
    Type type;

    public Processor getValue() {
        return new Processor(cores, speed, type);
    }
}
