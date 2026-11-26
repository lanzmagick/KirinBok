package app.kirinbok.data

enum class ExtensionKind {
    ANIME,
    MANGA,
}

data class ExtensionRepository(
    val name: String,
    val kind: ExtensionKind,
    val indexUrl: String,
    val description: String,
)

object DefaultExtensionRepositories {
    val all = listOf(
        ExtensionRepository(
            name = "Yuzono Anime Extensions",
            kind = ExtensionKind.ANIME,
            indexUrl = "https://raw.githubusercontent.com/yuzono/anime-repo/repo/index.min.json",
            description = "Anikku / Aniyomi-compatible anime catalogue.",
        ),
        ExtensionRepository(
            name = "Yuzono Manga Extensions",
            kind = ExtensionKind.MANGA,
            indexUrl = "https://github.com/yuzono/manga-repo/raw/repo/index.pb",
            description = "Komikku / Mihon-compatible manga catalogue.",
        ),
        ExtensionRepository(
            name = "Keiyoushi Extensions",
            kind = ExtensionKind.MANGA,
            indexUrl = "https://github.com/keiyoushi/extensions/raw/repo/index.pb",
            description = "Mihon-compatible manga catalogue.",
        ),
    )
}
