package com.lukechenshui.jresume;

import com.beust.jcommander.Parameter;
import com.lukechenshui.jresume.themes.BaseTheme;
import com.lukechenshui.jresume.validators.ThemeNameValidator;

import java.util.HashMap;

/**
 * Created by luke on 1/1/17.
 */
public class Config {
    @Parameter(names = {"--output", "-o"}, description = "The output directory for the generated resume.")
    static String outputDirectory = "output";
    @Parameter(names = {"--theme", "-t"}, description = "The theme to use.", validateWith = ThemeNameValidator.class)
    static String themeName = "default";
    @Parameter(names = {"--server-mode", "-s"}, description = "Launches JResume in server mode.")
    static boolean serverMode = false;
    @Parameter(names = {"--server-port", "-sp"}, description = "The port that JResume will listen to when in server mode.")
    static int serverPort = 8080;
    /*If the serverMode parameter is present then --input can be set to anything as it's only important if
      JResume is not running as a server
    */
    @Parameter(names = {"--input", "-i"}, description = "The location of the input file.", required = true)
    static String inputFileName;


    private static HashMap<String, BaseTheme> themeHashMap = new HashMap<String, BaseTheme>();


    public static void addTheme(Object theme) {
        if (theme instanceof BaseTheme) {
            BaseTheme themeObj = (BaseTheme) theme;
            themeHashMap.put(themeObj.getThemeName(), themeObj);
        } else {
            throw new IllegalArgumentException("Object passed to addTheme is not instance or decendant of BaseTheme.");
        }

    }

    public static HashMap<String, BaseTheme> getThemeHashMap() {
        return themeHashMap;
    }

    public static void setThemeHashMap(HashMap<String, BaseTheme> themeHashMap) {
        Config.themeHashMap = themeHashMap;
    }

    public static String getOutputDirectory() {
        return outputDirectory;
    }

    public static void setOutputDirectory(String outputDirectory) {
        Config.outputDirectory = outputDirectory;
    }

    public static String getThemeName() {
        return themeName;
    }

    public static void setThemeName(String themeName) {
        Config.themeName = themeName;
    }

    public static String getInputFileName() {
        return inputFileName;
    }

    public static void setInputFileName(String inputFileName) {
        Config.inputFileName = inputFileName;
    }

    public static boolean isServerMode() {
        return serverMode;
    }

    public static void setServerMode(boolean serverMode) {
        Config.serverMode = serverMode;
    }

    public static int getServerPort() {
        return serverPort;
    }

    public static void setServerPort(int serverPort) {
        Config.serverPort = serverPort;
    }
}
