public class Projectile {
    static int pa=0;
    public static void Project_in(Bullet bullet ){
            Screen.bullets[pa]=bullet;
            pa++;
            System.out.println(pa);

    }
}
