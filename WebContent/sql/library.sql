USE library;

DROP TABLE IF EXISTS author_book;

DROP TABLE IF EXISTS author;

CREATE TABLE author(
	id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255), 
    about_author TEXT
);
DROP TABLE IF EXISTS books;

CREATE TABLE books(
	id INT AUTO_INCREMENT PRIMARY KEY,
    book_name VARCHAR(255),
    book_url TEXT,
    about_book TEXT    
);



CREATE TABLE author_book(
	id INT AUTO_INCREMENT PRIMARY KEY,
    author_id INT,
    book_id INT,
	FOREIGN KEY(author_id) REFERENCES author(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(book_id) REFERENCES books(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO author VALUES(1, 'Meša', 'Selimović', 'Meša Selimović je poznati pripovjedač, romansijer i esejist. Rođen je 1910. godine u Tuzli gdje je počeo školovanje, pa je tako završio osnovnu i srednju školu. 1930. godine upisao se na Filozofski fakultet u Beogradu gdje je nastavio školovanje, a nakon što je diplomirao radio je u gimnaziji u Tuzli.
Tijekom svog života aktivirao se na različitim područjima, pa se tako za vrijeme Drugog svjetskog rata pridružio partizanima, a nakon rata je objavio nekoliko društvenih i političkih dužnosti.
S književnošću se počeo baviti tijekom rata i to s nekoliko članaka, reportaža i crtica objavljujući svoja djela u raznim brojevima "Oslobođenja i Fronta slobode". Nakon rata se okrenuo kraćim epskim formama, pripovijetkama i novelama u kojima se najviše spominjala ratna tematika.
Uslijedili su njegovi najpoznatiji romani: "Tišine", "Derviš i smrt", "Ostrvo" i "Tvrđava". Roman "Krug" je objavljen posthumno. Pored romana objavio je zbirku pripovijedaka: "Eseje i oglede", "Magla i mjesečina", "Tuđa zemlja", "Djevojka crvene kose", "Za i protiv vuka".
Umro je u Beogradu 11. srpnja 1982. godine.');

INSERT INTO author VALUES(2, 'Nura', 'Bazdulj Hubijar', 'Nura Bazdulj-Hubijar rođena je 1951. godine u Mrdenovićima kod Foče. Od 1954.
godine živi u Sarajevu gdje završava osnovnu i srednju školu, Medicinski fakultet i
43
specijalizaciju. Živi u Travniku i radi kao ljekar specijalista – mikrobiolog.
Do sad je objavila zbirku pjesama za djecu "Ja, slavni ja" (Drugari, Sarajevo, 1988.).
Nedjeljnik UNA objavio je u nastavcima skraćene verzije romana "Sensibile con
dolore"(1990) i Srna (1991).
U godinama rata, uz naporan rad ljekara, nastavlja sa pisanjem, pa 1994. "Svjetlost"
objavljuje roman "Ljubav je sihirbaz, babo", a "Bosanska knjiga", također roman,"Naše
međutim je rat". Međunarodni centar za mir, Sarajevo, 1996. objavljuje kratki roman "Rosa
Canina".
Roman "Ljubav je sihirbaz, babo" preveden je na norveški jezik, dok je više tekstova
uvršteno u školske čitanke a roman "Ruža" u lektiru.');

INSERT INTO books VALUES(1, 'Tišine','http://www4.zippyshare.com/v/60283558/file.html','Prvi roman Meše Selimovića „Tišine” objavljen je 1961. godine i opisuje začuđenost melanholika i tragača za istinom. Skladne kompozicije, meditativnih detalja, kao malih sugestivnih celina, znalački ukomponovanih sa dijaloškim partijama, ovaj roman proširuje metaforu tišine sve do granica tragike ljudske egzistencije. ');
INSERT INTO author_book(author_id, book_id) VALUES (1, 1);

INSERT INTO books VALUES(7, 'Djevojka crvene kose','https://www96.zippyshare.com/v/ATYKdWu6/file.html','Napisana u najboljoj tradiciji pripovedačkog realizma, prva knjiga Meše Selimovića, zbirka priča: Djevojka crvene kose jasno oslikava pisca koji se već u ranim pripovetkama upušta u osnovne poetičke, tematske ali i opsesivne smernice svoje proze; večne teme dobra, zla i ljudske slobode...');
INSERT INTO author_book(author_id, book_id) VALUES (1, 7);

INSERT INTO books VALUES(2, 'Amanet', 'https://www.datoteke.online/index.php/s/acNurZLz6jZWYBK','Svaki čovjek je misterija. Možemo biti uvjereni kako nekoga znamo u dušu, a zapravo znamo samo onoliko koliko je on dopustio da znamo. Nema li svako neki svoj unutrašnji svijet u koji se povlači da bi se napojio novom snagom, oživio davnu čežnju, raspirio zapretanu strast, vratio nadu da osim kaskanja u svakodnevici postoji još nešto. Jer svakodnevica, makar bila mirna kao mirna površina vode, sjajna kao zlatno žitno polje, svijetla kao sunčan dan, može postati zamorna. Je li taj svijet tati bila Zinaida?');
INSERT INTO author_book(author_id, book_id) VALUES (2, 2);

INSERT INTO books VALUES(20, 'Spavaj Anđela', 'https://www.datoteke.online/index.php/s/49l24QzisjDmQg4','U vječnoj bici uma i srca uvijek prednost dajemo samo jednom. Jedna mlada žena nađe se u takvom konfliktu, donese odluku i dospije u strašno iskušenje. Ne samo što je s tim suočena, već je i jedan nemili događaj dovodi do ruba emotivnog sloma. A onda joj pod ruku dolazi pismo, koje će presudno uticati na njen daljni život. Da li ja bol koju je ta mlada žene doživjela upravo ono iskustvo kroz koje je nužno morala proći da bi se spoznala istinu?');
INSERT INTO author_book(author_id, book_id) VALUES (2, 20);
