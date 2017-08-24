package com.inesadt.tv.utils;

import android.content.Context;

/**
 * @FileName: com.inesadt.tv.utils.ResourceUtils.java
 * @Author: Vita
 * @Date: 2017-04-21 10:31
 * @Usage:
 */
public class ResourceUtils {

    private ResourceUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("ResourceUtils cannot be instantiated");
    }

    /**
     * 获取id
     */
    public static int getId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "id");
    }

    /**
     * 获取layout资源id
     */
    public static int getLayoutId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "layout");
    }

    /**
     * 获取String资源id
     */
    public static int getStringId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "string");
    }

    /**
     * 获取drawable资源id
     */
    public static int getDrawableId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "drawable");
    }

    /**
     * 获取mipmap资源id
     */
    public static int getMipmapId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "mipmap");
    }

    /**
     * 获取colors资源id
     */
    public static int getColorId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "color");
    }

    /**
     * 获取dimens资源id
     */
    public static int getDimenId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "dimen");
    }

    /**
     * 获取attr资源id
     */
    public static int getAttrId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "attr");
    }

    /**
     * 获取style资源id
     */
    public static int getStyleId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "style");
    }

    /**
     * 获取anim资源id
     */
    public static int getAnimId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "anim");
    }

    /**
     * 获取arrays资源id
     */
    public static int getArrayId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "array");
    }

    /**
     * 获取integer资源id
     */
    public static int getIntegerId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "integer");
    }

    /**
     * 获取bool资源id
     */
    public static int getBoolId(Context context, String resourceName) {
        return getIdentifierByType(context, resourceName, "bool");
    }

    /**
     * 获取defType对应的资源id
     * @param defType 资源类型字符串，如"drawable"/"mipmap"
     */
    private static int getIdentifierByType(Context context, String resourceName, String defType) {
        return context.getResources().
                getIdentifier(resourceName, defType, context.getPackageName());
    }
}
