package com.javarush.test.level32.lesson15.big01.actions.big01.listeners;

import com.javarush.test.level32.lesson15.big01.actions.big01.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by User on 021 2016.04.21..
 */
public class TabbedPaneChangeListener implements ChangeListener{
    private View view;

    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}
