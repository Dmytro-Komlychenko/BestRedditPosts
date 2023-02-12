package com.example.bestredditposts.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import java.io.OutputStream
import java.util.*

object ImageDownloader {
    fun downloadImageIntoGallery(context: Context, imageView: ImageView): Boolean {
        val contentResolver = context.contentResolver

        val images: Uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        } else {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }

        val contentValues = ContentValues()
        contentValues.put(
            MediaStore.Images.Media.DISPLAY_NAME,
            System.currentTimeMillis().toString() + ".jpg"
        )
        contentValues.put(MediaStore.Images.Media.MIME_TYPE, "images/*")
        val uri: Uri = contentResolver.insert(images, contentValues)!!
        try {
            val bitmapDrawable = imageView.drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap
            val outputStream: OutputStream? =
                contentResolver.openOutputStream(Objects.requireNonNull(uri))
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            Objects.requireNonNull(outputStream)

            Snackbar.make(
                imageView,
                "Image saved succesfully",
                Snackbar.LENGTH_SHORT or Snackbar.LENGTH_INDEFINITE
            ).show()

        } catch (e: Exception) {
            Snackbar.make(
                imageView,
                "Image not saved",
                Snackbar.LENGTH_SHORT or Snackbar.LENGTH_INDEFINITE
            ).show()
            e.printStackTrace()
        }
        return true
    }
}