-- clean up
DROP TABLE IF EXISTS tbl_ticket;
DROP TABLE IF EXISTS tbl_event;
DROP TABLE IF EXISTS tbl_user;

-- create tables
CREATE TABLE tbl_event(
    id IDENTITY NOT NULL PRIMARY KEY,
    title varchar(255) NOT NULL,
    event_date TIMESTAMP NOT NULL
);


CREATE TABLE tbl_user(
    id IDENTITY NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL
);


CREATE TABLE tbl_ticket(
    id IDENTITY NOT NULL PRIMARY KEY,
    event_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    category varchar(255),
    place SMALLINT,
    FOREIGN KEY (event_id) REFERENCES tbl_event(id),
    FOREIGN KEY (user_id) REFERENCES tbl_user(id)
);