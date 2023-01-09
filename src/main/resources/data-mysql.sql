INSERT INTO `rights` (`label`) VALUES
                                     ('administrateur'),
                                     ('dev back');

INSERT INTO `work_station` (`title`, `description`) VALUES
                                                            ('sysadmin', 'Un administrateur système avec tous les accès aux serveurs'),
                                                            ('chef', 'Un chef de projet avec des autorisations basiques');

INSERT INTO `user` (`lastname`, `firstname`,
                    `mail`, `password`, `effective_date`) VALUES
                                                        ('bansept', 'franck', 'blabla@gmail.com' ,
                                                         'feopfhp', '2022-12-23'),
                                                        ('sawyer', 'tom', 'feif@outlook.fr',
                                                         '165152dzd', '2023-11-10');