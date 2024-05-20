import java.util.Random;

public class Sun extends Shapes implements CustomListener{
    int pointsun = 25;
    int intervalsun=5;
    Random acak = new Random();
    int timer = 0;
    static Sun sun;
    static int totalsun = 50;
    protected Sun(int X ,int Y){
        super(X,Y);
    }
    static void sunpakai(int amount){
        totalsun =totalsun- amount;
    }
    public void sunnambah(){
        totalsun = totalsun + pointsun;
    }
    public void setSun(int amount){
        totalsun=amount;
    }
    public int getTotalsun() {
        return totalsun;
    }
    

    @Override
    public void actionPerformed() {
        if(Screen.day){
            if(timer > intervalsun*60 ){
            sunnambah(); // Mengubah posisi Y untuk turun
            timer = 0; // Reset timer setelah setiap pergerakan
            intervalsun=acak.nextInt(5,11);
            }
            timer++;
        }
        
    }
}

    


