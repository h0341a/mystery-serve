CREATE TABLE user(
    uid TINYINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(16) UNIQUE ,
    password VARCHAR(32)
);

CREATE TABLE blog_category(
    id TINYINT	AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (16) NOT NULL UNIQUE,
    description VARCHAR(64)
);

CREATE TABLE blog(
    bid INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(24) NOT NULL UNIQUE ,
    category_id TINYINT DEFAULT 1,
    description VARCHAR(64),
    content TEXT NOT NULL ,
    create_date DATETIME NOT NULL DEFAULT NOW(),
    visits BIGINT DEFAULT 0,
    comment BIGINT DEFAULT 0,
    star BIGINT DEFAULT 0,
    FOREIGN KEY (`category_id`) REFERENCES blog_category(`id`)
);

CREATE TABLE comment(
    cid INTEGER AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(8) NOT NULL ,
    email VARCHAR (64),
    content VARCHAR(128) NOT NULL,
    blog_id INTEGER NOT NULL ,
    star_count INTEGER DEFAULT 0,
    parent_cid INTEGER DEFAULT 0,
    create_date DATETIME NOT NULL DEFAULT NOW(),
    FOREIGN KEY (`blog_id`) REFERENCES blog(bid)
);