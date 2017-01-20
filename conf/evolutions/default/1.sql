# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table company (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table employee (
  id                        integer not null,
  name                      varchar(255),
  age                       integer,
  company_id                integer,
  constraint pk_employee primary key (id))
;

create sequence company_seq;

create sequence employee_seq;

alter table employee add constraint fk_employee_company_1 foreign key (company_id) references company (id);
create index ix_employee_company_1 on employee (company_id);



# --- !Downs

drop table if exists company cascade;

drop table if exists employee cascade;

drop sequence if exists company_seq;

drop sequence if exists employee_seq;

