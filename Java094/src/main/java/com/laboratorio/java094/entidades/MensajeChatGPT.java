package com.laboratorio.java094.entidades;

public class MensajeChatGPT {
    private String model;
    private String prompt;
    private int max_tokens;
    private double temperature;
    private int n;

    public MensajeChatGPT(String model, String prompt, int max_tokens, double temperature, int n) {
        this.model = model;
        this.prompt = prompt;
        this.max_tokens = max_tokens;
        this.temperature = temperature;
        this.n = n;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(int max_tokens) {
        this.max_tokens = max_tokens;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}