package com.laboratorio.java096.entidades;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RespuestaChatGPT {
    private String id;
    private String object;
    private int created;
    private String model;
    private List<Choice> choices;
    private Usage usage;

    public RespuestaChatGPT(String jsonEntity) {
        JSONObject job = new JSONObject(jsonEntity);
        this.id = job.getString("id");
        this.object = job.getString("object");
        this.created = job.getInt("created");
        this.model = job.getString("model");
        this.choices = new ArrayList<>();
        JSONArray array = job.getJSONArray("choices");
        for (int i = 0; i < array.length(); i++) {
            Choice choice = new Choice(array.getJSONObject(i).toString());
            this.choices.add(choice);
        }
        this.usage = new Usage(job.getJSONObject("usage").toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }
}