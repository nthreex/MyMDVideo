package com.studyjams.mdvideo.Util;

/**
 * Created by syamiadmin on 2016/6/14.
 */
public class Tools {

    public static boolean isLiveStreaming(String url) {
        if (url.startsWith("rtmp://")
                || (url.startsWith("http://") && url.endsWith(".m3u8"))
                || (url.startsWith("http://") && url.endsWith(".flv"))) {
            return true;
        }
        return false;
    }
}
