CREATE TABLE tags (
                      id SERIAL PRIMARY KEY,
                      tag_name VARCHAR(50) NOT NULL,
                      task_id INT REFERENCES tasks(id)
);
