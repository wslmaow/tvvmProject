package com.code.mvvm.config;

/**
 * @author：tqzhang on 18/7/27 16:19
 */
public class Constants {
    public static final String NET_WORK_STATE = "1";
    public static final String ERROR_STATE = "2";
    public static final String LOADING_STATE = "3";
    public static final String SUCCESS_STATE = "4";

    public static final String HOME_TAG = "home";
    public static final String WORK_TAG = "work";
    public static final String VIDEO_TAG = "video";
    public static final String MINE_TAG = "mine";

    public final static String MATERIAL = "Material";
    public final static String FOLLOW_DRAW = "FollowDraw";
    public final static String ARTICLE = "Article";
    public final static String LIVE = "Live";
    public final static String BOOK = "Book";
    public final static String DYNAMIC = "Dynamic";
    public final static String ACTIVITY = "Activity";
    public final static String QA = "Qa";

    public static final String TYPE_CORRECT = "1";
    public static final String TYPE_WORK = "2";
    public static final String TYPE_MATERIAL_SUBJECT = "3";
    public static final String TYPE_ARTICLE = "4";
    public static final String TYPE_FOLLOW_DRAW = "5";
    public static final String TYPE_LIVE = "6";
    public static final String TYPE_LESSON = "7";


    public static final String PAGE_RN = "20";

    private static final int MAX_HEAP_SIZE = (int) Runtime.getRuntime().maxMemory();
    public static final int MAX_CACHE_MEMORY_SIZE = MAX_HEAP_SIZE / 4;
    public static final int MAX_CACHE_DISK_SIZE = 250 * 1024 * 1024;

}
