# Veteriner Yönetim Sistemi
Bir veteriner kliniğinin kendi işlerini yönetebildiği bir Rest API projesidir.

## Kullanılan Teknolojiler
Java, Spring Boot, PostgreSQL, Swagger, IntelliJ IDE

![VeterinaryUML.PNG](..%2F..%2F..%2F..%2F..%2Fimages%2FVeterinaryUML.PNG)

## Endpointler

 #### Doctor Endpoint

| HTTP Metodu | Endpoint         | Açıklama                                    |
|------------ |------------------|---------------------------------------------|
| GET         | /v1/doctors      | Tüm doktor bilgilerini listeler.            |
| PUT         | /v1/doctors      | Doktor bilgilerini günceller.               |
| POST        | /v1/doctors      | Yeni bir doktor kaydeder.                   |
| GET         | /v1/doctors/{id} | ID'si verilen doktorun bilgilerini getirir. |
| DELETE      | /v1/doctors/{id} | ID'si verilen doktorun bilgilerini siler.   |

#### Customer Endpoint

| HTTP Metodu | Endpoint                   | Açıklama                                         |
|------------ |----------------------------|--------------------------------------------------|
| GET         | /v1/customers              | Tüm hayvan sahibi bilgilerini listeler.          |
| PUT         | /v1/customers              | Hayvan sahibi bilgilerini günceller.             |
| POST        | /v1/customers              | Yeni bir hayvan sahibi kaydeder.                 |
| GET         | /v1/customers/{id}         | ID'si verilen hayvan sahibi bilgilerini getirir. |
| DELETE      | /v1/customers/{id}         | ID'si verilen hayvan sahibi bilgilerini siler.   |
| GET         | /v1/customers/searchByName | İsme göre hayvan sahiplerini getirir.            |

#### Animal Endpoint

| HTTP Metodu | Endpoint                     | Açıklama                                    |
|------------ |------------------------------|---------------------------------------------|
| GET         | /v1/animals                  | Tüm hayvan bilgilerini listeler.            |
| PUT         | /v1/animals                  | Hayvan bilgilerini günceller.               |
| POST        | /v1/animals                  | Yeni bir hayvan kaydeder.                   |
| GET         | /v1/animals/{id}             | ID'si verilen hayvan bilgilerini getirir.   |
| DELETE      | /v1/animals/{id}             | ID'si verilen hayvan bilgilerini siler.     |
| GET         | /v1/animals/searchByName     | İsme göre hayvanları filtreler.             |
| GET         | /v1/animals/searchByCustomer | Hayvan sahiplerine göre hayvanları getirir. |

#### Vaccine Endpoint

| HTTP Metodu | Endpoint                      | Açıklama                                    |
|------------ |-------------------------------|---------------------------------------------|
| GET         | /v1/vaccines                  | Tüm aşı bilgilerini listeler.               |
| PUT         | /v1/vaccines                  | Aşı bilgilerini günceller.                  |
| POST        | /v1/vaccines                  | Yeni bir aşı kaydeder.                      |
| GET         | /v1/vaccines/{id}             | ID'si verilen aşı bilgilerini getirir.      |
| DELETE      | /v1/vaccines/{id}             | ID'si verilen aşı bilgilerini siler.        |
| GET         | /v1/animals/searchByDateRange | Girilen tarih aralığına göre aşı filtreler. |
| GET         | /v1/animals/searchByAnimal    | Belirli bir hayvana ait aşıları getirir.    |

#### Available Date Endpoint

| HTTP Metodu | Endpoint                      | Açıklama                                      |
|------------ |-------------------------------|-----------------------------------------------|
| GET         | /v1/AvailableDates            | Tüm müsait gün bilgilerini listeler.          |
| PUT         | /v1/AvailableDates            | Müsait gün bilgilerini günceller.             |
| POST        | /v1/AvailableDates            | Yeni bir müsait gün kaydeder.                 |
| GET         | /v1/AvailableDates/{id}       | ID'si verilen müsait gün bilgilerini getirir. |
| DELETE      | /v1/AvailableDates/{id}       | ID'si verilen müsait günü siler.              |

#### Appointment Endpoint

| HTTP Metodu | Endpoint                               | Açıklama                                                   |
|------------ |----------------------------------------|------------------------------------------------------------|
| GET         | /v1/appointments                       | Tüm randevu bilgilerini listeler.                          |
| PUT         | /v1/appointments                       | Randevu bilgilerini günceller.                             |
| POST        | /v1/appointments                       | Yeni bir randevu kaydeder.                                 |
| GET         | /v1/appointments/{id}                  | ID'si verilen randevu bilgilerini getirir.                 |
| DELETE      | /v1/appointments/{id}                  | ID'si verilen randevu bilgilerini siler.                   |
| GET         | /v1/appointments/searchByDoctorAndDate | Girilen tarih aralığına ve doktora göre randevu filtreler. |
| GET         | /v1/appointments/searchByAnimalAndDate | Girilen tarih aralığına ve hayvana göre randevu filtreler. |