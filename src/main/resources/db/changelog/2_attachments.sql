CREATE TABLE attachments (
    id SERIAL PRIMARY KEY,
    file_name VARCHAR(255) NOT NULL,
    task_id INT REFERENCES tasks(id)
);
