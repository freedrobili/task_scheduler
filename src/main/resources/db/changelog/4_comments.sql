CREATE TABLE comments (
                          id SERIAL PRIMARY KEY,
                          comment_text TEXT NOT NULL,
                          task_id INT REFERENCES tasks(id)
);
