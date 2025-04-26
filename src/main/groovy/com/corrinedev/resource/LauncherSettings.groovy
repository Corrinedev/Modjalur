package com.corrinedev.resource

import com.corrinedev.util.Util
import com.google.gson.annotations.SerializedName

import java.nio.file.Files
import java.nio.file.Path

class LauncherSettings {
    @SerializedName("defaultAllocatedRam")
    int defaultAllocatedRam
    @SerializedName("preGenRam")
    int preGenRam
    @SerializedName("initialWidth")
    int initialWidth = 1280
    @SerializedName("initialHeight")
    int initialHeight = 480
    @SerializedName("defaultFlags")
    String defaultFlags = ""
    @SerializedName("title")
    String title = "Modjular"
    @SerializedName("showLogs")
    boolean showLogs

    LauncherSettings(boolean showLogs, String defaultFlags, int preGenRam, int defaultAllocatedRam) {
        this.showLogs = showLogs
        this.defaultFlags = defaultFlags
        this.preGenRam = preGenRam
        this.defaultAllocatedRam = defaultAllocatedRam
    }
    LauncherSettings(){}

    static LauncherSettings getOrDefault() {
        if (Files.exists(Util.settingsDirectory)) {
            FileReader reader = new FileReader(Util.settingsDirectory.toFile())
            return Util.GSON.fromJson(reader, LauncherSettings.class)
        }
        else {
            def settings = new LauncherSettings(false, "", 512, 4096)
            Files.writeString(Util.settingsDirectory, Util.GSON.toJson(settings))
            return settings
        }
    }
}
