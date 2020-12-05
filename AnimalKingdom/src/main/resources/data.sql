insert into ZOO (ZOOID ,NAME ) values(1,'Delhi Zoo');
insert into PENS (PEN_ID ,PENNAME,PENTYPE ,ZOOID  ) values(1,'Pen1','Bird',1);
insert into PENS (PEN_ID ,PENNAME,PENTYPE ,ZOOID  ) values(2,'Pen2','Mammal',1);
insert into PENS (PEN_ID ,PENNAME,PENTYPE ,ZOOID  ) values(3,'Pen3','Reptile',1);


--insert into ANIMAL (ANIMALTYPE , ID ,NAME ,PEN_ID ,CRAWL ,FLY ,SUCKLE )
--values('Bird', 1, 'Parrot1', 1,null, 'Fly like a Parrot', null);
--insert into ANIMAL (ANIMALTYPE , ID ,NAME ,PEN_ID ,CRAWL ,FLY ,SUCKLE )
--values('Lion', 2, 'Lion1', 2,null, null,'SUCKLE like a Lion');
--insert into ANIMAL (ANIMALTYPE , ID ,NAME ,PEN_ID ,CRAWL ,FLY ,SUCKLE )
--values('Snake', 3, 'Snake1', 3,'CRAWL like a Snake',null, null);

--insert into PARROT (ID , NAME ,PEN_ID,FLY  )
--values(1, 'Parrot1',1,'Fly like a Parrot');
--insert into CHEETAH  (ID , NAME ,PEN_ID,SUCKLE)
--values(2, 'cheetah1',2,'Scule of CHEETAH');
--insert into SNAKE (ID , NAME ,PEN_ID,CRAWL )
--values(3, 'Snake1',3,'Crawl like a Snake');

--insert into ANIMAL (ANIMALTYPE , ID ,NAME ,PENNAME,PENTYPE  ,SPECIES,FLY ,SUCKLE ,CRAWL  )
--values('Bird', '10001', 'Parrot1', 'Pen1', 'Bird', 'Bird', 'Fly like a Parrot', '','');
--insert into ANIMAL (ANIMALTYPE , ID ,NAME ,PENNAME,PENTYPE  ,SPECIES,FLY ,SUCKLE ,CRAWL  )
--values('Mouse', '10002', 'Mouse1', 'Pen2', 'Mammal', 'Mammal', '', 'Scule of Mouse','');
--insert into ANIMAL (ANIMALTYPE , ID ,NAME ,PENNAME,PENTYPE  ,SPECIES,FLY ,SUCKLE ,CRAWL  )
--values('Snake', '10003', 'Snak1', 'Pen3', 'Reptile', 'Reptile', '', '','Crawl like a Snake');
