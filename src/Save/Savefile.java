package Save;
import java.util.ArrayList;

public class Savefile {
    public ArrayList<String>dStrings=new ArrayList<>();
    public ArrayList<Integer>dtimer=new ArrayList<>();
    public ArrayList<Boolean>dcooldown=new ArrayList<>();
    public int jumlahdeck;

    public int s_sun;
    public int s_ticktime;
    public int s_tickspawn;

    public ArrayList<String>bname=new ArrayList<>();
    public ArrayList<Integer>bx=new ArrayList<>();
    public ArrayList<Integer>by=new ArrayList<>();
    public ArrayList<Integer>bdamage=new ArrayList<>();

    public ArrayList<String>pname=new ArrayList<>();
    public ArrayList<Integer>px=new ArrayList<>();
    public ArrayList<Integer>py=new ArrayList<>();
    public ArrayList<Integer>phealth=new ArrayList<>();
    public ArrayList<Integer>ptimer=new ArrayList<>();

    public ArrayList<Boolean>pfp=new ArrayList<>();
    public ArrayList<Integer>lptimer=new ArrayList<>();
    public ArrayList<Integer>lpdamage=new ArrayList<>();

    public ArrayList<String>zname=new ArrayList<>();
    public ArrayList<Integer>zx=new ArrayList<>();
    public ArrayList<Integer>zy=new ArrayList<>();
    public ArrayList<Integer>zhealth=new ArrayList<>();
    public ArrayList<Integer>ztimer=new ArrayList<>();
    public ArrayList<Boolean>zmoving=new ArrayList<>();
    public ArrayList<Boolean>zslowed=new ArrayList<>();
    public ArrayList<Integer>zslowtime=new ArrayList<>();

    public ArrayList<Integer>rzsun=new ArrayList<>();
    public ArrayList<Integer>rztime=new ArrayList<>();

    public ArrayList<Integer>aztime=new ArrayList<>();
    public ArrayList<Boolean>zjump=new ArrayList<>(); 
    
    public Savefile(Saveformat saveformat){
        dStrings= saveformat.dStrings;
        dtimer=saveformat.dtimer;
        dcooldown=saveformat.dcooldown;
        jumlahdeck=saveformat.jumlahdeck;

        s_sun=saveformat.s_sun;
        s_ticktime=saveformat.s_ticktime;
        s_tickspawn=saveformat.s_tickspawn;

        bname=saveformat.bname;
        bx=saveformat.bx;
        by=saveformat.by;
        bdamage=saveformat.bdamage;

        pname=saveformat.pname;
        px=saveformat.px;
        py=saveformat.py;
        phealth=saveformat.phealth;
        ptimer=saveformat.ptimer;

        pfp=saveformat.pfp;
        lpdamage=saveformat.lpdamage;
        lptimer=saveformat.lptimer;

        zname=saveformat.zname;
        zx=saveformat.zx;
        zy=saveformat.zy;
        zhealth=saveformat.zhealth;
        ztimer=saveformat.ztimer;
        zmoving=saveformat.zmoving;
        zslowed=saveformat.zslowed;
        zslowtime=saveformat.zslowtime;
    
        rzsun=saveformat.rzsun;
        rztime=saveformat.rztime;
    
        aztime=saveformat.aztime;
        zjump =saveformat.zjump;

    }
}
