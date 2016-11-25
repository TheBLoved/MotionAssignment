public class angle{
    protected double data;
    public angle(){
        data=0;
    }
    public angle(double in){
        set(in);
    }
    public angle(angle in){
        set(in);
    }
    public void set(double in){
        data=in%360;
    }
    public void set(angle in){
        set(in.get());
    }
    public double get(){
        return data;
    }
    @Override
    public String toString(){
        return (""+data+"°");
    }
}