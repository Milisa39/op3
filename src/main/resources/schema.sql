CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    second_name VARCHAR(255)
);

CREATE TABLE skills (
    id SERIAL PRIMARY KEY,
    student_id BIGINT,
    name VARCHAR(255),
    hard BOOLEAN,
    soft BOOLEAN,
    FOREIGN KEY (student_id) REFERENCES students(id)
);
