package com.javarush.test.level32.lesson15.big01.actions.big01.listeners;

import com.javarush.test.level32.lesson15.big01.actions.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by User on 022 2016.04.22..
 */
public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent menuEvent) {
        JMenu source= (JMenu) menuEvent.getSource();
        Component[] components=source.getMenuComponents();
        for (Component component:components) {
            component.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }


}
