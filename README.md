# Social-Post-Hub

<h2> Tablolar arasindaki iliskileri kisaca aciklamak gerekirse: </h2> 
<br>

1. USER Tablosu:
   - Bir kullanicinin birden cok oy verebilecegi "USER_VOTE" iliskisi vardir. "USER" tablosu ile "USER_VOTE" tablosu arasinda "One-to-Many" (Bir'e Cok) iliskisi bulunmaktadir. Bir kullanicinin bircok oyu olabilir, ancak bir oy yalnizca bir kullaniciya aittir.
   - Bir kullanicinin birden fazla yorumu "POST_COMMENT" tablosunda olabilir. "USER" tablosu ile "POST_COMMENT" tablosu arasinda "One-to-Many" iliskisi vardir. Bir kullanicinin bircok yorumu olabilir, ancak bir yorum yalnizca bir kullaniciya aittir.

2. USER_VOTE Tablosu:
   - Bir oy (UserVote), bir kullaniciya ait olacaktir (USER). "USER_VOTE" tablosu ile "USER" tablosu arasinda "Many-to-One" (Cok'tan Bir) iliskisi bulunmaktadir. Bir oy bir kullaniciya ait olabilir, ancak bir kullanicinin birden cok oyu olabilir.
   - Bir oy (UserVote), bir yoruma (POST_COMMENT) ait olacaktir. "USER_VOTE" tablosu ile "POST_COMMENT" tablosu arasinda "Many-to-One" iliskisi vardir. Bir oy bir yoruma ait olabilir, ancak bir yorumun birden cok oyu olabilir.

3. POST_COMMENT Tablosu:
   - Bir yorum (PostComment) sadece bir gonderiye (POST) ait olabilir. "POST_COMMENT" tablosu ile "POST" tablosu arasinda "Many-to-One" (Cok'tan Bir) iliskisi bulunmaktadir. Bir yorum bir gonderiye ait olabilir, ancak bir gonderinin birden cok yorumu olabilir.
   - Bir yoruma birden fazla oy (UserVote) verilebilir. "POST_COMMENT" tablosu ile "USER_VOTE" tablosu arasinda "One-to-Many" iliskisi vardir. Bir yoruma birden cok oy verilebilir, ancak bir oy yalnizca bir yoruma ait olabilir.

4. POST Tablosu:
   - Bir gonderi (Post), birden cok yoruma (PostComment) sahip olabilir. "POST" tablosu ile "POST_COMMENT" tablosu arasinda "One-to-Many" (Bir'e Cok) iliskisi bulunmaktadir. Bir gonderi birden cok yoruma sahip olabilir, ancak bir yorum yalnizca bir gonderiye ait olabilir.
   - Bir gonderi (Post), birden cok etikete (POST_TAG) sahip olabilir. "POST" tablosu ile "POST_TAG" tablosu arasinda "One-to-Many" iliskisi bulunmaktadir. Bir gonderi birden cok etikete sahip olabilir, ancak bir etiket yalnizca bir gonderiye ait olabilir.

5. POST_TAG Tablosu:
   - Bir gonderi (Post), birden cok etikete (TAG) sahip olabilir. "POST_TAG" tablosu ile "TAG" tablosu arasinda "Many-to-One" (Cok'tan Bir) iliskisi bulunmaktadir. Bir gonderi birden cok etikete sahip olabilir, ancak bir etiket yalnizca bir gonderiye ait olabilir.
   - Her etiket (Tag), birden cok gonderiye (Post) ait olabilir. "POST_TAG" tablosu ile "POST" tablosu arasinda "Many-to-One" iliskisi bulunmaktadir.

6. TAG Tablosu:
   - Bir etiket (Tag), birden cok gonderiye (Post) ait olabilir. "TAG" tablosu ile "POST_TAG" tablosu arasinda "One-to-Many" (Bir'e Cok) iliskisi bulunmaktadir. Bir etiket birden cok gonderiye ait olabilir, ancak bir gonderinin birden cok etiketi olabilir.

<details>
  <summary>Ornek Data</summary>

```markdown

### USER Table:
| ID | firstName | lastName |
|----|-----------|----------|
| 1  | John      | Doe      |
| 2  | Jane      | Smith    |
| 3  | Michael   | Johnson  |
|... | ...       | ...      |

### USER_VOTE Table:
| ID | USER_ID | POST_COMMENT_ID | voteType |
|----|---------|-----------------|----------|
| 1  | 1       | 1               | Upvote   |
| 2  | 1       | 2               | Downvote |
| 3  | 2       | 1               | Upvote   |
|... | ...     | ...             | ...      |

### POST_COMMENT Table:
| ID | review     | POST_ID |
|----|------------|---------|
| 1  | Great post | 1       |
| 2  | Thanks!    | 2       |
| 3  | Awesome    | 1       |
|... | ...        | ...     |

### POST Table:
| ID | title  |
|----|--------|
| 1  | Post 1 |
| 2  | Post 2 |
| 3  | Post 3 |
|... | ...    |

### POST_TAG Table:
| POST_ID | TAG_ID |
|---------|--------|
| 1       | 1      |
| 1       | 2      |
| 2       | 3      |
| 3       | 1      |
|...      | ...    |

### TAG Table:
| ID | name      |
|----|-----------|
| 1  | Java      |
| 2  | Spring    |
| 3  | Hibernate |
|... | ...       |
```

</details>