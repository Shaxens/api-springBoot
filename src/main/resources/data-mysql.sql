INSERT INTO `rights` (`label`) VALUES
                                     ('administrateur'),
                                     ('dev back');


INSERT INTO `work_station` (`title`, `description`) VALUES
                                                            ('sysadmin', 'Un administrateur système avec tous les accès aux serveurs'),
                                                            ('chef', 'Un chef de projet avec des autorisations basiques');

INSERT INTO `user` (`lastname`, `firstname`,
                    `mail`, `password`, `effective_date`) VALUES
                                                        ('vietti', 'arthur', 'blabla@gmail.com' ,
                                                         'feopfhp', '2022-12-23'),
                                                        ('sawyer', 'tom', 'feif@outlook.fr',
                                                         '165152dzd', '2023-11-10');

INSERT INTO `team` (creating_date, leader_id) VALUES (CURRENT_DATE, 1);

UPDATE user
            SET team_id = 1
            WHERE id = 1;

INSERT INTO `project` (title, description,
                       starting_date) VALUES
                                         ('Mon premier projet', 'Ceci est un projet de test', CURRENT_DATE)