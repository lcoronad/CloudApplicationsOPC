insert into FREELANCERS (freelancerId,firsname,lastname,email,skills) values (123456, 'Nombre 1', 'Apellido 1', 'correo@gmail.com', 'Skill1, Skill2, Skill3');
insert into FREELANCERS (freelancerId,firsname,lastname,email,skills) values (123457, 'Nombre 2', 'Apellido 2', 'correo2@gmail.com', 'Skill1');
insert into FREELANCERS (freelancerId,firsname,lastname,email,skills) values (123458, 'Nombre 3', 'Apellido 3', 'correo3@gmail.com', 'Skill1, Skill2');


db.FREELANCERS.insert({"freelancerId":123456,"firsname":"Nombre1","lastname":"Apellido1",
                "email":"correo@gmail.com","skills":"Skill1, Skill2, Skill3"});
db.FREELANCERS.insert({"freelancerId":123457,"firsname":"Nombre2","lastname":"Apellido2",
                "email":"correo2@gmail.com","skills":"Skill1"});
db.FREELANCERS.insert({"freelancerId":123458,"firsname":"Nombre3","lastname":"Apellido3",
                "email":"correo3@gmail.com","skills":"Skill1, Skill2"});
