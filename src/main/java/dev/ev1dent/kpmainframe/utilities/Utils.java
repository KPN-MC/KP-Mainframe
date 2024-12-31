package dev.ev1dent.kpmainframe.utilities;

import dev.ev1dent.kpmainframe.KPMainFrame;
import org.apache.logging.log4j.Level;

import java.util.logging.Logger;

public class Utils {

    private static KPMainFrame kpMainFrame() {
        return KPMainFrame.getPlugin(KPMainFrame.class);
    }

    // Logger - Duh
    public void logInfo(String loggedMessage, Object... args){
        kpMainFrame().getLogger().info(parseMessage(loggedMessage, args));
    }
    public String parseMessage(String loggedMessage, Object... args){
        return String.format(loggedMessage, args);
    }
}
