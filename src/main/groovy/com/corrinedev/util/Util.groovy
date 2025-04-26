package com.corrinedev.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import groovy.transform.Field

import java.nio.file.Path

@Field
static final Gson GSON = new GsonBuilder().setPrettyPrinting().create()

@Field static final Path workingDirectory = Path.of("")
@Field static final Path settingsDirectory = workingDirectory.resolve("data").resolve("settings.json")

static def createDirectories() {
    File root = new File(workingDirectory.toUri())
    List<String> roots = ["data", "instances", "auth", "assets/minecraft"]
    roots. each {new File(root, it).mkdirs()}
}