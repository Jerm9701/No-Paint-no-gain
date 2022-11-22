import java.awt.*;

public class Circle extends Ellipse{

    public Circle(Color color, int px, int py) {
        super(color, px, py);
        super.SemiAxisX=0;
        super.SemiAxisY=0;
    }

    public void setSemiAxisX(int AxisX){
        super.SemiAxisX=AxisX/2;
        super.SemiAxisY=AxisX/2;
    }

    public void setSemiAxisY(int AxisY){
        super.SemiAxisY=AxisY/2;
        super.SemiAxisX=AxisY/2;
    }

    @Override
    public void setBoundingBox (int heightBB, int widthBB){
        if(heightBB<widthBB) {
            this.setSemiAxisY(widthBB);
        }
        else{
            this.setSemiAxisX(heightBB);
        }
    }
}