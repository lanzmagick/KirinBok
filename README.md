# KirinBok

**KirinBok** is an Android app project bringing anime watching and manga reading into one library.

The experience takes inspiration from the browsing, library, and reader patterns of [Komikku](https://github.com/komikku-app/komikku) and the anime discovery/player workflow of [Anikku](https://github.com/komikku-app/anikku). KirinBok will use its own UI and implementation.

## Direction

- One app with separate Anime and Manga areas.
- A shared library, history, downloads, and settings area.
- Separate anime and manga extension systems because their package APIs and repository indexes differ.
- Extensions are obtained from external repositories. Extension APKs and extension source code are **not bundled** into KirinBok.
- Android-first, built with Kotlin, Jetpack Compose, and Material 3.

## Extension repositories

The initial catalogue addresses are documented in the app:

- Anime: Yuzono Aniyomi/Anikku repository.
- Manga: Yuzono Komikku/Mihon repository.
- Manga: Keiyoushi repository.

The current foundation commit only lists these external repositories. Fetching catalogues, validating packages, installing extensions, and loading their source APIs are not implemented yet.

## Project status

**Foundation scaffold**

Currently included: Android project structure, Material 3 navigation shell, separate Anime/Manga/Library screens, the extension repository list, and architecture/roadmap notes.

Not yet included: live source browsing, extension package installation/loading, online playback, manga page fetching, offline downloads, or a distributable APK.

See [docs/ROADMAP.md](docs/ROADMAP.md) and [docs/EXTENSIONS.md](docs/EXTENSIONS.md) for the implementation plan.
