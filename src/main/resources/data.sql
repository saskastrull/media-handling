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
    ('Jazz'),
    ('Classical'),
    ('Hip-Hop'),
    ('Electronic'),
    ('Country'),
    ('Folk'),
    ('Soul'),
    ('Metal'),
    ('Reggae'),
    ('Blues'),
    ('Indie'),
    ('Funk'),
    ('Alternative'),
    ('R&B'),
    ('Latin'),
    ('Soundtrack'),
    ('World');

-- ============================
-- ARTISTS
-- ============================
INSERT INTO artist (artist_name)
VALUES
    ('ABBA'),
    ('Lloyd'),
    ('Chris Rainbow'),
    ('The Rolling Waves'),
    ('Celina Park'),
    ('EchoNova'),
    ('RetroStar'),
    ('Golden Lights'),
    ('Mara Sol'),
    ('Neon Horizon'),
    ('SoulVibe'),
    ('Crimson Tide'),
    ('The Midnight Runners'),
    ('DJ Solaris'),
    ('Aurora Blue'),
    ('Velvet Storm'),
    ('The Vinyl Poets'),
    ('Juniper Sky'),
    ('The High Roads'),
    ('Eli Navarro');

-- ============================
-- ALBUMS
-- ============================
INSERT INTO album (album_name, album_year)
VALUES
    ('Greatest Hits', 1976),
    ('Smooth Sounds', 2022),
    ('Dreamtime', 1978),
    ('Rolling Thunder', 2019),
    ('Light of the City', 2021),
    ('Echoes', 2018),
    ('Retro Fever', 1983),
    ('Golden Hour', 2020),
    ('Ocean Dreams', 2017),
    ('Electric Skyline', 2023),
    ('Soul Remedy', 2015),
    ('Blood Moon', 2022),
    ('Run Wild', 2019),
    ('Solar Drift', 2024),
    ('Northern Lights', 2016),
    ('Velvet Skies', 2020),
    ('Poetry in Vinyl', 2018),
    ('Skyward', 2021),
    ('Backroads', 2014),
    ('The Navigator', 2023);

-- ============================
-- MEDIA
-- ============================
INSERT INTO media (media_name, url, release_date, media_type_id)
VALUES
    ('Dancing Queen', 'https://example.com/dancingqueen.mp3', '1976-08-15', 1),
    ('Lay All Your Love On Me', 'https://example.com/layallyourlove.mp3', '1980-07-20', 1),
    ('Midnight Conversations', 'https://example.com/midnightpodcast.mp3', '2022-04-10', 2),
    ('Rainbow Dreams', 'https://example.com/rainbowdreams.mp3', '1978-09-01', 1),
    ('Rolling High', 'https://example.com/rollinghigh.mp3', '2019-03-15', 1),
    ('City Lights', 'https://example.com/citylights.mp3', '2021-05-11', 1),
    ('Echoes of Time', 'https://example.com/echoesoftime.mp3', '2018-07-08', 1),
    ('Retro Nights', 'https://example.com/retronights.mp3', '1983-09-22', 1),
    ('Golden Hour Podcast', 'https://example.com/goldenhourpodcast.mp3', '2020-10-15', 2),
    ('Ocean Breeze', 'https://example.com/oceanbreeze.mp3', '2017-06-30', 1),
    ('Electric Dreams', 'https://example.com/electricdreams.mp3', '2023-02-19', 1),
    ('Soul Remedy Live', 'https://example.com/soulremedylive.mp3', '2015-11-07', 1),
    ('Moonlight Drive', 'https://example.com/moonlightdrive.mp3', '2022-01-25', 1),
    ('Run Wild Documentary', 'https://example.com/runwildmovie.mp4', '2019-09-13', 3),
    ('Solar Frequencies', 'https://example.com/solarfrequencies.mp3', '2024-03-12', 1),
    ('Northern Glow', 'https://example.com/northernglow.mp3', '2016-12-01', 1),
    ('Velvet Skies Acoustic', 'https://example.com/velvetskies.mp3', '2020-02-14', 1),
    ('Poet’s Soul', 'https://example.com/poetssoul.mp3', '2018-08-09', 1),
    ('Skyward Episode 1', 'https://example.com/skyward1.mp3', '2021-09-01', 2),
    ('Backroads Movie', 'https://example.com/backroads.mp4', '2014-05-04', 3);

