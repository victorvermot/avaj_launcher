package com.vvermot.simulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MessageManager {

    public static MessageManager INSTANCE;
    BufferedWriter writer;
    private Map<Meteo, String> baloonMessages = Map.of(
            Meteo.SUN, "Quoikousun",
            Meteo.FOG, "Quoikoufog",
            Meteo.SNOW, "Quoikousnow",
            Meteo.RAIN, "Quoikourain",
            Meteo.LANDED, "The baloon landed safely"
    );
    private Map<Meteo, String> jetPlaneMessages = Map.of(
            Meteo.SUN, "The sun is melting my body",
            Meteo.FOG, "The fog limits my speed",
            Meteo.SNOW, "The snow is making me chilly",
            Meteo.RAIN, "The rain is going to make it difficult to land",
            Meteo.LANDED, "The jetplane reached the ground"
    );
    private Map<Meteo, String> helicopterMessages = Map.of(
            Meteo.SUN, "The sun is reflecting on my palms",
            Meteo.FOG, "The fog is making it hard to see",
            Meteo.SNOW, "The snow is white-washing me",
            Meteo.RAIN, "The rain makes me slippery",
            Meteo.LANDED, "The helicopter landed safely"
    );

    public static MessageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MessageManager();
        }
        return INSTANCE;
    }

    public void saveMessage(String prefix, Vehicles type, Meteo weather) {
        switch (type) {
            case BALOON -> writeToFile(prefix + baloonMessages.get(weather));
            case JETPLANE -> writeToFile(prefix + jetPlaneMessages.get(weather));
            case HELICOPTER -> writeToFile(prefix + helicopterMessages.get(weather));
        };
    }

    public void writeToFile(String newLine) {
        if (writer == null) {
            try {
                this.writer = new BufferedWriter(new FileWriter("simulation.txt"));
            }
            catch (IOException e) {
                System.out.println("Could not create output file");
            }
        }
        try {
            writer.append(newLine).append("\n");
        }
        catch (IOException e) {
            System.out.println("Could add new line in output file");
        }

    }

    public void closeFile() {
        try {
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Could not delete output file");
        }
    }

}
