import java.awt.*;

public abstract class Figure extends Point{
    protected int x,y;
    protected int width, height;
    private Color lineColor;
    private int heightBB;
    private int widthBB;
    private Graphics G;
    public Color color;
    protected Point Corner;
    public Figure(Color color, int px, int py) {
        super.X=px;
        super.Y=py;
        this.Corner = new Point(px,py);
        this.color = color;
    }

    public Color getColor() {return color;}

    public Point getCorner() {return Corner;}

    public abstract void setBoundingBox (int heightBB, int widthBB);
    public abstract void draw (Graphics g);



    @Override
    public String toString(){
        return "Corner = <"+ this.Corner+"> , Color = "+this.color;

    }

}
