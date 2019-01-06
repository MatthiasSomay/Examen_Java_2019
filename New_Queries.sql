create table verkeerstoren
(
	ID int auto_increment
		primary key,
	LengteLocatie double null,
	BreedteLocatie double null,
	detailType varchar(45) null
);

create table vervoermiddel
(
	ID int auto_increment
		primary key,
	lengteLocatie double null,
	breedteLocatie double null,
	type varchar(45) null,
	detailType varchar(45) null,
	snelheid double null,
	wendbaarheid double null,
	grootte double null,
	personenAanBoord int null,
	koers double null,
	status varchar(45) null,
	verkeerstoren int null,
	constraint verkeerstoren
		foreign key (verkeerstoren) references verkeerstoren (id)
);

create index verkeerstoren_idx
	on vervoermiddel (verkeerstoren);

