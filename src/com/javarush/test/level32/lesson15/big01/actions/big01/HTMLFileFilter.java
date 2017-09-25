package com.javarush.test.level32.lesson15.big01.actions.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by User on 023 2016.04.23..
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        if (file != null) {
            String fileFormat = file.getName().toLowerCase();
            return fileFormat.endsWith(".html") || fileFormat.endsWith(".htm") || file.isDirectory();
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
