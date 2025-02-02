package com.kmpalette.loader

import androidx.compose.ui.graphics.ImageBitmap
import com.kmpalette.loader.ByteArrayLoader
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

public object Base64Loader : ImageBitmapLoader<String> {

    /**
     * @throws[IllegalArgumentException] - when the symbols for decoding are padded incorrectly or
     * there are extra symbols after the padding.
     */
    @OptIn(ExperimentalEncodingApi::class)
    override suspend fun load(input: String): ImageBitmap {
        val base64Bytes = Base64.decode(input.stripBase64Prefix())
        return ByteArrayLoader.load(base64Bytes)
    }
}

internal fun String.stripBase64Prefix(): String {
    return if (contains(",")) substringAfter(",") else this
}