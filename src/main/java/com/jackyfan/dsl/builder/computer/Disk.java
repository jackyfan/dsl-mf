package com.jackyfan.dsl.builder.computer;

import com.jackyfan.dsl.builder.computer.enums.InterFace;

public class Disk {
    private int size = Disk.UNKNOWN_SIZE;
    private int speed = Disk.UNKNOWN_SPEED;
    private InterFace iface;
    public static final int UNKNOWN_SPEED = -1;
    public static final int UNKNOWN_SIZE = -1;

    public Disk(int size, int speed, InterFace iface) {
        this.size = size;
        this.speed = speed;
        this.iface = iface;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "size=" + size +
                ", speed=" + speed +
                ", iface=" + iface +
                '}';
    }
}
