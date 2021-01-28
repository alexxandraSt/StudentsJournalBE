package com.studensJournal.utils.validation;


public class Validator {
    private static final int MIN_LENGTH_TOKEN = 5;

    public static boolean validBackOfficeToken(String token){
        token =  token.replaceAll("\\s","");
        return token.length() > MIN_LENGTH_TOKEN;
    }

    public static boolean validBackOfficeCallBack(String name, String url){
        if (name == null || url == null) return  false;
        return (name.replaceAll("\\s","").length() > 0 && url.replaceAll("\\s","").length()>MIN_LENGTH_TOKEN);
    }



}
