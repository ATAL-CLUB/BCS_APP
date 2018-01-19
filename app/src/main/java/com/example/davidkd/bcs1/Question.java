package com.example.davidkd.bcs1;

/**
 * Created by davidkd on 22/02/2017.
 */

public class Question {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String ANSWER;

    public Question() {
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        ANSWER = "";
    }

    public Question(String QUESTION, String OPTA, String OPTB, String OPTC, String ANSWER) {
        this.QUESTION = QUESTION;
        this.OPTA = OPTA;
        this.OPTB = OPTB;
        this.OPTC = OPTC;
        this.ANSWER = ANSWER;
    }

    //getter methods
    public int getID() {
        return ID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public String getOPTA() {
        return OPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public String getANSWER() {
        return ANSWER;
    }


    //setter methods
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public void setOPTA(String OPTA) {
        this.OPTA = OPTA;
    }

    public void setOPTB(String OPTB) {
        this.OPTB = OPTB;
    }

    public void setOPTC(String OPTC) {
        this.OPTC = OPTC;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }
}
