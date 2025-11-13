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
    ('Classical');

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
    (1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
    (6, 1), (7, 2), (8, 3), (9, 4), (10, 5),
    (11, 1), (12, 2), (13, 3), (14, 4), (15, 5),
    (16, 1), (17, 2), (18, 3), (19, 4), (20, 5);

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
    (1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
    (6, 6), (7, 7), (8, 8), (9, 9), (10, 10),
    (11, 11), (12, 12), (13, 13), (14, 14), (15, 15),
    (16, 16), (17, 17), (18, 18), (19, 19), (20, 20);

-- ============================
-- ALBUM TRACKS
-- ============================
INSERT INTO album_track (album_id, media_id, track_number)
VALUES
    -- Greatest Hits (1)
    (1, 1, 1), (1, 2, 2), (1, 4, 3), (1, 5, 4),

    -- Smooth Sounds (2)
    (2, 3, 1), (2, 6, 2), (2, 11, 3),

    -- Dreamtime (3)
    (3, 4, 1), (3, 12, 2), (3, 18, 3),

    -- Rolling Thunder (4)
    (4, 5, 1), (4, 7, 2), (4, 14, 3),

    -- Light of the City (5)
    (5, 6, 1), (5, 10, 2), (5, 19, 3),

    -- Echoes (6)
    (6, 7, 1), (6, 15, 2), (6, 17, 3),

    -- Retro Fever (7)
    (7, 8, 1), (7, 11, 2), (7, 2, 3),

    -- Golden Hour (8)
    (8, 9, 1), (8, 13, 2), (8, 16, 3),

    -- Ocean Dreams (9)
    (9, 10, 1), (9, 4, 2), (9, 12, 3),

    -- Electric Skyline (10)
    (10, 11, 1), (10, 15, 2), (10, 14, 3),

    -- Soul Remedy (11)
    (11, 12, 1), (11, 1, 2), (11, 18, 3),

    -- Blood Moon (12)
    (12, 13, 1), (12, 5, 2), (12, 16, 3),

    -- Run Wild (13)
    (13, 14, 1), (13, 15, 2), (13, 19, 3),

    -- Solar Drift (14)
    (14, 15, 1), (14, 3, 2), (14, 20, 3),

    -- Northern Lights (15)
    (15, 16, 1), (15, 17, 2), (15, 2, 3),

    -- Velvet Skies (16)
    (16, 17, 1), (16, 18, 2), (16, 6, 3),

    -- Poetry in Vinyl (17)
    (17, 18, 1), (17, 1, 2), (17, 11, 3),

    -- Skyward (18)
    (18, 19, 1), (18, 3, 2), (18, 12, 3),

    -- Backroads (19)
    (19, 20, 1), (19, 14, 2), (19, 7, 3),

    -- The Navigator (20)
    (20, 2, 1), (20, 5, 2), (20, 10, 3);

-- ============================
-- ADDITIONAL MEDIA (21-120)
-- ============================
INSERT INTO media (media_name, url, release_date, media_type_id)
VALUES
    -- Songs 21-100
    ('Starlight Dance', 'https://example.com/starlightdance.mp3', '2020-03-12', 1),
    ('Velvet Horizon', 'https://example.com/velvethorizon.mp3', '2021-06-08', 1),
    ('Electric Moon', 'https://example.com/electricmoon.mp3', '2019-11-19', 1),
    ('Golden Waves', 'https://example.com/goldenwaves.mp3', '2022-01-23', 1),
    ('Neon Dreams', 'https://example.com/neondreams.mp3', '2020-07-14', 1),
    ('Crystal Sky', 'https://example.com/crystalsky.mp3', '2021-09-02', 1),
    ('Midnight Fire', 'https://example.com/midnightfire.mp3', '2019-12-30', 1),
    ('Aurora Nights', 'https://example.com/auroranights.mp3', '2022-04-11', 1),
    ('Retro Love', 'https://example.com/retrolove.mp3', '2020-08-19', 1),
    ('Celestial Ride', 'https://example.com/celestialride.mp3', '2021-02-05', 1),
    ('Galaxy Groove', 'https://example.com/galaxygroove.mp3', '2020-10-11', 1),
    ('Moonlit Echo', 'https://example.com/moonlitecho.mp3', '2021-05-27', 1),
    ('Solar Wind', 'https://example.com/solarwind.mp3', '2019-03-18', 1),
    ('Neon Pulse', 'https://example.com/neonpulse.mp3', '2020-07-22', 1),
    ('Twilight Spark', 'https://example.com/twilightspark.mp3', '2021-12-01', 1),
    ('Velvet Thunder', 'https://example.com/velvetthunder.mp3', '2019-11-09', 1),
    ('Radiant Sky', 'https://example.com/radiantsky.mp3', '2020-06-15', 1),
    ('Electric Waves', 'https://example.com/electricwaves.mp3', '2021-08-12', 1),
    ('Aurora Glow', 'https://example.com/auroraglow.mp3', '2020-09-05', 1),
    ('Retro Horizon', 'https://example.com/retrohorizon.mp3', '2021-03-18', 1),
    -- Songs 41-100 (similarly generate names)
    ('Lunar Beat', 'https://example.com/lunarbeat.mp3', '2022-02-10', 1),
    ('Celestial Dreams', 'https://example.com/celestialdreams.mp3', '2021-04-15', 1),
    ('Starlit Journey', 'https://example.com/starlitjourney.mp3', '2020-12-22', 1),
    ('Midnight Glow', 'https://example.com/midnightglow.mp3', '2019-09-30', 1),
    ('Radiant Pulse', 'https://example.com/radiantpulse.mp3', '2022-03-18', 1),
    ('Electric Horizon', 'https://example.com/electrichorizon.mp3', '2020-07-29', 1),
    ('Velvet Dreams', 'https://example.com/velvetdreams.mp3', '2021-11-02', 1),
    ('Aurora Beats', 'https://example.com/aurorabeats.mp3', '2020-10-21', 1),
    ('Neon Sky', 'https://example.com/neonsky.mp3', '2021-05-04', 1),
    ('Retro Spark', 'https://example.com/retrospark.mp3', '2020-08-11', 1),
    ('Galaxy Lights', 'https://example.com/galaxylights.mp3', '2021-02-27', 1),
    ('Moonbeam Melody', 'https://example.com/moonbeam.mp3', '2020-12-12', 1),
    ('Solar Rhythm', 'https://example.com/solarrhythm.mp3', '2019-11-19', 1),
    ('Twilight Echo', 'https://example.com/twilightecho.mp3', '2022-01-07', 1),
    ('Neon Vibe', 'https://example.com/neonvibe.mp3', '2020-05-23', 1),
    ('Crystal Pulse', 'https://example.com/crystalpulse.mp3', '2021-09-14', 1),
    ('Aurora Tide', 'https://example.com/auroratide.mp3', '2020-03-11', 1),
    ('Retro Glow', 'https://example.com/retroglow.mp3', '2021-06-19', 1),
    ('Stellar Beat', 'https://example.com/stellarbeat.mp3', '2020-07-25', 1),
    ('Luminous Nights', 'https://example.com/luminousnights.mp3', '2021-01-30', 1),
    ('Cosmic Rhythm', 'https://example.com/cosmicrhythm.mp3', '2020-09-15', 1),
    ('Neon Dreams 2', 'https://example.com/neondreams2.mp3', '2021-04-28', 1),
    ('Aurora Song', 'https://example.com/aurorasong.mp3', '2020-12-09', 1),
    ('Retro Waves', 'https://example.com/retrowaves.mp3', '2021-03-15', 1),
    ('Moonlight Groove', 'https://example.com/moonlightgroove.mp3', '2020-06-27', 1),
    ('Solar Beats', 'https://example.com/solarbeats.mp3', '2021-08-21', 1),
    ('Twilight Melody', 'https://example.com/twilightmelody.mp3', '2020-10-19', 1),
    ('Neon Echoes', 'https://example.com/neonechoes.mp3', '2021-02-06', 1),
    ('Crystal Horizon', 'https://example.com/crystalhorizon.mp3', '2020-11-12', 1),
    ('Aurora Rhythm', 'https://example.com/aurorarhythm.mp3', '2021-05-08', 1),
    ('Retro Pulse', 'https://example.com/retropulse.mp3', '2020-07-03', 1),
    ('Lunar Vibes', 'https://example.com/lunarvibes.mp3', '2021-09-19', 1),
    ('Cosmic Glow', 'https://example.com/cosmicglow.mp3', '2020-12-26', 1),
    ('Starlit Echo', 'https://example.com/starlitecho.mp3', '2021-03-02', 1),
    ('Neon Nights', 'https://example.com/neonnights.mp3', '2020-05-14', 1),
    ('Aurora Beam', 'https://example.com/aurorabeam.mp3', '2021-07-30', 1),
    ('Retro Melody', 'https://example.com/retromelody.mp3', '2020-09-04', 1),
    ('Moonlit Vibe', 'https://example.com/moonlitvibe.mp3', '2021-01-18', 1),
    ('Solar Glow', 'https://example.com/solarglow.mp3', '2020-11-21', 1),
    ('Twilight Pulse', 'https://example.com/twilightpulse.mp3', '2021-06-13', 1),
    ('Neon Horizon', 'https://example.com/neonhorizon.mp3', '2020-08-29', 1),
    ('Crystal Vibes', 'https://example.com/crystalvibes.mp3', '2021-02-23', 1),
    ('Aurora Nights 2', 'https://example.com/auroranights2.mp3', '2020-10-08', 1),
    ('Retro Starlight', 'https://example.com/retrostarlight.mp3', '2021-04-05', 1),
    ('Stellar Pulse', 'https://example.com/stellarpulse.mp3', '2020-12-18', 1),
    ('Luminous Echo', 'https://example.com/luminousecho.mp3', '2021-03-29', 1),
    ('Cosmic Beat', 'https://example.com/cosmicbeat.mp3', '2020-06-07', 1),
    ('Neon Rhythm', 'https://example.com/neonrhythm.mp3', '2021-09-11', 1),
    ('Aurora Glow 2', 'https://example.com/auroraglow2.mp3', '2020-11-30', 1),
    ('Retro Lights', 'https://example.com/retrolights.mp3', '2021-05-19', 1),
    ('Moonbeam Pulse', 'https://example.com/moonbeampulse.mp3', '2020-07-17', 1),
    ('Solar Melody', 'https://example.com/solarmelody.mp3', '2021-01-03', 1),
    ('Twilight Vibes', 'https://example.com/twilightvibes.mp3', '2020-09-12', 1),
    ('Neon Glow', 'https://example.com/neonglow.mp3', '2021-04-11', 1),
    ('Crystal Beat', 'https://example.com/crystalbeat.mp3', '2020-12-29', 1),
    ('Aurora Nights 3', 'https://example.com/auroranights3.mp3', '2021-06-28', 1),
    ('Retro Horizon 2', 'https://example.com/retrohorizon2.mp3', '2020-10-21', 1),
    ('Lunar Melody', 'https://example.com/lunarmelody.mp3', '2021-02-14', 1),
    ('Cosmic Echo', 'https://example.com/cosmicecho.mp3', '2020-07-06', 1),
    ('Starlight Rhythm', 'https://example.com/starlightrhythm.mp3', '2021-09-23', 1),
    ('Neon Dreams 3', 'https://example.com/neondreams3.mp3', '2020-11-17', 1),
    ('Aurora Beat', 'https://example.com/aurorabeat.mp3', '2021-03-08', 1),
    ('Retro Pulse 2', 'https://example.com/retropulse2.mp3', '2020-08-02', 1),
    ('Moonlit Horizon', 'https://example.com/moonlithorizon.mp3', '2021-05-26', 1),
    ('Solar Spark', 'https://example.com/solarspark.mp3', '2020-12-09', 1),
    ('Twilight Echo 2', 'https://example.com/twilightecho2.mp3', '2021-01-21', 1),
    ('Neon Vibe 2', 'https://example.com/neonvibe2.mp3', '2020-10-30', 1),
    ('Crystal Glow', 'https://example.com/crystalglow.mp3', '2021-04-19', 1),
    ('Aurora Pulse 2', 'https://example.com/aurorapulse2.mp3', '2020-07-28', 1),
    ('Retro Lights 2', 'https://example.com/retrolights2.mp3', '2021-02-11', 1),
    ('Lunar Beat 2', 'https://example.com/lunarbeat2.mp3', '2020-09-25', 1),
    ('Cosmic Rhythm 2', 'https://example.com/cosmicrhythm2.mp3', '2021-06-05', 1),
    ('Starlit Glow', 'https://example.com/starlitglow.mp3', '2020-11-09', 1),
    ('Neon Nights 2', 'https://example.com/neonnights2.mp3', '2021-03-16', 1),
    ('Aurora Horizon', 'https://example.com/aurorahorizon.mp3', '2020-08-20', 1),
    ('Retro Moon', 'https://example.com/retromoon.mp3', '2021-01-30', 1),
    ('Moonlight Pulse 2', 'https://example.com/moonlightpulse2.mp3', '2020-12-18', 1),
    ('Solar Echo', 'https://example.com/solarecho.mp3', '2021-04-07', 1),
    ('Twilight Glow 2', 'https://example.com/twilightglow2.mp3', '2020-07-12', 1),
    ('Neon Horizon 2', 'https://example.com/neonhorizon2.mp3', '2021-02-28', 1),
    ('Crystal Dreams', 'https://example.com/crystaldreams.mp3', '2020-09-14', 1),
    ('Aurora Nightfall', 'https://example.com/auroranightfall.mp3', '2021-06-17', 1),
    ('Retro Twilight', 'https://example.com/retrotwilight.mp3', '2020-11-23', 1),
    ('Lunar Glow', 'https://example.com/lunarglow.mp3', '2021-03-04', 1),
    ('Cosmic Pulse 2', 'https://example.com/cosmicpulse2.mp3', '2020-07-09', 1),
    ('Starlit Beat', 'https://example.com/starlitbeat.mp3', '2021-08-01', 1),
    ('Neon Spark', 'https://example.com/neonspark.mp3', '2020-10-14', 1),
    ('Aurora Dreams', 'https://example.com/auroradreams.mp3', '2021-05-20', 1),
    ('Retro Glow 2', 'https://example.com/retroglow2.mp3', '2020-12-07', 1),
    ('Moonbeam Beat', 'https://example.com/moonbeambeat.mp3', '2021-01-12', 1),
    ('Solar Horizon', 'https://example.com/solarhorizon.mp3', '2020-09-18', 1),
    ('Twilight Rhythm 2', 'https://example.com/twilightrhythm2.mp3', '2021-06-23', 1),
    ('Neon Pulse 2', 'https://example.com/neonpulse2.mp3', '2020-08-30', 1),
    ('Crystal Nights', 'https://example.com/crystalnights.mp3', '2021-02-19', 1),
    ('Aurora Spark', 'https://example.com/auroraspark.mp3', '2020-10-05', 1),
    ('Retro Melody 2', 'https://example.com/retromelody2.mp3', '2021-04-12', 1),
    ('Lunar Horizon', 'https://example.com/lunarhorizon.mp3', '2020-11-15', 1),
    ('Cosmic Glow 2', 'https://example.com/cosmicglow2.mp3', '2021-03-09', 1),
    ('Starlight Pulse 2', 'https://example.com/starlightpulse2.mp3', '2020-07-21', 1),
    ('Neon Vibe 3', 'https://example.com/neonvibe3.mp3', '2021-05-29', 1),
    ('Aurora Beat 3', 'https://example.com/aurorabeat3.mp3', '2020-12-14', 1),
    ('Retro Horizon 3', 'https://example.com/retrohorizon3.mp3', '2021-01-27', 1),
    ('Moonlit Echo', 'https://example.com/moonlitecho2.mp3', '2020-10-26', 1),
    ('Solar Pulse 2', 'https://example.com/solarpulse2.mp3', '2021-06-02', 1),
    ('Twilight Glow 3', 'https://example.com/twilightglow3.mp3', '2020-08-17', 1),
    ('Neon Horizon 3', 'https://example.com/neonhorizon3.mp3', '2021-03-23', 1),
    ('Crystal Vibe 2', 'https://example.com/crystalvibe2.mp3', '2020-11-02', 1),
    ('Aurora Nights 4', 'https://example.com/auroranights4.mp3', '2021-04-24', 1),
    ('Retro Beat 2', 'https://example.com/retrobeat2.mp3', '2020-07-01', 1),
    ('Lunar Spark', 'https://example.com/lunarspark.mp3', '2021-01-15', 1),
    ('Cosmic Light', 'https://example.com/cosmiclight.mp3', '2020-09-09', 1),
    ('Starlit Rhythm 2', 'https://example.com/starlitrhythm2.mp3', '2021-06-12', 1),
    ('Neon Glow 2', 'https://example.com/neonglow2.mp3', '2020-10-31', 1),

    -- Movies 101-110
    ('Cosmic Journey', 'https://example.com/cosmicjourney.mp4', '2021-05-15', 3),
    ('The Last Horizon', 'https://example.com/lasthorizon.mp4', '2020-09-21', 3),
    ('Silent Echoes', 'https://example.com/silentechoes.mp4', '2022-03-07', 3),
    ('Northern Tales', 'https://example.com/northerntales.mp4', '2019-10-12', 3),
    ('Solar Legacy', 'https://example.com/solarlegacy.mp4', '2021-11-01', 3),
    ('Moonlight Saga', 'https://example.com/moonlightsaga.mp4', '2020-12-15', 3),
    ('Aurora Quest', 'https://example.com/auroraquest.mp4', '2021-03-29', 3),
    ('Retro Voyage', 'https://example.com/retrovoyage.mp4', '2020-08-05', 3),
    ('Starlit Odyssey', 'https://example.com/starlitodyssey.mp4', '2021-06-19', 3),
    ('Neon Horizon Movie', 'https://example.com/neonhorizon.mp4', '2020-10-23', 3),

    -- Podcasts 111-120
    ('Morning Beats', 'https://example.com/morningbeats.mp3', '2022-06-14', 2),
    ('Retro Recap', 'https://example.com/retrorecap.mp3', '2020-12-08', 2),
    ('Jazz Vibes Podcast', 'https://example.com/jazzvibes.mp3', '2021-01-22', 2),
    ('Classic Conversations', 'https://example.com/classicconversations.mp3', '2019-08-19', 2),
    ('Rock Chronicles', 'https://example.com/rockchronicles.mp3', '2022-03-30', 2),
    ('Soulful Sessions', 'https://example.com/soulfulsessions.mp3', '2021-07-18', 2),
    ('Echoes of Music', 'https://example.com/echoesofmusic.mp3', '2020-05-11', 2),
    ('Retro Radio', 'https://example.com/retro-radio.mp3', '2021-09-04', 2),
    ('Morning Melodies', 'https://example.com/morningmelodies.mp3', '2020-11-22', 2),
    ('Night Vibes Podcast', 'https://example.com/nightvibes.mp3', '2021-02-13', 2);

-- ============================
-- ADDITIONAL MEDIA / GENRE (21-120)
-- ============================
INSERT INTO media_genre (media_id, genre_id)
VALUES
    -- Songs 21-100
    (21,1),(22,2),(23,3),(24,4),(25,5),(26,1),(27,2),(28,3),(29,4),(30,5),
    (31,1),(32,2),(33,3),(34,4),(35,5),(36,1),(37,2),(38,3),(39,4),(40,5),
    (41,1),(42,2),(43,3),(44,4),(45,5),(46,1),(47,2),(48,3),(49,4),(50,5),
    (51,1),(52,2),(53,3),(54,4),(55,5),(56,1),(57,2),(58,3),(59,4),(60,5),
    (61,1),(62,2),(63,3),(64,4),(65,5),(66,1),(67,2),(68,3),(69,4),(70,5),
    (71,1),(72,2),(73,3),(74,4),(75,5),(76,1),(77,2),(78,3),(79,4),(80,5),
    (81,1),(82,2),(83,3),(84,4),(85,5),(86,1),(87,2),(88,3),(89,4),(90,5),
    (91,1),(92,2),(93,3),(94,4),(95,5),(96,1),(97,2),(98,3),(99,4),(100,5),

    -- Movies 101-110
    (101,1),(102,2),(103,3),(104,4),(105,5),(106,1),(107,2),(108,3),(109,4),(110,5),
    -- Podcasts 111-120
    (111,1),(112,2),(113,3),(114,4),(115,5),(116,1),(117,2),(118,3),(119,4),(120,5);

-- ============================
-- ADDITIONAL MEDIA / ARTIST (21-120)
-- ============================
INSERT INTO media_artist (media_id, artist_id)
VALUES
    -- Songs 21-100, rotate artist IDs 1-20
    (21,1),(22,2),(23,3),(24,4),(25,5),(26,6),(27,7),(28,8),(29,9),(30,10),
    (31,11),(32,12),(33,13),(34,14),(35,15),(36,16),(37,17),(38,18),(39,19),(40,20),
    (41,1),(42,2),(43,3),(44,4),(45,5),(46,6),(47,7),(48,8),(49,9),(50,10),
    (51,11),(52,12),(53,13),(54,14),(55,15),(56,16),(57,17),(58,18),(59,19),(60,20),
    (61,1),(62,2),(63,3),(64,4),(65,5),(66,6),(67,7),(68,8),(69,9),(70,10),
    (71,11),(72,12),(73,13),(74,14),(75,15),(76,16),(77,17),(78,18),(79,19),(80,20),
    (81,1),(82,2),(83,3),(84,4),(85,5),(86,6),(87,7),(88,8),(89,9),(90,10),
    (91,11),(92,12),(93,13),(94,14),(95,15),(96,16),(97,17),(98,18),(99,19),(100,20),
    -- Movies 101-110
    (101,1),(102,2),(103,3),(104,4),(105,5),(106,6),(107,7),(108,8),(109,9),(110,10),
    -- Podcasts 111-120
    (111,1),(112,2),(113,3),(114,4),(115,5),(116,6),(117,7),(118,8),(119,9),(120,10);

-- ============================
-- ADDITIONAL MEDIA / GENRE (121-173)
-- ============================
INSERT INTO media_genre (media_id, genre_id)
VALUES
    -- Assign genres 1-5 in rotation
    (121,1),(122,2),(123,3),(124,4),(125,5),
    (126,1),(127,2),(128,3),(129,4),(130,5),
    (131,1),(132,2),(133,3),(134,4),(135,5),
    (136,1),(137,2),(138,3),(139,4),(140,5),
    (141,1),(142,2),(143,3),(144,4),(145,5),
    (146,1),(147,2),(148,3),(149,4),(150,5),
    (151,1),(152,2),(153,3),(154,4),(155,5),
    (156,1),(157,2),(158,3),(159,4),(160,5),
    (161,1),(162,2),(163,3),(164,4),(165,5),
    (166,1),(167,2),(168,3),(169,4),(170,5),
    (171,1),(172,2),(173,3);

-- ============================
-- ADDITIONAL MEDIA / ARTIST (121-173)
-- ============================
INSERT INTO media_artist (media_id, artist_id)
VALUES
    -- Assign artists 1-20 in rotation
    (121,1),(122,2),(123,3),(124,4),(125,5),
    (126,6),(127,7),(128,8),(129,9),(130,10),
    (131,11),(132,12),(133,13),(134,14),(135,15),
    (136,16),(137,17),(138,18),(139,19),(140,20),
    (141,1),(142,2),(143,3),(144,4),(145,5),
    (146,6),(147,7),(148,8),(149,9),(150,10),
    (151,11),(152,12),(153,13),(154,14),(155,15),
    (156,16),(157,17),(158,18),(159,19),(160,20),
    (161,1),(162,2),(163,3),(164,4),(165,5),
    (166,6),(167,7),(168,8),(169,9),(170,10),
    (171,11),(172,12),(173,13);

