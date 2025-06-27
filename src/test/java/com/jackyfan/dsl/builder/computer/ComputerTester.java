package com.jackyfan.dsl.builder.computer;

import org.junit.Test;

public class ComputerTester {
    @Test
    public void test_computer() {
        Computer computer = ComputerBuilder.computerBuilder()
                .processor()
                    .cores(3)
                    .speed(3000)
                    .i386()
                .disk()
                    .size(512)
                    .speed(1000)
                .disk()
                    .size(1024)
                    .speed(2000)
                    .sata()
                .end();
        System.out.println(computer.toString());
    }
}
