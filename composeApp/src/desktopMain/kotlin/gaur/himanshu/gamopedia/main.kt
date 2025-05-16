package gaur.himanshu.gamopedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import gaur.himanshu.gamopedia.di.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Gamopedia",
    ) {
        initKoin()
        App()
    }
}