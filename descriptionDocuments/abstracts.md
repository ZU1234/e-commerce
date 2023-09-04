# Abstracts Paket İçeriği

<p>&emsp; (Abstract) sınıflar, nesneler türetilirken şablon oluşturmak için kullanılır. Bu soyut sınıflar, kategorilere ayrılarak soyut paketler içinde tutulur.</p>

<h2>Paketler</h2>
<ul>
  <li>interceptors</li>
  <li>models</li>
</ul>

<h2>Interceptors</h2>
<p>Interceptorlar, modellerin yaşam döngüsü davranışının belirli kısıtlamaları karşılayıp karşılamadığını kontrol eder. Doğru verilerin silindiğinden veya saklandığından, verilerin doğru şekilde kullanıldığından emin olmak için interceptorlar kullanılır. Modellerin yaşam döngüsünün davranışını etkilemek için çeşitli türde interceptorlar geliştirilmiştir. Her bir interceptor, yaşam döngüsünün belirli bir aşamasını ele alır. Bir model belirli bir adıma ulaştığında, ilgili interceptor etkinleştirilir. İnterception sırasında model değiştirilebilir veya adım kesilebilir bir istisna oluşturulabilir. Örneğin, bir modelin kaydedilmeden önce belirli değerlere sahip olup olmadığı kontrol edilebilir. Bir interceptor uygulandıktan sonra, onu bir Spring bean olarak kaydetmek gerekmektedir.</p>

<h3>Interceptor Türleri</h3>
<ul>
  <li><strong>Load Interceptor:</strong> Load Interceptor, bir model veritabanından yüklendiğinde çağrılır. Model yüklendikten sonra değerlerini değiştirmek isterseniz bu interceptorı kullanabilirsiniz. Yürütme sırasında ortaya çıkan bir istisna, modelin yüklenmesini engeller.</li>
  <li><strong>Init Defaults Interceptor:</strong> Init Defaults Interceptor, bir modelin varsayılan değerlerini ayarlamak için kullanılır.</li>
  <li><strong>Prepare Interceptor:</strong> Prepare Interceptor, bir modelin hazırlık aşamasında özel işlemler yapmak için kullanılır.</li>
  <li><strong>Validate Interceptor:</strong> Validate Interceptor, bir modelin geçerlilik kontrolünü yapmak için kullanılır.</li>
  <li><strong>Remove Interceptor:</strong> Remove Interceptor, bir model veritabanından kaldırılmadan önce çağrılır. Bu interceptoru örneğin bir modelle ilişkili ancak model bağlamında olmayan modelleri kaldırmak veya modelin kaldırılmasını bir InterceptorException oluşturarak engellemek için kullanabilirsiniz.</li>
</ul>

<h2>Models</h2>
<p>Models paketi, tablolariçin soyut sınıfların bulunduğu bir pakettir. Modelin temel özelliklerini içerir.</p>

<h3>BaseModel class</h3>
<p>BaseModel sınıfı, şu özelliklere sahiptir:</p>
<ul>
  <li><code>id</code> adında bir Long tipinde bir özellik içerir.</li>
  <li><code>name</code> adında bir String tipinde bir özellik içerir.</li>
</ul>
<p>BaseModel sınıfı diğer modeller tarafından extend edilebilir ve ortak özellikleri bu sınıf üzerinden paylaşabilir.</p>



<h2>Kullanılan Anatasyonlar</h2>
<li><code>@MappedSuperclass</code> bir sınıfın bir varlık sınıfı (entity class) olmadığını, ancak alt sınıflar tarafından miras alınarak kullanılması gerektiğini belirtmek için kullanılır.</li>
<li><code>@Id</code>  Bir sınıfın birincil anahtarını belirtmek için kullanılır.</li>
<li><code>@GeneratedValue(strategy = GenerationType.IDENTITY)</code> anotasyonu, birincil anahtar değerinin otomatik olarak oluşturulmasını sağlar. </li>


