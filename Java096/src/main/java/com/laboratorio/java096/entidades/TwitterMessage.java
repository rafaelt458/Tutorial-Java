package com.laboratorio.java096.entidades;

public class TwitterMessage {
    private String text;

    public TwitterMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}