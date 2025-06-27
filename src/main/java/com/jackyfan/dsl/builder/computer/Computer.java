package com.jackyfan.dsl.builder.computer;

import java.util.Arrays;

public class Computer {
    private Processor processor;
    private Disk[] disks;

    public Computer(Processor processor, Disk[] disks) {
        this.processor = processor;
        this.disks = disks;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor=" + processor +
                ", disks=" + Arrays.toString(disks) +
                '}';
    }
}
