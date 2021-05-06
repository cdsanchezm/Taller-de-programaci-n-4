package com.example.taller_4;

import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID =1L;

    private String name;
    private String description;
    private String date;
    private String image;

    public Usuario(String name,String image,String description, String date){
        this.name = name;
        this.image = image;
        this.description = description;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

}
