public class Peashooter extends Shapes implements CustomListener  {
    Bullet bullet;
    int time=0;
    boolean shootable=true;
    protected Peashooter(int X, int Y) {
        super(X, Y);
        //TODO Auto-generated constructor stub
    }

    public void shoot(){
        System.out.println(shootable);
        if(shootable){
            Bullet bullet = new Bullet(X, Y);
            Projectile.Project_in(bullet);
        }
    }

    @Override
    public void actionPerformed() {
        if(time>60){
            shoot();
            time=2 ;
        }else{
            time++;
        }
    }
    
}
