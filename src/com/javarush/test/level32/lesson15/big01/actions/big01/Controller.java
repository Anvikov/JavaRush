package com.javarush.test.level32.lesson15.big01.actions.big01;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by User on 021 2016.04.21..
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.read(stringReader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter stringWriter = null;
        if (document != null) {
            stringWriter = new StringWriter();
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            try {
                htmlEditorKit.write(stringWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
        return stringWriter.toString();
    }


    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;

    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser=new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        jFileChooser.setDialogTitle("Open File");
        int saveDialog=jFileChooser.showOpenDialog(view);
        try {
            if (saveDialog==jFileChooser.APPROVE_OPTION){
                currentFile=jFileChooser.getSelectedFile();
                resetDocument();
                view.setTitle(currentFile.getName());

                try (FileReader fileReader=new FileReader(currentFile)){
                    HTMLEditorKit htmlEditorKit=new HTMLEditorKit();
                    htmlEditorKit.read(fileReader,document,0);
                    view.resetUndo();
                }
            }
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public void saveDocument() {
        if (currentFile==null){
            saveDocumentAs();
        }else {
            view.selectHtmlTab();
            try (FileWriter fileWriter=new FileWriter(currentFile)){
                HTMLEditorKit htmlEditorKit=new HTMLEditorKit();
                htmlEditorKit.write(fileWriter,document,0,document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser=new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        jFileChooser.setDialogTitle("Save File");
        int saveDialog=jFileChooser.showSaveDialog(view);
        try {
            if (saveDialog==jFileChooser.APPROVE_OPTION){
                currentFile=jFileChooser.getSelectedFile();
                view.setTitle(currentFile.getName());

                FileWriter fileWriter=new FileWriter(currentFile);
                HTMLEditorKit htmlEditorKit=new HTMLEditorKit();
                htmlEditorKit.write(fileWriter,document,0,document.getLength());
                fileWriter.close();
            }
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

}
