-- ============================
-- MEDIA TYPES
-- ============================
INSERT INTO media_type (media_type_name)
VALUES
    ('Song'),
    ('Podcast'),
    ('Movie');

-- ============================
-- GENRES
-- ============================
INSERT INTO genre (genre_name)
VALUES
    ('Pop'),
    ('Rock'),
    ('Disco'),
    ('Jazz');

-- ============================
-- ARTISTS
-- ============================
INSERT INTO artist (artist_name)
VALUES
    ('ABBA'),
    ('Lloyd'),
    ('Chris Rainbow');

-- ============================
-- ALBUMS
-- ============================
INSERT INTO album (album_name, album_year)
VALUES
    ('Greatest Hits', 1976),
    ('Smooth Sounds', 2022),
    ('Dreamtime', 1978);

-- ============================
-- MEDIA
-- ============================
-- NOTE: media_type_id references the order above (1 = Song, 2 = Podcast, 3 = Movie)
INSERT INTO media (media_name, url, release_date, media_type_id)
VALUES
    ('Dancing Queen', 'https://example.com/dancingqueen.mp3', '1976-08-15', 1),
    ('Lay All Your Love On Me', 'https://example.com/layallyourlove.mp3', '1980-07-20', 1),
    ('Midnight Conversations', 'https://example.com/midnightpodcast.mp3', '2022-04-10', 2),
    ('Rainbow Dreams', 'https://example.com/rainbowdreams.mp3', '1978-09-01', 1);

-- ============================
-- MANY-TO-MANY RELATIONSHIPS
-- ============================
-- The IDs below assume sequential auto-generation:
--   media_type → 1–3
--   genre → 1–4
--   artist → 1–3
--   album → 1–3
--   media → 1–4

-- --- MEDIA ⇄ GENRE ---
INSERT INTO media_genre (media_id, genre_id)
VALUES
    (1, 3),  -- Dancing Queen → Disco
    (2, 1),  -- Lay All Your Love On Me → Pop
    (3, 4),  -- Midnight Conversations → Jazz
    (4, 2);  -- Rainbow Dreams → Rock

-- --- MEDIA ⇄ ARTIST ---
INSERT INTO media_artist (media_id, artist_id)
VALUES
    (1, 1),  -- ABBA
    (2, 1),  -- ABBA
    (3, 2),  -- Lloyd
    (4, 3);  -- Chris Rainbow

-- --- MEDIA ⇄ ALBUM ---
INSERT INTO media_album (media_id, album_id)
VALUES
    (1, 1),  -- Dancing Queen → Greatest Hits
    (2, 1),  -- Lay All Your Love On Me → Greatest Hits
    (3, 2),  -- Midnight Conversations → Smooth Sounds
    (4, 3);  -- Rainbow Dreams → Dreamtime

-- --- ALBUM ⇄ ARTIST ---
INSERT INTO album_artist (album_id, artist_id)
VALUES
    (1, 1),  -- Greatest Hits → ABBA
    (2, 2),  -- Smooth Sounds → Lloyd
    (3, 3);  -- Dreamtime → Chris Rainbow
