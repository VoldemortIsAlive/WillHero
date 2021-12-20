package sample;
public class Hero extends GameObjects{
    double X_coord = 0;
    double Y_coord = 0;
    Hero(float x,float y){
        super(x,y);
    }


    public boolean OnCollide(GameObjects Hero){
        return false;
    }

}
