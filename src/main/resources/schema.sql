CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    task_status VARCHAR(50) NOT NULL,
    local_date_time TIMESTAMP NOT NULL
);