package br.com.example.projetoimc;

public class MainItem {
    private int id;
    private int drawableId;
    private int textStringId;
    private int color;

    public MainItem(int id, int drawableId, int textStringId, int color) {
        this.id = id;
        this.drawableId = drawableId;
        this.color = color;
        this.textStringId = textStringId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public int getTextStringId() {
        return textStringId;
    }

    public void setTextStringId(int textStringId) {
        this.textStringId = textStringId;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
