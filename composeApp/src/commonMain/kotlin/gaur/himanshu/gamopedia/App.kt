package gaur.himanshu.gamopedia

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import gaur.himanshu.gamopedia.navigation.FavoriteNavGraph
import gaur.himanshu.gamopedia.navigation.GameNavGraph
import gaur.himanshu.gamopedia.navigation.SearchNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navHostController = rememberNavController()
        val bottomPadding = WindowInsets.statusBars.asPaddingValues().calculateBottomPadding()
        NavHost(navHostController, startDestination = GameNavGraph.Dest.Root.route) {
            listOf(
                GameNavGraph,
                SearchNavGraph,
                FavoriteNavGraph
            ).forEach {
                it.build(
                    modifier = Modifier.padding(top = bottomPadding).fillMaxSize(),
                    navHostController = navHostController,
                    navGraphBuilder = this
                )
            }
        }
    }
}