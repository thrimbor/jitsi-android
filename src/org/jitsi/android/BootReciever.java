/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package org.jitsi.android;

import android.content.*;
import net.java.sip.communicator.util.*;
import org.jitsi.android.gui.*;

/**
 * Called when the Android boot process finished and Jitsi can be started.
 */
public class BootReciever
    extends BroadcastReceiver
{
    /**
     * The logger.
     */
    private static final Logger logger
            = Logger.getLogger(BootReciever.class);

    /**
     * Name of config property that indicates whether Jitsi should be started
     * on boot.
     */
    public static final String START_ON_BOOT_PROPERTY
        = "org.jitsi.android.start_on_boot";

    @Override
    public void onReceive(Context context, Intent intent) {
        final boolean start = true;
//                JitsiApplication.getConfig()
//                .getBoolean(START_ON_BOOT_PROPERTY, true);

        if (logger.isDebugEnabled())
        {
            logger.debug("Will start Jitsi: " + start);
        }

        if (start)
        {
            Intent i = new Intent(context, LauncherActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

}
