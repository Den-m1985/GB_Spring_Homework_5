-- Вставка данных в таблицу "User"
INSERT INTO users (username, password, email, role) VALUES
('user1', 'password1', 'user1@example.com', 'ROLE_USER'),
('user2', 'password2', 'user2@example.com', 'ROLE_USER'),
('admin', 'adminpassword', 'admin@example.com', 'ROLE_ADMIN');

-- Вставка данных в таблицу "Project"
INSERT INTO projects (name, description, local_date_time) VALUES
('ProjectA', 'Description for ProjectA', '2022-01-01'),
('ProjectB', 'Description for ProjectB', '2022-02-15'),
('ProjectC', 'Description for ProjectC', '2022-03-30');

-- Вставка рандомных данных для таблицы users_projects
INSERT INTO users_projects (user_id, project_id) VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (3, 3);