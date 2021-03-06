package com.datacvg.dimp.baseandroid.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.datacvg.dimp.R;
import com.lcw.library.imagepicker.utils.ImageLoader;

/**
 * FileName: GlideLoader
 * Author: 曹伟
 * Date: 2019/11/26 15:07
 * Description:
 */

public class GlideLoader implements ImageLoader {
    private RequestOptions mOptions = new RequestOptions()
            .centerCrop()
            .format(DecodeFormat.PREFER_RGB_565)
            .placeholder(R.mipmap.icon_image_default)
            .error(R.mipmap.img_default);

    private RequestOptions mPreOptions = new RequestOptions()
            .skipMemoryCache(false)
            .error(R.mipmap.img_default);

    @Override
    public void loadImage(ImageView imageView, String imagePath) {
        //小图加载
        Glide.with(imageView.getContext()).load(imagePath).apply(mOptions).into(imageView);
    }

    @Override
    public void loadPreImage(ImageView imageView, String imagePath) {
        //大图加载
        Glide.with(imageView.getContext()).load(imagePath).apply(mPreOptions).into(imageView);

    }

    @Override
    public void clearMemoryCache() {
        //清理缓存
        Glide.get(AndroidUtils.getContext()).clearMemory();
    }
}
