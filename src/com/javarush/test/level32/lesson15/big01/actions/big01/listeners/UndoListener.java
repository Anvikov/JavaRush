package com.javarush.test.level32.lesson15.big01.actions.big01.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by User on 022 2016.04.22..
 */
public class UndoListener implements UndoableEditListener {
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }
    public void undoableEditHappened(UndoableEditEvent e){
        undoManager.addEdit(e.getEdit());
    }
}
