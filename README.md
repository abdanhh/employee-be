# employee-be

## How To Run

1. Download atau Clone Repository ini. Nanti akan ada 1 folder bernama `employee-be`
2. Di dalam folder employee, ada file bernama `employee.sql`
3. Lalu buat Database PostgreSQL dengan nama `db_employee`
4. Lalu Execute SQL file bernama `employee.sql` pada `db_employee`
5. Sebelum running program, masuk ke direktori `employee-be\src\main\resources` dan buka file `application.properties`
6. Setelah membuka file `application.properties` sesuaikan 2 hal berikut: <br/>
`1. spring.datasource.url=jdbc:postgresql://localhost:5432/db_employee` ----> sesuaikan `db_employee` dengan **point 3** <br/>
`2. spring.datasource.password=postgres` ----> sesuaikan `postgres` dengan password postgreSQL anda <br/>
7. Jika sudah disesuaikan, buka Command Prompt / cmd, dan masuk ke direktori file `employee-be` berada
8. Setelah berada pada direktori `employee-be`, contoh : `C:\employee-be>`
9. Lalu ketikkan `mvn spring-boot:run` pada cmd tersebut untuk running program
10. Tunggu beberapa saat untuk proses compilenya.
11. Jika sudah berhasil compile, buka Browser untuk mencoba apakah program sudah berhasil running
12. Setelah buka browser, masukkan URL `localhost:8080/home` lalu enter
13. Jika program sudah berhasil dirunning, akan muncul Kalimat "Hello World" pada halaman browser
