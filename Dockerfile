#Başlamadan önce sağdaki Gradle kısmından Tasks->build içerisinden önce clean diyerek temizliyoruz sonra build ve buildDependents diyerek tekrar projeyi build ediyoruz.
#İlk olarak denemek için build ve yml içinde postgre ile ilgili şeyleri yoruma alıp onların yerine h2database ekliyoruz.

#Daha sonra kullanılacak JDK sürümünü belirtmek gerekiyor. Amazoncoretto'nun 19 sürümünü kullanacağımızı belirtiyoruz.
FROM amazoncorretto:19

#Jar dosyasını Docker'a kopyalamak gerekiyor. Bunun için iki yol var.
#1.Yol: Direkt olarak dosya adını vererek alıyoruz.
#Bunun için build->libs içinden .jar dosyasını bulup sağ tıklayıp Copy Path/Reference seçip Path From Content Root diyerek yolu kopyalıyoruz.
#Kopyaladığımız yolu COPY yazdıktan sonra yapıştırıyoruz ve sonuna docker da tutulacağı ismi yani app.jar ekliyoruz.
#***********************************************
#COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar
#***********************************************

#2.Yol: Argümandan dosya adını alıyoruz.
#Burada argüman kullanarak yapıyoruz ilk önce target yani hedefteki dosyanın altında .jar uzantısı ile biten dosyayı alıp JAR_FILE içine atmış oluyoruz.
#COPY diyip dosyanın değişkenini ${JAR_FILE} yazıyoruz ve sonuna app.jar eklemiş olduk.
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

#Docker'a kopyaladığımız Jar dosyasını çalıştırma
#Dosyayı çalıştımak için gerekli komutları EntryPoint olarak ekliyoruz.
ENTRYPOINT ["java","-jar","/app.jar"]

#Argüman kullanılarak oluşturulan dockerfile dosyasının çalıştırılması:
#Bütün komutlarda olduğu gibi docker yazarak başlıyoruz sonra build --build-arg yazıyoruz.
#JAR_FILE kısmına üstte yaptığımız gibi dosyanın yolunu yapıştırıyoruz sonra boşluk -t ekliyoruz.
#Komutun başına özellikle docker build yazıyoruz bu şekilde içinde bulunduğu proje de Dockerfile dosyasını arayıp buluyor.
#Dockerfile dosyası yanlış isimlendirilirse dosyayı bulamaz ve yazdığımız komutlar çalışmaz.
#Hesabımız varsa kullanıcı adımızı ekliyoruz sonra docker da hangi isimle tutulmasını istiyorsak image ismi veriyoruz.
#İki nokta koyup image için versiyon giriyoruz ve boşluk bırakıp nokta koyuyoruz.
#Yazdığımız bu komutu aşağıda terminal açıp yapıştırıp enter dediğimizde Docker Desktop içine image olarak ekleniyor.

#1.Yol: DockerHub hesabı yoksa(Bu kullanımda DockerHub hesabına imageları yükleyemeyiz)
#************************************************************************************
#docker build --build-arg JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar -t java12:001 .
#************************************************************************************

#2.Yol: DockerHub hesabı varsa
#****************************************************************************************************
#docker build --build-arg JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar -t hakankilicaslan/java12:001 .
#****************************************************************************************************

#docker images                -> Terminale bu komutu girince Docker içindeki imagesları liste olarak gösteriyor.
#docker ps                    -> Çalışan bir container varsa onları listeliyor.
#docker ps --all              -> Çalışan çalışmayan bütün container'ları listeliyor.
#docker network ls            -> Networkleri listeliyor.
#docker network rm networkAdı -> Adını girdiğimiz networkü siliyor.
#Docker Desktop üzerinden image'ların sonundaki üç noktadan push to hub diyerek image'ları DockerHub içine yükleyebiliriz.
#docker push hakankilicaslan/java12:tagname diyerek terminal üzerinden de hangi versiyonu(tagname) girdiysek onu DockerHub içine yükleyebiliriz.

#Docker içine image oluşturduktan sonra çalıştırmak için yani container oluşturmak için:
#Yine docker ile başlayıp run boşluk -p yazıyoruz sonra hostport:containerport yazıyoruz.
#Daha sonra build kısmında olduğu gibi kullanıcı adı, image ismi ve versiyonu yazıp enter'a basıyoruz.
#Swagger ya da postmanden 9095ten gelen istekleri 9090 portu karşılayacak demiş oluyoruz.
#9095 hostport dışardan istek gelen port 9090 containerport bizim yml dosyamızda belirlediğimiz port numarası oluyor.

#**************************************************
#docker run -p 9095:9090 hakankilicaslan/java12:001 (run ile -p arasına -d eklersek terminalde değil Docker Desktop içinde çalıştırıyor)
#**************************************************

#Run ettikten sonra terminalde tekrar komut yazmak için durdurmamız gerekiyor ya da container'ı terminal üzerinden durdurmak içim Ctrl+C yazıp enter'a basıyoruz.
#Başka birisi bilgisayarında DockerDesktop varsa DockerHub içine yüklediğimiz image'ı çekerek istek atabilir.
#docker pull hakankilicaslan/java12:tagname diyerek terminal üzerinden de hangi versiyonu(tagname) girdiyse onu Docker Desktop içine çekebilir.
#Docker Desktop içine çektikten sonra run ederek belirlediği hostport ile swagger'dan sorgu atabiliyor.

#docker run -p 9095:9090 hakankilicaslan/java12:001 diyerek direkt image'ı almadan kullanıcı run ettiğinde sistem lokalde yani Docker Desktop içinde arıyor.
#Image daha önce indirilmediği için bulamıyor ve DockerHub'ta hakankilicaslan isimli kullanıcının hesabına gidiyor ve image'ı orada aratıyor.
#Hesapta bu isimde image ve o versiyonu varsa bulup indiriyor ve çalıştırıyor. Artık 9095 portu üzerinden istek atabiliyor.
#Bu şedilde image'ı bilgisayarına çekmemişse bile run komutuyla çekip çalıştırabiliyor.











