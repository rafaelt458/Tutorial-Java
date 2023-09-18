package com.laboratorio.java096.entidades;

import org.json.JSONObject;

public class Choice {
    private String text;
    private int index;
    private int logprobs;
    private String finish_reason;

    public Choice(String jsonEntity) {
        JSONObject job = new JSONObject(jsonEntity);
        this.text = job.getString("text");
        this.index = job.getInt("index");
        if (!job.isNull("logprobs")) {
            this.logprobs = job.getInt("logprobs");
        }
        this.finish_reason = job.getString("finish_reason");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(int logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
}