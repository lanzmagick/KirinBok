# Architecture

KirinBok is a single Android application with two independent content domains.

## App layers

- app: application startup, navigation, permissions, and app-wide configuration.
- feature/anime: anime discovery, entry details, episode lists, watch history, and player UI.
- feature/manga: manga discovery, entry details, chapter lists, reading history, and reader UI.
- feature/library: combined library, filters, progress, and continue-watching/reading surfaces.
- feature/extensions: repository management, extension details, installation status, and trust prompts.
- engine/player: playback engine, subtitle handling, playback session, and external playback intents.
- engine/reader: page loading, image caching, reading modes, gestures, and chapter navigation.
- engine/extensions: catalogue adapters, package verification, extension class loading, and source bridges.
- data: persistence, repositories, backups, and shared metadata.

The first scaffold currently places the UI shell in the app module. These boundaries are the target as the project grows; they are not all implemented modules yet.

## Shared data, separate engines

Anime and manga share app navigation, library access, settings, and local storage patterns. They do not share extension contracts or content execution code.

Anime playback and manga page reading are separate engines. The shared library stores a media type with every entry so that progress and resume actions are routed to the correct engine.

## UI direction

Use Material 3 and a clean, content-first layout. Borrow interaction patterns rather than copying artwork or branding: source browsing and reading controls from Komikku; anime discovery, episode management, and player controls from Anikku.

## Reliability

- Keep extension catalogue parsing isolated by format.
- Do not execute extension code before package identity and signature checks.
- Use Android's package installation consent flow where required.
- Keep progress writes resilient to process death.
- Do not make the home screen depend on one source being online.
