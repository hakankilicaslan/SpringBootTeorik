SpringBootApplication
Uygulamanızın ana sınıfı yani main metodun olduğu class üzerinde gelir. Bu anotasyon ile uygulamanızın Spring Boot uygulaması olduğunu belirtmiş olursunuz. Bu anotasyon 3 farklı anotasyonun birleşimini temsil eder.

@SpringBootConfiguration: Bulunduğu sınıfın configurasyon sınıfı olduğunu belirtir. Uygulama ile ilgili ayarların olduğu sınıf olarak niteler.
@EnableAutoConfiguration: Otomatik yapılandırmayı etkinleştirir.
@ComponentScan: Package içindeki ve alt packagelardaki tüm sınıfalrı gezerek Bileşenlerin taranmasını yapar.
@Controller
Spring MVC(Model-View-Controller) mimarisinde kullanılan anotasyon. Bu sınıf HTTP isteklerini alır ve sonuç olarak HTML sayfası döner. Temel olarak HTML sayfa server tarafında tamamen oluşturulup clienta gönderilir. Bu anotasyon da @Component'in özelleşmiş versiyonudur.

@RestController
Restful web servis olarak kullanılan yapılarda kullanılır. içerisinde hala @Controller anotasyonu vardır. Ancak geri döneceği yanıt farklıdır. Burada genellikle JSON veya XML formatında veri döndürür.

@RequestMapping
Bir isteğin(request) bir sınıf veya bir metod ile eşleşmesini sağlar. Özelleşmiş versiyonları vardır: @RequestMapping(value = "/save",method = RequestMethod.POST)

Bunun gibi uzun bir yazım yerine @PostMapping @GetMapping @PutMapping @DeleteMapping

ResponseEntity
Json formatında response döndürmek için kullanılır. bir kaç parçadan oluşabilir.

Gönderilecek değer.
header bilgisi gönderebilirsiniz.
HttpStatus bilgisi gönderilebilir.
@GetMapping("/findall")   public ResponseEntity<List> findAll(){
HttpHeaders headers=new HttpHeaders();   headers.add("baslik","deger");
return new ResponseEntity<>(service.findAll(),headers, HttpStatus.OK);  }

@Service
Bir bileşenin service olarak işaretlenmesi için kullanılır. Spring bu anotasyon sayesinde sınıfın service olduğunu anlar. Bu şekilde otomatik olarak Spring yönetimini gerçekleştirir. Bu katmanda iş mantığı ile ilgili kodlar bulunur. Genellikle bu sınıf içinde repository sınıfı Spring DI (Dependency Injection) metodu ile ilişkilendirilir. Bu anotasyon da @Component'in özelleşmiş versiyonudur.

@Component ile bazı temel özellikleri kazanmış olur. Ne gibi mesela; DI

@Component
Bir sınıfı Spring bileşeni yapmak için kullanılır. Spring bu anotasyonla işaretlenmiş sınıfları otomatik tanır ve yönetir. Özelleşmiş 3 türü vardır.

@Controller
@Service
@Repository