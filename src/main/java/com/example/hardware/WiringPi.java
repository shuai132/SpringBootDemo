package com.example.hardware;

import com.sun.jna.Library;
import com.sun.jna.Native;

public final class WiringPi {
    public interface CLibrary extends Library {
        CLibrary INSTANCE = Native.load("wiringPi", CLibrary.class);

        void wiringPiSetup();

        void pullUpDnControl(int pin, int mode);
        void pinMode(int pin, int mode);
        void digitalWrite(int pin, boolean value);
        boolean digitalRead(int pin);
    }

    static {
        CLibrary.INSTANCE.wiringPiSetup();
    }

    public static CLibrary getInstance() {
        return CLibrary.INSTANCE;
    }
}