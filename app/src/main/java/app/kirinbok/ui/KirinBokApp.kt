package app.kirinbok.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import app.kirinbok.ui.screens.AnimeScreen
import app.kirinbok.ui.screens.ExtensionsScreen
import app.kirinbok.ui.screens.HomeScreen
import app.kirinbok.ui.screens.LibraryScreen
import app.kirinbok.ui.screens.MangaScreen

private enum class MainTab(
    val title: String,
    val icon: ImageVector,
) {
    Home("Home", Icons.Filled.Home),
    Anime("Anime", Icons.Filled.LiveTv),
    Manga("Manga", Icons.Filled.MenuBook),
    Library("Library", Icons.Filled.Bookmarks),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KirinBokApp() {
    var selectedTab by rememberSaveable { mutableStateOf(MainTab.Home) }
    var showExtensions by rememberSaveable { mutableStateOf(false) }

    BackHandler(enabled = showExtensions) {
        showExtensions = false
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = { Text(if (showExtensions) "Extensions" else "KirinBok") },
                navigationIcon = {
                    if (showExtensions) {
                        IconButton(onClick = { showExtensions = false }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
                actions = {
                    if (!showExtensions) {
                        IconButton(onClick = { showExtensions = true }) {
                            Icon(Icons.Filled.Extension, contentDescription = "Extensions")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
            )
        },
        bottomBar = {
            if (!showExtensions) {
                NavigationBar {
                    MainTab.entries.forEach { tab ->
                        NavigationBarItem(
                            selected = selectedTab == tab,
                            onClick = { selectedTab = tab },
                            icon = { Icon(tab.icon, contentDescription = tab.title) },
                            label = { Text(tab.title) },
                        )
                    }
                }
            }
        },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            if (showExtensions) {
                ExtensionsScreen()
            } else {
                when (selectedTab) {
                    MainTab.Home -> HomeScreen(
                        onAnimeClick = { selectedTab = MainTab.Anime },
                        onMangaClick = { selectedTab = MainTab.Manga },
                    )
                    MainTab.Anime -> AnimeScreen(onOpenExtensions = { showExtensions = true })
                    MainTab.Manga -> MangaScreen(onOpenExtensions = { showExtensions = true })
                    MainTab.Library -> LibraryScreen()
                }
            }
        }
    }
}
