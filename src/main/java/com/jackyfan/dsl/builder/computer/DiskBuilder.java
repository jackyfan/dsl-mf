package com.jackyfan.dsl.builder.computer;

import com.jackyfan.dsl.builder.computer.enums.InterFace;

public class DiskBuilder {
    private int size = Disk.UNKNOWN_SIZE;
    private int speed = Disk.UNKNOWN_SPEED;
    private InterFace iface;
    private ComputerBuilder parent;

    public DiskBuilder(ComputerBuilder computerBuilder) {
        this.parent = computerBuilder;
    }

    public DiskBuilder size(int size) {
        this.size = size;
        return this;
    }

    public DiskBuilder speed(int speed) {
        this.speed = speed;
        return this;
    }

    public DiskBuilder sata() {
        this.iface = InterFace.SATA;
        return this;
    }

    public Disk getValue() {
        return new Disk(size, speed, iface);
    }

    public DiskBuilder disk() {
        return this.parent.disk();
    }

    public Computer end() {
        return parent.getValue();
    }

}
