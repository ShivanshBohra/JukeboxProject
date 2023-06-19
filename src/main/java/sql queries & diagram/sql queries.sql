drop database jukebox;
create database jukebox;
use jukebox;
CREATE TABLE user (
    user_name VARCHAR(200) PRIMARY KEY,
    password VARCHAR(200),
    mobile_no VARCHAR(200)
);
CREATE TABLE playlist (
    platlist_id INT PRIMARY KEY,
    playlist_name VARCHAR(200),
    user_id VARCHAR(200),
    FOREIGN KEY (user_id)
        REFERENCES user (user_name)
        ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE songs (
    song_name VARCHAR(200),
    song_id INT PRIMARY KEY,
    song_duration VARCHAR(200),
    artist_name VARCHAR(200),
    genre VARCHAR(200),
    song_file_path VARCHAR(200),
    p_id INT,
    FOREIGN KEY (p_id)
        REFERENCES playlist (platlist_id)
);


CREATE TABLE podcast (
    podcast_name VARCHAR(200),
    podcast_id INT PRIMARY KEY,
    podcast_duration VARCHAR(200),
    podcast_episode VARCHAR(200),
    podcast_lang VARCHAR(200),
    podcast_file_path VARCHAR(200),
    p_id INT,
    FOREIGN KEY (p_id)
        REFERENCES playlist (platlist_id)
);
insert into user values("aman","aman@123","9549345233");
insert into user values("amit","amit@1998","9983733523");
insert into playlist values(100,"gaming","aman");
insert into playlist values(11,"bollywood","amit");
insert into playlist values(12,"bollywood","aman");
insert into playlist values(13,"hollywood","amit");
insert into playlist values(14,"hollywood","amit");
insert into songs values("bay",1,"2.30","Squadda B","pop","C:\\Users\\Asus\\IdeaProjects\\capstone-project-jukebox\\src\\main\\resources\\bay street billionaires.wav",11);
insert into songs values("blank",2,"2.30","Squadda B","base","C:\\Users\\Asus\\IdeaProjects\\capstone-project-jukebox\\src\\main\\resources\\blank slate.wav",12);
insert into songs values("cruise",3,"2.30","Squadda B","base","C:\\Users\\Asus\\IdeaProjects\\capstone-project-jukebox\\src\\main\\resources\\cruise.wav",13);
insert into podcast values("know myself","1","2:30","ep-1","English","C:\\Users\\Asus\\IdeaProjects\\capstone-project-jukebox\\src\\main\\resources\\know myself.wav",11);
insert into podcast values("new day","2","1:30","ep-2","English","C:\\Users\\Asus\\IdeaProjects\\capstone-project-jukebox\\src\\main\\resources\\new day.wav",12);
insert into podcast values("space age","3","2:40","ep-3","English","C:\\Users\\Asus\\IdeaProjects\\capstone-project-jukebox\\src\\main\\resources\\space age hussle.wav",13);

