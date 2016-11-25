public class LaserBeam{
    LaserBlock home;
    angle direction;
    public LaserBeam(LaserBlock a,angle b){
        home=a;
        direction=new angle(b);
    }
    public LaserBeam(LaserBlock a,double b){
        home=a;
        direction=new angle(b);
    }
}
