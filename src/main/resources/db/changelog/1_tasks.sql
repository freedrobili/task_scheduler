CREATE TABLE tasks (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       assigned_to VARCHAR(255),
                       created_by VARCHAR(255) NOT NULL,
                       is_favorite BOOLEAN DEFAULT FALSE,
                       state VARCHAR(20) DEFAULT 'PLANNED',
    -- Другие поля задачи, которые у вас могут быть
);
