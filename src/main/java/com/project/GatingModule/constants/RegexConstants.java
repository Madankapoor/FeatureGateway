package com.project.GatingModule.constants;

public class RegexConstants {
  public static final String CONSECUTIVE_SPACES = "[ ]+";
  public static final String ANY_WHITESPACE = "\\s+";
  public static final String STRING_CONSTANT =  "\".*\"" ;  //"\\\"(\\\\.|[^\"\\\\])*\\\""; // \"(\\.|[^"\\])*\"
  public static final String INTEGER_CONSTANT = "[-+]?[0-9]+";
  public static final String DOUBLE_CONSTANT = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
  public static final String USER_LOOKUP = "[a-zA-Z]+(\\.[a-zA-Z0-9]+)*";
  public static final String BOOLEAN_CONSTANT = "^(?i)(true|false)$";
  public static final String WITH_DELIMITER = "((?<=(%1$s))|(?=(%1$s)))";
}