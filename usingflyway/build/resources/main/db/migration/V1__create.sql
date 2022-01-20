CREATE TABLE topmovielist (
    movieno serial PRIMARY KEY ,
    name VARCHAR (20) UNIQUE NOT NULL ,
    genre VARCHAR (20) NOT NULL,
    rating NUMERIC
);