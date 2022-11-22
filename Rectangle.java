import java.awt.*;

public class Rectangle extends Figure{
    protected int length;
    protected int width;

    public Rectangle(Color color, int px,int py) {
        super(color, px, py);
        this.length=0;
        this.width=0;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getSurface(){
        return this.length*this.width;
    }

    public int getPerimeter(){
        return this.length*2+this.width*2;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setBoundingBox (int heightBB, int widthBB){
        this.length=heightBB;
        this.width=widthBB;
    }
    @Override
    public void draw (Graphics g){
        g.setColor(super.color);
        g.drawLine(this.X,this.Y,this.X,this.width+this.Y);
        g.drawLine(this.X,this.Y+this.width,this.X+this.length,this.width+this.Y);
        g.drawLine(this.X+this.length,this.Y+this.width,this.X+this.length,this.Y);
        g.drawLine(this.X+this.length,this.Y,this.X,this.Y);
    }
}