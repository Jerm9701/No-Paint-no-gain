import java.io.Serializable;
public class Point implements  Serializable{
    public int X;
    public int Y;
    public Point(){
        this.X = 0;
        this.Y = 0;
    }

    public Point(int a, int b)
    {
        this.X = a;
        this.Y = b;
    }

    public int getX(){return X;}
    public int getY(){return Y;}
    @Override
    public String toString() {return("<"+this.X+","+">"+this.Y);}



}