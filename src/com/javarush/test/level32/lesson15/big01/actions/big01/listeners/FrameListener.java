package com.javarush.test.level32.lesson15.big01.actions.big01.listeners;

import com.javarush.test.level32.lesson15.big01.actions.big01.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by User on 021 2016.04.21..
 */
public class FrameListener extends WindowAdapter {
    private View view;

    public FrameListener(View view) {
        this.view = view;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        view.exit();
    }
}
