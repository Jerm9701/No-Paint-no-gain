import java.awt.*;

public class Square extends Rectangle {

    public Square(Color color, int px, int py) {
        super(color, px, py);
    }

    public void setLength(int length) {
        super.length = length;
        super.width = length;
    }

    public void setWidth(int width) {
        super.width = width;
        super.length = width;
    }

    public void setBoundingBox (int heightBB, int widthBB){
        if(heightBB<widthBB) {
            this.setWidth(widthBB);
        }
        else{
            this.setLength(heightBB);
        }
    }

}