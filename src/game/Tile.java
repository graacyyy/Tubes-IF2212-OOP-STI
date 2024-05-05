package game;

public class Tile {
    private char type; // Jenis petak: 'Z' untuk zombie, 'P' untuk pool, '.' untuk petak kosong
    private boolean isFilled;
    private boolean isPoolArea;
    private boolean isRestricted; // TIles yang merupakan bagian yang harus dilindungi

    public Tile(char type, boolean isFilled, boolean isPoolArea, boolean isRestricted) {
        this.type = type;
        this.isFilled = isFilled;
        this.isPoolArea = isPoolArea;
        this.isRestricted = isRestricted;
    }

    public char getType() {

        return type;
    }

    public void setType(char type) {

        this.type = type;
    }

    public boolean getIsFilled(){

        return isFilled;
    }

    public void setIsFilled(boolean isFilled){

        this.isFilled = isFilled;
    }

    public boolean getIsPoolArea(){

        return isPoolArea;
    }

    public void setIsPoolArea(boolean isPoolArea){
        this.isPoolArea = isPoolArea;
    }

    public boolean getIsRestricted(){
        return this.isRestricted;
    }

    public void setIsRestricted (boolean isRestricted){
        this.isRestricted = isRestricted;
    }
}
