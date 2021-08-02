create sequence hibernate_sequence start 1 increment 1

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date date,
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date date,
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        receivedservice int4,
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        receivedservice int4,
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        receivedservice int4,
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        receivedservice int4,
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        receivedservice int4,
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        serviceType varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        picture varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        picture varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        picture varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        picture varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        picture varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        price int4,
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table card_details (
       id int8 not null,
        card_number varchar(255),
        card_owner varchar(255),
        expiration_month varchar(255),
        expiration_year varchar(255),
        customer_id int8,
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        picture varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists card_details 
       add constraint FK96j0ltqg58luswf0ykdf6kobr 
       foreign key (customer_id) 
       references customer

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        price int4,
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table card_details (
       id int8 not null,
        card_number varchar(255),
        card_owner varchar(255),
        expiration_month varchar(255),
        expiration_year varchar(255),
        customer_id int8,
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        picture varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists card_details 
       add constraint FK96j0ltqg58luswf0ykdf6kobr 
       foreign key (customer_id) 
       references customer

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        price int4,
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table card_details (
       id int8 not null,
        card_number varchar(255),
        card_owner varchar(255),
        expiration_month varchar(255),
        expiration_year varchar(255),
        customer_id int8,
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phonenumber varchar(255),
        picture varchar(255),
        street varchar(255),
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists card_details 
       add constraint FK96j0ltqg58luswf0ykdf6kobr 
       foreign key (customer_id) 
       references customer

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
create sequence hibernate_sequence start 1 increment 1

    create table appointment (
       id int8 not null,
        date varchar(255),
        price int4,
        requiredservice varchar(255),
        time varchar(255),
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table car (
       id int8 not null,
        brand_name varchar(255),
        fuel varchar(255),
        repairedstatus varchar(255),
        requiredservice varchar(255),
        primary key (id)
    )

    create table card_details (
       id int8 not null,
        card_number varchar(255),
        card_owner varchar(255),
        expiration_month varchar(255),
        expiration_year varchar(255),
        primary key (id)
    )

    create table customer (
       id int8 not null,
        city varchar(255),
        email varchar(255),
        name varchar(255),
        phoneNumber varchar(255),
        picture varchar(255),
        street varchar(255),
        cardDetails_id int8,
        ownedcar_id int8,
        user_id int8,
        primary key (id)
    )

    create table mechanic (
       id int8 not null,
        name varchar(255),
        picture varchar(255),
        specialization varchar(255),
        primary key (id)
    )

    create table carService (
       id int8 not null,
        date timestamp,
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table testimonial (
       id int8 not null,
        comment varchar(255),
        rating varchar(255),
        servicetype varchar(255),
        car_id int8,
        customer_id int8,
        mechanic_id int8,
        primary key (id)
    )

    create table user_credentials (
       id int8 not null,
        password varchar(255),
        username varchar(255),
        primary key (id)
    )

    alter table if exists appointment 
       add constraint FKmyowslj1th8d9j6j3wlbwrtoe 
       foreign key (customer_id) 
       references customer

    alter table if exists appointment 
       add constraint FKnc61twmcjp2rkmflchkq0hlvy 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists customer 
       add constraint FKjklvl5lbj9u5xjp0kk1x3q85d 
       foreign key (cardDetails_id) 
       references card_details

    alter table if exists customer 
       add constraint FKmfjfudsedybibx28cmjhxtb4 
       foreign key (ownedcar_id) 
       references car

    alter table if exists customer 
       add constraint FK78pio25qdho8j6h0eqvy1fli2 
       foreign key (user_id) 
       references user_credentials

    alter table if exists carService
       add constraint FKnrrevpm4otovp3e6jvpmao4e1 
       foreign key (car_id) 
       references car

    alter table if exists carService
       add constraint FKtyjijsa87ahcfvy495nhugo1 
       foreign key (customer_id) 
       references customer

    alter table if exists carService
       add constraint FK8x8qehjum64psba3xtty9akt1 
       foreign key (mechanic_id) 
       references mechanic

    alter table if exists testimonial 
       add constraint FKkfcbbasgga0sp5olk2e8sxf63 
       foreign key (car_id) 
       references car

    alter table if exists testimonial 
       add constraint FKdcstei5dt6qwdh5d8x0nardpe 
       foreign key (customer_id) 
       references customer

    alter table if exists testimonial 
       add constraint FK3jqpx012hybud43221rxroqrl 
       foreign key (mechanic_id) 
       references mechanic
