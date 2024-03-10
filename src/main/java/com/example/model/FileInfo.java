package com.example.model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileInfo {
    private final File file;
    public final String name() {
        return file.getName();
    }
    public boolean isDirectory() {
        return file.isDirectory();
    }
    public String path () {
        return file.getPath();
    }
    public String size() {
        if(file.isDirectory()) {
            return "";
        }
        return Long.toString(file.length()) + "B";
    }
    public String lastModified() {
        return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date(file.lastModified()));
    }
    public FileInfo(File file) {
        this.file = file;
    }
}
