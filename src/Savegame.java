import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Savegame {
    static Savegame instance;
    public static Savegame getInstance(){
        if(instance==null){
            instance=new Savegame();
        }
        return instance;
    }
    public void saving(){
        Saveformat saveformat = new Saveformat();
        saveformat.setSave(Sun.sun.getTotalsun(), Screen.plants, Screen.zombies, Screen.bullets, Gamepanel.ticksystem.getTime(), Inventory.decks);
        Savefile savefile = new Savefile(saveformat); 
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(savefile);

        try (FileWriter writer = new FileWriter("SaveFIle.json")) {
            writer.write(json);
            System.out.println("Data has been saved to gameData.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}

