insert into anime(id, name, description, number_of_episodes, number_of_seasons, genre) values (1, "Berserk", "Anime que se passa na Era medieval.", 70, 3, "terror");
insert into anime(id, name, description, number_of_episodes, number_of_seasons, genre) values (2, "Naruto", "Anime de lutas ninjas, cujo protagonista almeja chegar ao cargo mais alto da sua vila e com isso ser respeitado.", 720, 30, "luta");
insert into anime(id, name, description, number_of_episodes, number_of_seasons, genre) values (3, "Kabaneri", "Anime no estilo steampunk que tem como tema principal a luta contra zumbis.", 12, 1, "aventura");
insert into anime(id, name, description, number_of_episodes, number_of_seasons, genre) values (4, "Digimon", "Anime sobre criaturas digitais que acabam chegando na Terra e agora precisam lutar para defender seus novos amigos humanos.", 51, 1, "aventura");

insert into anime_character(id, anime_id, name, description, favorite_food, height, weight, age) values (1, 1, "Guts", "Guerreiro que carrega uma enorme espada querendo se vingar.", "desconhecida", 1.90, 90.0, 30);
insert into anime_character(id, anime_id, name, description, favorite_food, height, weight, age) values (2, 2, "Rock Lee", "Um ninja que nasceu sem habilidades para usar ninjutsu ou genjutsu e que busca mostrar seu valor apenas com taijutsu.", "desconhecida", 1.70, 65.0, 18);
insert into anime_character(id, anime_id, name, description, favorite_food, height, weight, age) values (3, 3, "Ikoma", "Jovem inventor que foi mordido por um kabane e com seu desejo de viver, para mostrar seu valor, acabou se transformando em um kabaneri.", "desconhecida", 1.75, 70.0, 20);
insert into anime_character(id, anime_id, name, description, favorite_food, height, weight, age) values (4, 4, "Takato", "Um jovem estudante que ama digimons ao ponto de criar o seu, se tornando assim um domador digimon e se juntando a outros que possuem digimons para defender o mundo real.", "desconhecia", 1.3, 45.0, 10);