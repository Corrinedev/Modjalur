package com.corrinedev

import com.corrinedev.resource.LauncherSettings
import com.corrinedev.ui.GWindow
import com.corrinedev.util.Util
import groovy.transform.Field

import java.util.logging.Logger


@Field static launcherSettings
@Field static window
@Field static logger = Logger.getLogger("Modjalur")

Util.createDirectories()
launcherSettings = LauncherSettings.getOrDefault()

logger.info launcherSettings.dump()

window = new GWindow(launcherSettings.initialWidth, launcherSettings.initialHeight)

window.init()
