package com.ferret;

import com.jsoniter.annotation.JsonProperty;

public class Action {
    public static final int COUNTLINES = 0;
    public static final int GETLINE = 1;
    public static final int ADDLINE = 2;
    public static final int REPLACELINE = 3;
    public static final int GETTEXT = 4;
    public static final int INSERTLINE = 5;
    public static final int DELETELINE = 6;
    public static final int CREATEFILE = 7;
    public static final int SEARCHSUBSTR = 8;
    @JsonProperty(nullable = false)
    public int actionID;
    @JsonProperty(nullable = false)
    public String fileName;
    @JsonProperty(nullable = true)
    public int line = -1;
    @JsonProperty(nullable = true)
    public String text = null;

    public String doAction() throws Exception {
        FileHandler fileHandler = new FileHandler();
        switch (actionID) {
            case COUNTLINES:
                return fileHandler.countLines(fileName);
            case GETLINE:
                if(line > 0) {
                    return fileHandler.getLine(fileName, line);
                } else {
                    throw new Exception("Incorrect line asked in get line action");
                }
            case ADDLINE:
                if(text != null) {
                    return fileHandler.addLine(fileName, text);
                } else {
                    throw new Exception("Incorrect text selected");
                }
            case REPLACELINE:
                if(text != null && line > 0) {
                    return fileHandler.replaceLine(fileName, text, line);
                } else {
                    if(text != null) {
                        throw new Exception("Incorrect text selected");
                    } else if(line > 0) {
                        throw new Exception("Incorrect line asked in get line action");
                    }
                }
            case GETTEXT:
                return fileHandler.getText(fileName);
            case INSERTLINE:
                if(text != null && line > 0) {
                    return fileHandler.insertLine(fileName, text, line);
                } else {
                    if(text != null) {
                        throw new Exception("Incorrect text selected");
                    } else if(line > 0) {
                        throw new Exception("Incorrect line asked in get line action");
                    }
                }
            case DELETELINE:
                if(line > 0) {
                    return fileHandler.deleteLine(fileName, line);
                } else {
                    throw new Exception("Incorrect line asked in get line action");
                }
            case CREATEFILE:
                return fileHandler.createFile(fileName);
            case SEARCHSUBSTR:
                if(text != null) {
                    return fileHandler.searchSubStr(fileName, text);
                } else {
                    throw new Exception("Incorrect word to be found");
                }
            default:
            throw new Exception("Incorrect acion selected");
        }
    }
}