package com.kmpalette.test

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.kmpalette.test.ImageBitmapUtils

internal actual fun loadBitmap(): ImageBitmap {
    val bytes = ImageBitmapUtils.sampleBitmapBytes()
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.size).asImageBitmap()
}