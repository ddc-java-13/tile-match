```sqlite
CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `timestamp` INTEGER                           NOT NULL
);

CREATE TABLE IF NOT EXISTS `Game`
(
    `game_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `difficulty` TEXT                              NOT NULL,
    `height`     INTEGER                           NOT NULL,
    `width`      INTEGER                           NOT NULL,
    `play_time`  INTEGER                           NOT NULL,
    `attempts`   INTEGER                           NOT NULL,
    `timestamp`  INTEGER                           NOT NULL,
    `user_id`    INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_Game_difficulty` ON `Game` (`difficulty`);

CREATE INDEX IF NOT EXISTS `index_Game_play_time` ON `Game` (`play_time`);

CREATE INDEX IF NOT EXISTS `index_Game_attempts` ON `Game` (`attempts`);

CREATE INDEX IF NOT EXISTS `index_Game_timestamp` ON `Game` (`timestamp`);

CREATE INDEX IF NOT EXISTS `index_Game_user_id` ON `Game` (`user_id`);


```

[`ddl.sql](sql/ddl.sql)