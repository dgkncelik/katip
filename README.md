# Katip

Katip [Spring](http://spring.io) ile gelistirilmis; kutuphaneler ve yayinevlerinin kullanimina sunulmus bir uygulamadir. Kitap goruntuleme, ekleme, silme, kitaplari yazarlar ve yayinevleri ile iliskilendirme ve bu islemleri yapan kullanicilari eylemler uzerinde yetkilendirme barindirdigi ozellikleridir.

## Bagimliliklar

Uygulamayi yuklemek ve calistirma gereksinimleri

* MySQL veri tabani baglantisi (>MySQL 5)
* Open JRE 8 
* Open JDK 8
* Maven Depency Manager

## Yapilandirma

* Uygulamanin ihtiyac duyacagi veritabani baglantisi icin src/main/resources/ altinda bulunan application.properties dosyasinin iceri duzenlenmelidir.

	> spring.datasource.url=jdbc:mysql://[VERI TABANI SUNUCUSU DOMAIN ADI veya IP ADRESI]/[VERI TABANI ADI]
	> spring.datasource.username=[VERI TABANI KULLANICI ADI]
	> spring.datasource.password=[VERI TABANI PAROLASI]

## Derleme

* Kaynak kodu elde etmek icin git reposu yerele kopyalanir.
	> git clone https://github.com/dgkncelik/katip.git
	> cd katip/
	> mvn clean install

## Calistirma

* Derlenmis jar dosyasi calistirilir

	> java -jar [DOSYA YOLU]
	> java -jar .m2/repository/com/dogukancelik/katip/0.0.1-SNAPSHOT/katip-0.0.1-SNAPSHOT.jar

## Erisim 

* Uygulama arayuzune http://localhost:8080/kitap-list ile erisilebilinir.

* Giris(Yonetici Hesabi)
	> Kullanici Adi: admin
	> Parola: password

* Giris(Standart kullanici(
	> Kullanici Adi: user1
	> Parola: 1234

