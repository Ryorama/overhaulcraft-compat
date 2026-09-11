package com.ryorama.overhaulcraft.utils;

import net.minecraft.client.Minecraft;

import java.io.*;

//Download external mods from curseforge on startup
public class ExternalDownloader {
    public String API_KEY = "";
    public File modsFolder;

    public ExternalDownloader() {
        modsFolder = new File(Minecraft.getInstance().gameDirectory + "/mods");
    }
}
