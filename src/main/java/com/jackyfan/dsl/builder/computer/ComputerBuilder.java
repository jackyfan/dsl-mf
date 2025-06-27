package com.jackyfan.dsl.builder.computer;

import com.jackyfan.dsl.builder.computer.enums.Type;

import java.util.ArrayList;
import java.util.List;

public class ComputerBuilder {
    private ProcessorBuilder currentProcessor;
    private DiskBuilder currentDisk;
    private final List<Disk> loadedDisks = new ArrayList<>();

    public static ComputerBuilder computerBuilder() {
        return new ComputerBuilder();
    }

    public ComputerBuilder processor() {
        currentProcessor = new ProcessorBuilder();
        return this;
    }

    public ComputerBuilder cores(int cores) {
        currentProcessor.cores = cores;
        return this;
    }

    public ComputerBuilder speed(int speed) {
        currentProcessor.speed = speed;
        return this;
    }

    public ComputerBuilder i386() {
        currentProcessor.type = Type.i386;
        return this;
    }

    public DiskBuilder disk() {
        if (currentDisk != null) loadedDisks.add(currentDisk.getValue());
        currentDisk = new DiskBuilder(this);
        return currentDisk;
    }

    protected Computer getValue() {
        return new Computer(currentProcessor.getValue(), disks());
    }

    public Disk[] disks() {
        List<Disk> result = new ArrayList<Disk>();
        result.addAll(loadedDisks);
        if (currentDisk != null) result.add(currentDisk.getValue());
        return result.toArray(new Disk[result.size()]);
    }

}
