import java.awt.*;

public class Ellipse extends Figure{
    protected int SemiAxisX;
    protected int SemiAxisY;

    public Ellipse(Color color, int px,int py) {
        super(color, px, py);
        this.SemiAxisX=0;
        this.SemiAxisY=0;
    }

    public int getSemiAxisX() {
        return SemiAxisX;
    }

    public int getWidth() {
        return SemiAxisY;
    }

    public int getSurface(){
        return (int) Math.PI * this.SemiAxisX*this.SemiAxisY;
    }

    public int getPerimeter(){
        int a = (int) Math.pow(this.SemiAxisX,2);
        int b = (int) Math.pow(this.SemiAxisY,2);
        return (int)Math.PI *2* (int) Math.pow(a+b/2,1/2);
    }

    public void setSemiAxisX(int SemiAxisX) {
        this.SemiAxisX = SemiAxisX;
    }

    public void setSemiAxisY(int SemiAxisY) {
        this.SemiAxisY = SemiAxisY;
    }

    @Override
    public void setBoundingBox (int heightBB, int widthBB){
        this.SemiAxisX = widthBB/2;
        this.SemiAxisY = heightBB/2;
    }
    @Override
    public void draw (Graphics g){
        int c=this.X;
        int d= this.Y;
        if (this.SemiAxisY<0){
            c= this.X+2*this.SemiAxisY;
        }
        if (this.SemiAxisX<0) {
            d= this.Y+2*this.SemiAxisX;
        }
        g.setColor(this.color);
        g.drawOval(c,d,Math.abs(this.SemiAxisY)*2,Math.abs(this.SemiAxisX)*2);
    }
}