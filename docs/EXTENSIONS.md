# Extension repositories and compatibility

KirinBok will keep extension packages outside the app bundle. The app stores repository addresses and retrieves catalogue metadata and packages from the configured upstream repository only when the user requests it.

## Initial repository list

### Anime

Yuzono Aniyomi / Anikku repository:

https://raw.githubusercontent.com/yuzono/anime-repo/repo/index.min.json

This repository uses the anime extension catalogue expected by Anikku / Aniyomi-compatible clients.

### Manga

Yuzono Komikku / Mihon repository:

https://github.com/yuzono/manga-repo/raw/repo/index.pb

Keiyoushi repository:

https://github.com/keiyoushi/extensions/raw/repo/index.pb

These are manga extension catalogues using the Mihon / Komikku repository format.

## Why there are separate adapters

The anime repository publishes a JSON catalogue, while the manga repositories use the protobuf index format. Extension APK metadata, package identifiers, source interfaces, and runtime loading contracts also differ. KirinBok must not pass a manga extension through the anime loader or the reverse.

The implementation is planned as separate adapters:

- AnimeRepositoryAdapter: fetch and parse the Aniyomi-style JSON index.
- MangaRepositoryAdapter: fetch and parse the Mihon-style protobuf index.
- ExtensionPackageInstaller: obtain the selected APK and request installation with Android's user-consent flow.
- AnimeExtensionLoader and MangaExtensionLoader: load only packages matching their respective source API contracts.

## Trust and distribution

- No extension source files or extension APKs are embedded in KirinBok.
- Repository addresses are defaults, not a guarantee that upstream sources are available.
- Show repository origin, package name, version, and signing identity before installation.
- Require explicit user action to install or update an extension.
- Never silently install or update external APKs.
- Keep third-party licenses and attributions with the implementation that uses them.

## Current status

The app currently displays and copies the three repository addresses. Fetching, protobuf/JSON parsing, package verification, installation, and source loading remain future work.
