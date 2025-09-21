Use testdb;

-- Table for Author
CREATE TABLE Author (
    author_id   INT PRIMARY KEY AUTO_INCREMENT,
    first_name  VARCHAR(100) NOT NULL,
    last_name   VARCHAR(100) NOT NULL,
    gender      ENUM('Male','Female','Other') DEFAULT 'Other'
);

-- Table for Book
CREATE TABLE Book (
    book_id     INT PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(255) NOT NULL,
    price       FLOAT,
    pages       INT,
    author_id   INT,
    CONSTRAINT fk_author FOREIGN KEY (author_id)
        REFERENCES Author(author_id)
        ON DELETE CASCADE
);

