# KirinBok roadmap

## Phase 0 — Foundation

- [x] Create Android / Kotlin / Compose project shell.
- [x] Add Home, Anime, Manga, and Library navigation.
- [x] Add a repository list for Yuzono anime, Yuzono manga, and Keiyoushi manga.
- [x] Document compatibility boundaries and no-bundled-extension policy.
- [ ] Build and validate the first debug APK in CI.

## Phase 1 — Extension foundation

- [ ] Fetch and parse the anime JSON catalogue.
- [ ] Fetch and parse the manga protobuf catalogues.
- [ ] Add repository enable/disable, refresh, and error states.
- [ ] Add package metadata and signing identity inspection.
- [ ] Add explicit APK installation and update flow.
- [ ] Implement separate anime and manga source loaders.

## Phase 2 — Manga reader

- [ ] Browse manga sources and search/filter titles.
- [ ] Add manga details and chapter list.
- [ ] Load pages from remote and downloaded chapters.
- [ ] Add vertical webtoon, LTR, RTL, and single-page reading modes.
- [ ] Persist chapter/page progress and reading history.

## Phase 3 — Anime player

- [ ] Browse anime sources and search/filter titles.
- [ ] Add anime details and season/episode lists.
- [ ] Resolve extension-provided video variants and subtitles.
- [ ] Add playback, seek, track selection, picture-in-picture, and resume.
- [ ] Persist episode progress and watch history.

## Phase 4 — Shared library and offline support

- [ ] Combine anime and manga in one library with type filters.
- [ ] Add continue-watching and continue-reading rows.
- [ ] Add download queues and offline playback/reading.
- [ ] Add backup/restore for library and progress.
- [ ] Add tablet layout and accessibility checks.

## Release process

Update the root release notes first, then bump the version in builtsrc/version.kt before building or running an APK. The app's Gradle versionName and versionCode are read from that file.
