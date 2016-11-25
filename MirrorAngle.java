public class MirrorAngle extends angle{
    public MirrorAngle(double in){
        set(in);
    }
    public MirrorAngle(angle in){
        set(in);
    }
    public MirrorAngle(MirrorAngle in){
        set(in);
    }
    @Override
    public void set(double in){
        data=in%180;
    }
    @Override
    public void set(angle in){
        set(in.get());
    }
    public void set(MirrorAngle in){
        set(in.get());
    }
}
