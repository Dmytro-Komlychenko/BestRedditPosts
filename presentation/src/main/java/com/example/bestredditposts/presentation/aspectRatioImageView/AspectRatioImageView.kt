package com.example.bestredditposts.presentation.aspectRatioImageView

import android.content.Context

import android.content.res.TypedArray
import android.util.AttributeSet
import com.example.bestredditposts.R


class AspectRatioImageView(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatImageView(context, attrs) {

    private var mAspectRatio: Float

    init {
        val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView)
        mAspectRatio =
            a.getFloat(R.styleable.AspectRatioImageView_aspect_ratio, DEFAULT_ASPECT_RATIO)
        a.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val newWidth: Int = measuredWidth
        val newHeight = (newWidth / mAspectRatio).toInt()
        setMeasuredDimension(newWidth, newHeight)
    }

    fun setAspectRatio(width: Int, height: Int) {
        mAspectRatio =
            if (width > height) width.toFloat() / height
            else height.toFloat() / width
    }

    companion object {
        private const val DEFAULT_ASPECT_RATIO = 1.5F
    }
}