-- ============================
-- RELATIONSHIPS
-- ============================

-- --- MEDIA / GENRE ---
INSERT INTO media_genre (media_id, genre_id)
VALUES
    (1, 3), (2, 1), (3, 4), (4, 2),
    (5, 2), (6, 1), (7, 7), (8, 3),
    (9, 4), (10, 8), (11, 7), (12, 10),
    (13, 14), (14, 19), (15, 7), (16, 5),
    (17, 15), (18, 9), (19, 4), (20, 8);

-- --- MEDIA / ARTIST ---
INSERT INTO media_artist (media_id, artist_id)
VALUES
    (1, 1), (2, 1), (3, 2), (4, 3),
    (5, 4), (6, 5), (7, 6), (8, 7),
    (9, 8), (10, 9), (11, 10), (12, 11),
    (13, 12), (14, 13), (15, 14), (16, 15),
    (17, 16), (18, 17), (19, 18), (20, 19);

-- --- ALBUM / ARTIST ---
INSERT INTO album_artist (album_id, artist_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10),
    (11, 11),
    (12, 12),
    (13, 13),
    (14, 14),
    (15, 15),
    (16, 16),
    (17, 17),
    (18, 18),
    (19, 19),
    (20, 20);

-- ============================
-- ALBUM TRACKS
-- ============================
INSERT INTO album_track (album_id, media_id, track_number)
VALUES
    -- Greatest Hits (1)
    (1, 1, 1),
    (1, 2, 2),
    (1, 4, 3),
    (1, 5, 4),

    -- Smooth Sounds (2)
    (2, 3, 1),
    (2, 6, 2),
    (2, 11, 3),

    -- Dreamtime (3)
    (3, 4, 1),
    (3, 12, 2),
    (3, 18, 3),

    -- Rolling Thunder (4)
    (4, 5, 1),
    (4, 7, 2),
    (4, 14, 3),

    -- Light of the City (5)
    (5, 6, 1),
    (5, 10, 2),
    (5, 19, 3),

    -- Echoes (6)
    (6, 7, 1),
    (6, 15, 2),
    (6, 17, 3),

    -- Retro Fever (7)
    (7, 8, 1),
    (7, 11, 2),
    (7, 2, 3),

    -- Golden Hour (8)
    (8, 9, 1),
    (8, 13, 2),
    (8, 16, 3),

    -- Ocean Dreams (9)
    (9, 10, 1),
    (9, 4, 2),
    (9, 12, 3),

    -- Electric Skyline (10)
    (10, 11, 1),
    (10, 15, 2),
    (10, 14, 3),

    -- Soul Remedy (11)
    (11, 12, 1),
    (11, 1, 2),
    (11, 18, 3),

    -- Blood Moon (12)
    (12, 13, 1),
    (12, 5, 2),
    (12, 16, 3),

    -- Run Wild (13)
    (13, 14, 1),
    (13, 15, 2),
    (13, 19, 3),

    -- Solar Drift (14)
    (14, 15, 1),
    (14, 3, 2),
    (14, 20, 3),

    -- Northern Lights (15)
    (15, 16, 1),
    (15, 17, 2),
    (15, 2, 3),

    -- Velvet Skies (16)
    (16, 17, 1),
    (16, 18, 2),
    (16, 6, 3),

    -- Poetry in Vinyl (17)
    (17, 18, 1),
    (17, 1, 2),
    (17, 11, 3),

    -- Skyward (18)
    (18, 19, 1),
    (18, 3, 2),
    (18, 12, 3),

    -- Backroads (19)
    (19, 20, 1),
    (19, 14, 2),
    (19, 7, 3),

    -- The Navigator (20)
    (20, 2, 1),
    (20, 5, 2),
    (20, 10, 3);
