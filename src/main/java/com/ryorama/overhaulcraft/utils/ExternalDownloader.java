package com.ryorama.overhaulcraft.utils;

import com.ryorama.overhaulcraft.OverhaulCraft;
import net.minecraft.client.Minecraft;
import org.jcodec.common.io.IOUtils;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Download external mods from curseforge on startup
public class ExternalDownloader {
    public HashMap<String, String> externalDownloads = new HashMap<>();
    public File modsFolder;

    public ExternalDownloader() {
        //modsFolder = new File(Minecraft.getInstance().gameDirectory + "/mods");

        externalDownloads.put("advanced-chimneys", "8032509");
        externalDownloads.put("ato", "7825464");
        externalDownloads.put("alexs-delight", "7612806");
        externalDownloads.put("better-fps-render-distance", "5664511");
        externalDownloads.put("better-tips-nbt-tag", "5964322");
        externalDownloads.put("cosmetic-armor-reworked", "5610835");
        externalDownloads.put("click-machine", "6751569");
        externalDownloads.put("ars-technica", "7642730");
        externalDownloads.put("ars-elemental", "8159010");
        externalDownloads.put("apothic-spawners", "7492121");
        externalDownloads.put("apothic-enchanting", "8107222");
        externalDownloads.put("apothic-attributes", "7445079");
        externalDownloads.put("apotheosis", "8102047");
        externalDownloads.put("angel-ring", "6891800");
        externalDownloads.put("framework", "7530361");
        externalDownloads.put("forgeendertech", "8031577");
        externalDownloads.put("flux-networks", "6089446");
        externalDownloads.put("flight-api", "6891762");
        externalDownloads.put("fastsuite", "7527945");
        externalDownloads.put("fast-async-world-save-forge-fabric", "7955071");
        externalDownloads.put("fast-leaf-decay", "5849090");
        externalDownloads.put("extreme-reactors-create-compat", "6648748");
        externalDownloads.put("extreme-reactors", "7344744");
        externalDownloads.put("eccentric-tome", "7042141");
        externalDownloads.put("drive-by-wire-with-sable", "8101676");
        externalDownloads.put("domum-ornamentum", "7789217");
        externalDownloads.put("desertification", "8121054");
        externalDownloads.put("delighto-flight", "8012635");
        externalDownloads.put("cupboard", "7746488");
        externalDownloads.put("croptopia", "7958876");
        externalDownloads.put("construction-wands-revived", "8120523");
        externalDownloads.put("confluence-dimension-patch", "7523135");
        externalDownloads.put("configured", "7276577");
        externalDownloads.put("cobblemon-botany-pots", "7074619");
        externalDownloads.put("client-crafting", "7920161");
        externalDownloads.put("chunk-sending-forge-fabric", "7926632");
        externalDownloads.put("building-gadgets", "6850515");
        externalDownloads.put("blockui", "7790469");
        externalDownloads.put("ftb-library-forge", "7746959");
        externalDownloads.put("ftb-teams-forge", "7878281");
        externalDownloads.put("ftb-quests-forge", "7878289");
        externalDownloads.put("ftb-xmod-compat", "7715134");
        externalDownloads.put("ftb-chunks-forge", "7608681");
        externalDownloads.put("ftb-ultimine-forge", "8078515");
        externalDownloads.put("ftb-essentials", "7608733");
        externalDownloads.put("goblin-traders", "6427515");
        externalDownloads.put("haydenapi", "6302841");
        externalDownloads.put("hostile-neural-networks", "6751495");
        externalDownloads.put("ice-and-fire-dragons-x-better-combat", "6778934");
        externalDownloads.put("jadecolonies", "5721338");
        externalDownloads.put("mahou-tsukai-combat", "6042364");
        externalDownloads.put("minecolonies", "8138370");
        externalDownloads.put("more-dragon-eggs", "5746086");
        externalDownloads.put("more-red", "5763286");
        externalDownloads.put("more-red-x-cc-tweaked-compat", "5685611");
        externalDownloads.put("multi-piston", "7097877");
        externalDownloads.put("overloaded-armor-bar", "5537850");
        externalDownloads.put("placebo", "6926281");
        externalDownloads.put("probejs", "8122173");
        externalDownloads.put("projecte", "6611984");
        externalDownloads.put("projecte-gregtech-ceu-modern", "6804850");
        externalDownloads.put("refurbished-furniture", "7473565");
        externalDownloads.put("spice-of-life-carrot-edition", "7374098");
        externalDownloads.put("structurize", "8138382");
        externalDownloads.put("structure-essentials-forge-fabric", "7962596");
        externalDownloads.put("synthetics", "7167970");
        externalDownloads.put("the-great-outdoors", "7586218");
        externalDownloads.put("tool-belt", "8001966");
        externalDownloads.put("torchmaster-cobblemon-compat", "6388838");
        externalDownloads.put("the-twilight-forest", "7797302");
        externalDownloads.put("zerocore", "7344742");
    }

    public void handleExternalMods() {
        if (modsFolder.listFiles() != null) {
            List<File> modFiles = Arrays.stream(modsFolder.listFiles()).toList();
            HashMap<String, String> queuedModDownloads = new HashMap<>();
            for (Map.Entry<String, String> externalMods : externalDownloads.entrySet()) {
                for (File mod : modFiles) {
                    if (mod.getName().contains(externalMods.getKey())) {
                        if (!isModVersionSame(mod, externalMods.getValue())) {
                            mod.deleteOnExit();
                        }
                    } else {
                        queuedModDownloads.put(externalMods.getKey(), externalMods.getValue());
                    }
                }
            }
            if (!queuedModDownloads.isEmpty()) {
                downloadMods(queuedModDownloads);
            }
        }
    }

    public boolean isModVersionSame(File mod, String corecctVersion) {
        return mod.getName().contains(corecctVersion);
    }

    public  void downloadMods(HashMap<String, String> queuedMods) {
        String baseCurseforgeUrl = "https://legacy.curseforge.com/minecraft/mc-mods/";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest;
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_1_1);

        for (Map.Entry<String, String> mods : queuedMods.entrySet()) {
            String downloadUrlString = baseCurseforgeUrl + mods.getKey() + "/downloads/" + mods.getValue();
            URI modUri = URI.create(downloadUrlString);
            OverhaulCraft.LOGGER.info("Downloading curseforge mod from " + downloadUrlString);

            httpRequest = requestBuilder.uri(modUri).build();
            httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofInputStream()).thenAccept(response -> {
                try {
                    Files.copy(response.body(), modsFolder.toPath());
                } catch (IOException e) {
                    OverhaulCraft.LOGGER.error(e);
                    throw new RuntimeException(e);
                }

            });
        }

        Minecraft.getInstance().close();
    }
}
