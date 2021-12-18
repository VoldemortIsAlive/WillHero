package sample;

public class Hero extends GameObjects{

    Hero(float x,float y){
        super(x,y);

    }
    @Override
    public boolean OnCollide(GameObjects Hero){
        return false;
    }
}
