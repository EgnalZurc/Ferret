package com.ferret;

import java.io.*;
import java.util.Properties;

public class FileHandler {

    String basePath;

    public FileHandler() {
        Config config = new Config();
        this.basePath = config.getProperty("basePath");
    }

    public String countLines(String file) {
        Integer lines = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(basePath+file));
            while ((br.readLine()) != null) {
                lines ++;
            }
            br.close();
            return Integer.toString(lines);
        } catch (FileNotFoundException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    } 

    public String getLine(String file, int line) {
        Integer lines = 0;
        String sLine = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(basePath+file));
            while ((sLine = br.readLine()) != null) {
                lines ++;
                if(lines == line) {
                    br.close();
                    return sLine;
                }
            }
            br.close();
            return "ERROR: Selected file " + basePath+file + " has not enough lines. Selected line: " + Integer.toString(line) + " and file has " + Integer.toString(lines) + " lines";
        } catch (FileNotFoundException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    } 

    public String addLine(String file, String text) {
        try {
            // File Writer in append mode
            BufferedWriter writer = new BufferedWriter(new FileWriter(basePath+file, true));
            writer.newLine();
            writer.write(text);
            writer.close();
            return "Text " + text + " written in " + basePath+file;
        } catch (FileNotFoundException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    } 

    public String replaceLine(String file, String text, int line) {
        Integer lines = 0;
        String sLine = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(basePath+file));
            StringBuffer inputBuffer = new StringBuffer();
            while ((sLine = br.readLine()) != null) {
                lines ++;
                if(lines == line) {
                    inputBuffer.append(text);
                    inputBuffer.append('\n');
                } else {
                    inputBuffer.append(sLine);
                    inputBuffer.append('\n');
                }
            }
            br.close();
            if(line > lines) {
                return "ERROR: Selected file " + basePath+file + " has not enough lines. Selected line: " + Integer.toString(line) + " and file has " + Integer.toString(lines) + " lines";
            }
            // Write the new String with the replaced line OVER the same file
            BufferedWriter writer = new BufferedWriter(new FileWriter(basePath+file));
            writer.write(inputBuffer.toString());
            writer.close();
            return "Text " + text + " modified in " + basePath+file + " line: " + line;
        } catch (FileNotFoundException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    } 

    public String getText(String file) {
        String sLine = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(basePath+file));
            StringBuffer inputBuffer = new StringBuffer();
            while ((sLine = br.readLine()) != null) {
                inputBuffer.append(sLine);
                inputBuffer.append('\n');
            }
            br.close();
            return inputBuffer.toString();
        } catch (FileNotFoundException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    } 

    public String insertLine(String file, String text, int line) {
        Integer lines = 0;
        String sLine = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(basePath+file));
            StringBuffer inputBuffer = new StringBuffer();
            while ((sLine = br.readLine()) != null) {
                lines ++;
                if(lines == line) {
                    inputBuffer.append(text);
                    inputBuffer.append('\n');
                    lines ++;
                    inputBuffer.append(sLine);
                    inputBuffer.append('\n');
                } else {
                    inputBuffer.append(sLine);
                    inputBuffer.append('\n');
                }
            }
            br.close();
            // If file has not enough lines, inserts it in the last one
            if(line > lines) {
                inputBuffer.append(text);
                inputBuffer.append('\n');
                line = lines+1;
            }
            // Write the new String with the replaced line OVER the same file
            BufferedWriter writer = new BufferedWriter(new FileWriter(basePath+file));
            writer.write(inputBuffer.toString());
            writer.close();
            return "Text " + text + " inserted in " + basePath+file + " line: " + line;
        } catch (FileNotFoundException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    } 

    public String deleteLine(String file, int line) {
        Integer lines = 0;
        String sLine = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(basePath+file));
            StringBuffer inputBuffer = new StringBuffer();
            while ((sLine = br.readLine()) != null) {
                lines ++;
                if(lines != line) {
                    inputBuffer.append(sLine);
                    inputBuffer.append('\n');
                }
            }
            br.close();
            if(line > lines) {
                return "ERROR: Selected file " + basePath+file + " has not enough lines. Selected line: " + Integer.toString(line) + " and file has " + Integer.toString(lines) + " lines";
            }
            // Write the new String with the replaced line OVER the same file
            BufferedWriter writer = new BufferedWriter(new FileWriter(basePath+file));
            writer.write(inputBuffer.toString());
            writer.close();
            return "Line " + line + " deleted from " + basePath+file ;
        } catch (FileNotFoundException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    } 

    public String createFile(String file) {
        String sLine = null;
        try {
            PrintWriter writer = new PrintWriter(basePath+file, "UTF-8");
            writer.close();
            return "File created in path: " + basePath+file;
        } catch (FileNotFoundException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    } 

    public String searchSubStr(String file, String text) {
        String sLine = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(basePath+file));
            StringBuffer inputBuffer = new StringBuffer();
            while ((sLine = br.readLine()) != null) {
                if(sLine.indexOf(text) >= 0) {
                    inputBuffer.append(sLine);
                    inputBuffer.append('\n');
                }
            }
            br.close();
            return inputBuffer.toString();
        } catch (FileNotFoundException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    } 
}