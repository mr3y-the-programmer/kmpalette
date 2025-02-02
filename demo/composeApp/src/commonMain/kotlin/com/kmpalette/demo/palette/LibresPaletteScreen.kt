package com.kmpalette.demo.palette

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.kmpalette.demo.Res
import com.kmpalette.loader.LibresLoader
import com.kmpalette.rememberPaletteState
import io.github.skeptick.libres.compose.painterResource

private val images = listOf(
    Res.image.bg_1,
    Res.image.bg_2,
    Res.image.bg_3,
    Res.image.bg_4,
    Res.image.bg_5,
    Res.image.bg_6,
    Res.image.bg_7,
    Res.image.bg_8,
    Res.image.bg_9,
    Res.image.bg_10,
)

class LibresPaletteScreen : Screen {

    @Composable
    override fun Content() {
        PaletteScreen(
            images = images,
            paletteState = rememberPaletteState(LibresLoader),
            painterResource = { _, image -> image.painterResource() }
        )
    }
}