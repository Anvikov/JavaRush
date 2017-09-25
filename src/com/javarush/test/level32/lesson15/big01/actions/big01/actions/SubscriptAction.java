package com.javarush.test.level32.lesson15.big01.actions.big01.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Created by User on 022 2016.04.22..
 */
public class SubscriptAction extends StyledEditorKit.StyledTextAction {

    public SubscriptAction() {
        super(StyleConstants.Subscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JEditorPane jEditorPane=getEditor(actionEvent);
        if (jEditorPane!=null){
            MutableAttributeSet mutableAttributeSet=getStyledEditorKit(jEditorPane).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet=new SimpleAttributeSet();
            StyleConstants.setSubscript(simpleAttributeSet,!StyleConstants.isSubscript(mutableAttributeSet));
            setCharacterAttributes(jEditorPane,simpleAttributeSet,false);
        }
    }
}
