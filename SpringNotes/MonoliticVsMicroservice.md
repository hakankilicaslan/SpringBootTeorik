# Monolitik nedir?

* Tüm bileşenlerin bir arada olduğu, büyük ve tek bir yapı gibi geliştirildiği proje tipidir.
* Bütün proje tek bir dil ile geliştirilmek zorunda.
* Birlikte çalışmak daha zor.
* Genellikle bir tane veritabanı sunucusu olur ve uygulama direkt ona bağlı çalışır.
* Scalebility ( Ölçeklendirme ) kolay değil.

* Dağıtım ve geliştirme süreci çok daha basittir.

# Microservice nedir?

* Uygulama daha küçük ve birbirinden bağımsız parçalara ayrıldığı proje tipidir.
* Her bir microservis farklı bir dil ile geliştirilebilir.
* Ekip çalışmasına daha uygun. ekipleri ayırmak daha kolay.
* Her yapı farklı veritabanı kullanabilir.
* Ölçeklendirme daha kolaydır.
* İçinde ekstra bir çok yeni teknoloji barındırır.

* Dağıtım ve geliştirme süreci çok daha karmaşıktır.

# Sanallaştırma nedir?
* Bir bilgisayar üzerinde başka bilgisayarlar kurmamıza yardımcı olan sistemlerdir.
* Host Makine: Sanallaştırma yapılacak olan bilgisayar demektir.
* VM: Virtual Machine: Fiziksel makinenin donanım kaynaklarını kullanan sanal bir bilgisayardır.
* Hypervisor: Sanal makineleri yönetmek için gerekli olan yazılımdır. Vmware, Hyper-v, VirtualBox
* 
* Sanallaştırma aktifleştirme: 
* Cpu virtualization özelliğine sahip olmalı.
* BIOS vt-x, vt-d, amd-v, rvi bu özellik enable edilmeli. 

# Containerization nedir?
* Sanallaştırma teknolojisidir.
* Containerlar birbirinden izole bir şekilde çalışır.
* Containerların taşınması çok kolaydır. Bulut ortamına bile kolayca taşınabilir.
* Çok daha az kaynak tüketirler.
* Çok daha hızlı başlatılırlar.
* Ölçeklendirmesi çok kolaydır.

# Docker nedir?
* 2013 yılında geliştirilmiştir. Go diliyle yazılmış.
* Paketlemede, hem dağıtımda hem de çalıştırma imkanı sağlayan bir platformdur.
* İçinde dahili olarak yüzlerce imaj barındırır.
* Mikroservis mimarisinin gelişmesiyle beraber popülerliği arttı.
* Docker içinde dahili olarak küçük boyutta bir linux çekirdeği barındırır. (KERNEL)

## Bir uygulamanın DEPLOY edilme aşamaları(JAR OLUŞTURMA)
* gradle paneli ile clean işlemi yap.
* gradle paneli ile build al.
* gradle paneli ile buildDependents al.
* Bu adım sonunca build>libs klasörü içinde jar dosyası oluşacaktır.
* Çift tıklayarak bu jar dosyası çalıştırılabilir.*

Komut satırından jar dosyası nasıl çalıştırılır?  
-> java -jar dosyaadı(demo-0.0.1-SNAPSHOT.jar) 

Nasıl durdurulur? 

# Dockerfile
# ilk olarak kullanılacak JDK sürümünü belirtmek gerekli.  
FROM amazoncorretto:19  
# Jar dosyasını Docker'a kopyalama:  
# 1. YOL direkt olarak dosya adını verdik:  
# COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar  
# 2. YOL argümandan dosya adını alacağız:  
ARG JAR_FILE=target/*.jar  
COPY ${JAR_FILE} app.jar  
# Docker'a kopyaladığımız Jar dosyasını çalıştırma  
ENTRYPOINT ["java","-jar","/app.jar"]  
  
#Argüman kullanılarak oluşturulan dockerfile dosyasının çalıştırılması için:  
# 1. Yol: DockerHub hesabı olmadan  
# docker build --build-arg JAR_FILE=jardosyasınınyolu -t java12:001 .  
  
# 2. Yol: DockerHub hesabıyla  
# docker build --build-arg JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar -t barisde/java12:001 .


# Docker Engine:
Arka planda konteynarları oluşturma, yönetimini sağlama ve çalıştırma gibi temel işlevleri yerine getiren yapıdır.

# Docker CLI
Komutlarınız CLI aracılıı ile dockera iletilir.

# Docker Image
Bir uygulamanın çalışması için gerekli tüm dosyalar, bağımlılıklar, yapılandırma ayarlarını içeren yapıdır.
Image dosyaları sabit diskte yer kaplar.

# Docker Container
Docker image'ın çalışır halidir.
Çalışma halinde gerçekleştirilen değişiklik korunmaz.
Kapanınca kaybolacaktır.
Değişiklikleri depolamak için volume'den yararlanabilirsin. (Veritabanı olanlar için)
Docker container çalışırken ram ve cpu harcar.


