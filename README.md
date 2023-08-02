# Social-Post-Hub

<h2> Tablolar arasindaki iliskileri kisaca aciklamak gerekirse: </h2> 
<br>

1. USER Tablosu:
   - Bir kullanicinin birden cok oy verebilecegi "USER_VOTE" iliskisi vardir. "USER" tablosu ile "USER_VOTE" tablosu arasinda "One-to-Many" (Bir'e Cok) iliskisi bulunmaktadir.
   - Bir kullanicinin birden fazla yorumu "POST_COMMENT" tablosunda olabilir. "USER" tablosu ile "POST_COMMENT" tablosu arasinda da "One-to-Many" iliskisi vardir.

2. USER_VOTE Tablosu:
   - Her oy (UserVote), bir kullaniciya ait olacaktir (USER). "USER_VOTE" tablosu ile "USER" tablosu arasinda "Many-to-One" (Cok'tan Bir) iliskisi bulunmaktadir.
   - Her oy (UserVote), bir yoruma (POST_COMMENT) ait olacaktir. "USER_VOTE" tablosu ile "POST_COMMENT" tablosu arasinda da yine "Many-to-One" iliskisi vardir.

3. POST_COMMENT Tablosu:
   - Bir yorum (PostComment) sadece bir gonderiye (POST) ait olabilir. "POST_COMMENT" tablosu ile "POST" tablosu arasinda "Many-to-One" iliskisi bulunmaktadir.
   - Bir yoruma birden fazla oy (UserVote) verilebilir. "POST_COMMENT" tablosu ile "USER_VOTE" tablosu arasinda "One-to-Many" iliskisi vardir.

4. POST Tablosu:
   - Bir gonderi (Post), birden cok yoruma (PostComment) sahip olabilir. "POST" tablosu ile "POST_COMMENT" tablosu arasinda "One-to-Many" iliskisi bulunmaktadir.
   - Bir gonderi (Post), birden cok etikete (Tag) sahip olabilir. "POST" tablosu ile "TAG" tablosu arasinda "Many-to-Many" iliskisi bulunmaktadir.

5. POST_TAG Tablosu:
   - Her etiket (Tag), birden cok gonderiye (Post) ait olabilir. "POST_TAG" tablosu ile "POST" tablosu arasinda "Many-to-One" iliskisi bulunmaktadir.
   - Her gonderi (Post), birden cok etikete (Tag) sahip olabilir. "POST_TAG" tablosu ile "TAG" tablosu arasinda da yine "Many-to-One" iliskisi vardir.

6. TAG Tablosu:
   - Bir etiket (Tag) birden cok gonderiye (Post) ait olabilir. "TAG" tablosu ile "POST" tablosu arasinda "Many-to-Many" iliskisi bulunmaktadir.
   - Bir gonderi (Post), birden cok etikete (Tag) sahip olabilir. "TAG" tablosu ile "POST_TAG" tablosu arasinda da yine "Many-to-One" iliskisi vardir.
