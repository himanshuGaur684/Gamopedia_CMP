package gaur.himanshu.game.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit,
    onSearchClick:()->Unit,
    onClick:(Int)-> Unit

) {

    val viewModel = koinViewModel<GameViewModel>()

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    GameScreenContent(
        modifier = modifier.fillMaxSize(), uiState = uiState.value,
        onFavoriteClick = onFavoriteClick,
        onSearchClick = onSearchClick,
        onClick = onClick
    )

}

@Composable
fun GameScreenContent(
    modifier: Modifier = Modifier, uiState: GameScreen.UiState,
    onFavoriteClick: () -> Unit,
    onSearchClick:()->Unit,
    onClick:(Int)-> Unit
) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Gamopedia") },
                actions = {
                    IconButton(onClick = onSearchClick) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }

                    IconButton(onClick = onFavoriteClick) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                    }
                },
                backgroundColor = Color.White
            )
        }) {

        if (uiState.isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }


        if (uiState.error.isNotBlank()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(uiState.error)
            }
        }

        uiState.data?.let { data ->
            LazyColumn(modifier = modifier.fillMaxSize()) {
                items(data) {
                    Card(
                        modifier = Modifier.padding(12.dp).fillMaxWidth().height(350.dp)
                            .clickable { onClick(it.id) },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Box(Modifier.fillMaxSize()) {
                            AsyncImage(
                                model = it.imageUrl, contentDescription = null,
                                modifier = Modifier.fillMaxWidth().height(350.dp),
                                contentScale = ContentScale.Crop
                            )

                            Box(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
                                    .background(
                                        color = Color.White,
                                        shape = RoundedCornerShape(12.dp)
                                    ).fillMaxWidth().align(Alignment.BottomCenter),
                            ) {
                                Text(
                                    it.name, style = MaterialTheme.typography.body1,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}
