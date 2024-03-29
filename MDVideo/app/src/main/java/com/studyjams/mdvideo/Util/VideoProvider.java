package com.studyjams.mdvideo.Util;

/**
 * Created by zwx on 2016/6/22.
 */

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

//先忽略拼音类和异常类
/*
import com.jwzhangjie.videoplayer.util.AppLog;
import com.jwzhangjie.videoplayer.util.PinyinUtils;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
*/

public class VideoProvider implements AbstructProvider {
    private Context context;

    public VideoProvider(Context context) {
        this.context = context;
    }

    @Override
    public List<Video> getList() {
        List<Video> list = null;
        if (context != null) {
            Cursor cursor = context.getContentResolver().query(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null,
                    null, null);
            if (cursor != null) {
                list = new ArrayList<Video>();
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor
                            .getColumnIndexOrThrow(MediaStore.Video.Media._ID));
                    String title = cursor
                            .getString(cursor
                                    .getColumnIndexOrThrow(MediaStore.Video.Media.TITLE));
                    String album = cursor
                            .getString(cursor
                                    .getColumnIndexOrThrow(MediaStore.Video.Media.ALBUM));
                    String artist = cursor
                            .getString(cursor
                                    .getColumnIndexOrThrow(MediaStore.Video.Media.ARTIST));
                    String displayName = cursor
                            .getString(cursor
                                    .getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME));
                    String mimeType = cursor
                            .getString(cursor
                                    .getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE));
                    String path = cursor
                            .getString(cursor
                                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA));
                    long duration = cursor
                            .getInt(cursor
                                    .getColumnIndexOrThrow(MediaStore.Video.Media.DURATION));
                    long size = cursor
                            .getLong(cursor
                                    .getColumnIndexOrThrow(MediaStore.Video.Media.SIZE));
                    String title_key = "A";
                    //下面可能是拼音问题，先不管，注释掉先
                    /*
                    if (title != null && title.length() > 0) {
                        try {
                            title_key = PinyinUtils.chineneToSpell(title.charAt(0) + "");
                        } catch (BadHanyuPinyinOutputFormatCombination e) {
                            e.printStackTrace();
                        }
                    }
                    */
                    //AppLog.e("dd",title_key);
                    Video video = new Video(id, title, album, artist, displayName, mimeType, path, size, duration, title_key);
                    list.add(video);

                    Log.d("VideoProvider", "succeed to add a video");
                }
                cursor.close();
            }
        }
        return list;
    }

}